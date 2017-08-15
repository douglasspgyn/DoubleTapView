package douglasspgyn.com.github.doubletapview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Douglas on 08/08/17.
 */

public class DoubleTapView extends RelativeLayout {

    private Context context;
    private onDoubleTapEventListener doubleTapEventListener;
    private boolean doubleTapEnabled = true;

    private View rootView;
    private ImageView background;
    private ImageView animatedView;

    private int backgroundScaleType;
    private Drawable animatedViewBackground;
    private String animatedViewBackgroundColor;
    private Drawable animatedViewDrawable;
    private String animatedViewDrawableColor;
    private int animatedViewMeasure;
    @AnimRes
    private int animatedViewAnimation;

    public DoubleTapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DoubleTapView);
        init(context, typedArray);
    }

    /**
     * Inflate the animated view and set including the style attributes
     *
     * @param context    view context
     * @param typedArray array containing the style attributes
     */
    private void init(Context context, TypedArray typedArray) {
        this.context = context;
        getTypedArray(typedArray);

        rootView = inflate(context, R.layout.double_view, this);
        background = (ImageView) rootView.findViewById(R.id.background);
        animatedView = (ImageView) rootView.findViewById(R.id.animated_view);

        setBackgroundView();
        setAnimatedView();
        enableDoubleTap();
    }

    /**
     * Get the style attributes to set
     *
     * @param typedArray array containing the style attributes
     */
    private void getTypedArray(TypedArray typedArray) {
        backgroundScaleType = typedArray.getInt(R.styleable.DoubleTapView_backgroundScaleType, 3);
        animatedViewAnimation = typedArray.getResourceId(R.styleable.DoubleTapView_animatedViewAnimation, R.anim.bounce_in_out);
        animatedViewBackground = typedArray.getDrawable(R.styleable.DoubleTapView_animatedViewBackground) != null ? typedArray.getDrawable(R.styleable.DoubleTapView_animatedViewBackground) : ContextCompat.getDrawable(context, R.drawable.round_background_view);
        animatedViewBackgroundColor = typedArray.getString(R.styleable.DoubleTapView_animatedViewBackgroundColor) != null ? typedArray.getString(R.styleable.DoubleTapView_animatedViewBackgroundColor) : "#" + Integer.toHexString(ContextCompat.getColor(getContext(), R.color.colorAccent));
        animatedViewDrawable = typedArray.getDrawable(R.styleable.DoubleTapView_animatedViewDrawable) != null ? typedArray.getDrawable(R.styleable.DoubleTapView_animatedViewDrawable) : ContextCompat.getDrawable(context, R.drawable.transparent_view);
        animatedViewDrawableColor = typedArray.getString(R.styleable.DoubleTapView_animatedViewDrawableColor) != null ? typedArray.getString(R.styleable.DoubleTapView_animatedViewDrawableColor) : "#" + Integer.toHexString(ContextCompat.getColor(getContext(), R.color.colorWhite));
        animatedViewMeasure = (int) typedArray.getDimension(R.styleable.DoubleTapView_animatedViewMeasure, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56, getResources().getDisplayMetrics()));

        typedArray.recycle();
    }

    /**
     * Set the background view attributes
     */
    private void setBackgroundView() {
        background.setScaleType(ImageView.ScaleType.values()[backgroundScaleType]);
    }

    /**
     * Set the animated view attributes
     */
    private void setAnimatedView() {
        Drawable backgroundDrawable = DrawableCompat.wrap(animatedViewBackground);
        DrawableCompat.setTint(backgroundDrawable.mutate(), Color.parseColor(animatedViewBackgroundColor));

        Drawable iconDrawable = animatedViewDrawable;
        DrawableCompat.setTint(iconDrawable.mutate(), Color.parseColor(animatedViewDrawableColor));

        Drawable[] drawables = new Drawable[]{backgroundDrawable, iconDrawable};

        int drawableMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
        LayerDrawable layerDrawable = new LayerDrawable(drawables);
        layerDrawable.setLayerInset(1, drawableMargin, drawableMargin, drawableMargin, drawableMargin);

        animatedView.setImageDrawable(layerDrawable);

        animatedView.getLayoutParams().height = animatedView.getLayoutParams().width = animatedViewMeasure;
    }

    /**
     * Create a double tap listener
     *
     * @param eventListener double tap listener
     */
    public void setOnDoubleTapEventListener(onDoubleTapEventListener eventListener) {
        doubleTapEventListener = eventListener;
    }

    /**
     * Remove the existent double tap listener
     */
    public void removeOnDoubleTapEventListener() {
        doubleTapEventListener = null;
    }

    /**
     * Get the double tap listener
     *
     * @return double tap event listener
     */
    @Nullable
    public onDoubleTapEventListener getDoubleTapEventListener() {
        return doubleTapEventListener;
    }

    /**
     * Enable double tap
     * Consequently enable the callback, if exist
     */
    public void enableDoubleTap() {
        setDoubleTap(context);
        doubleTapEnabled = true;
    }

    /**
     * Disable double tap
     * Consequently disable the callback, if exist
     */
    public void disableDoubleTap() {
        setOnTouchListener(null);
        doubleTapEnabled = false;
    }

    /**
     * Check if the double tap is enable
     *
     * @return double tap is enable
     */
    public boolean isDoubleTapEnabled() {
        return doubleTapEnabled;
    }

    /**
     * Set the touch listener to enable the double tap animation and callback
     *
     * @param context view context
     */
    private void setDoubleTap(Context context) {
        final GestureDetector gestureDetector = new GestureDetector(context, new GestureListener(context, this));
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    /**
     * Getter used to change the double tap background
     *
     * @return the background image view
     */
    public ImageView getBackgroundImageView() {
        return background;
    }

    /**
     * Set the animated view background drawable
     *
     * @param drawable animated view background drawable
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewBackground(int drawable) {
        try {
            setAnimatedViewBackground(ContextCompat.getDrawable(context, drawable));
        } catch (Resources.NotFoundException rnf) {
            Log.d("setAnimatedBackground", rnf.getMessage());
        }
        return this;
    }

    /**
     * Set the animated view background drawable
     *
     * @param drawable animated view background drawable
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewBackground(Drawable drawable) {
        animatedViewBackground = drawable != null ? drawable : ContextCompat.getDrawable(context, R.drawable.round_background_view);
        setAnimatedView();
        return this;
    }

    /**
     * Set the animated view background color
     *
     * @param color animated view background color
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewBackgroundColor(int color) {
        setAnimatedViewBackgroundColor("#" + Integer.toHexString(ContextCompat.getColor(context, color)));
        return this;
    }

    /**
     * Set the animated view background color
     *
     * @param color animated view background color
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewBackgroundColor(String color) {
        try {
            Color.parseColor(color);
            animatedViewBackgroundColor = color;
            setAnimatedView();
        } catch (IllegalArgumentException iae) {
            Log.d("setAnimatedBgColor", iae.getMessage());
        }
        return this;
    }

    /**
     * Set the animated view drawable
     *
     * @param drawable animated view drawable
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewDrawable(int drawable) {
        try {
            setAnimatedViewDrawable(ContextCompat.getDrawable(context, drawable));
        } catch (Resources.NotFoundException rnf) {
            Log.d("setAnimatedDrawable", rnf.getMessage());
        }
        return this;
    }

    /**
     * Set the animated view drawable
     *
     * @param drawable animated view drawable
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewDrawable(Drawable drawable) {
        animatedViewDrawable = drawable != null ? drawable : ContextCompat.getDrawable(context, R.drawable.transparent_view);
        setAnimatedView();
        return this;
    }

    /**
     * Set the animated view drawable color
     *
     * @param color animated view drawable color
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewDrawableColor(int color) {
        setAnimatedViewDrawableColor("#" + Integer.toHexString(ContextCompat.getColor(context, color)));
        return this;
    }

    /**
     * Set the animated view drawable color
     *
     * @param color animated view drawable color
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewDrawableColor(String color) {
        try {
            Color.parseColor(color);
            animatedViewDrawableColor = color;
            setAnimatedView();
        } catch (IllegalArgumentException iae) {
            Log.d("setAnimatedBgColor", iae.getMessage());
        }
        return this;
    }

    /**
     * Set the animated view size (height and width)
     *
     * @param px animated view height and width
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewMeasure(int px) {
        animatedViewMeasure = px;
        setAnimatedView();
        return this;
    }


    /**
     * Set the animated view animation
     *
     * @param animation animation resource
     * @return current instance of the view
     */
    public DoubleTapView setAnimatedViewAnimation(@AnimRes int animation) {
        this.animatedViewAnimation = animation;
        return this;
    }

    /**
     * Getter used on GestureListener to get the image view that will be animated
     *
     * @return the image view that will be animated
     */
    protected ImageView getAnimatedView() {
        return animatedView;
    }


    /**
     * Getter used on GestureListener to get animation
     *
     * @return the animation that will animate
     */
    protected int getAnimatedViewAnimation() {
        return animatedViewAnimation;
    }

    /**
     * Callback of double tap event
     */
    public interface onDoubleTapEventListener {
        void onDoubleTap();
    }
}