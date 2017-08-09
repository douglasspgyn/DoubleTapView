package douglasspgyn.com.github.doubletapimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
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

    private View rootView;
    private ImageView animatedView;

    private onDoubleTapEventListener doubleTapEventListener;

    private String animatedViewBackgroundColor;
    private Drawable animatedViewIcon;
    private int animatedViewMeasure;

    public DoubleTapView(Context context) {
        super(context);
        getTypedArray(null);
        init(context);
    }

    public DoubleTapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DoubleTapView);
        getTypedArray(typedArray);
        init(context);
        typedArray.recycle();
    }

    public DoubleTapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DoubleTapView, defStyleAttr, 0);
        getTypedArray(typedArray);
        init(context);
        typedArray.recycle();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DoubleTapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DoubleTapView, defStyleAttr, 0);
        getTypedArray(typedArray);
        init(context);
        typedArray.recycle();
    }

    private void getTypedArray(TypedArray typedArray) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56, getResources().getDisplayMetrics());
        animatedViewBackgroundColor = typedArray.getString(R.styleable.DoubleTapView_animatedViewBackgroundColor) != null ? typedArray.getString(R.styleable.DoubleTapView_animatedViewBackgroundColor) : "#" + Integer.toHexString(ContextCompat.getColor(getContext(), R.color.colorAccent));
        animatedViewIcon = typedArray.getDrawable(R.styleable.DoubleTapView_animatedViewDrawable);
        animatedViewMeasure = (int) typedArray.getDimension(R.styleable.DoubleTapView_animatedViewMeasure, px);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.double_view, this);
        animatedView = (ImageView) rootView.findViewById(R.id.animated_view);

        setAnimatedView(context);
        setDoubleTap(context);
    }

    private void setAnimatedView(Context context) {
        LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(context, R.drawable.animated_view);

        GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.animated_background);
        gradientDrawable.setColor(Color.parseColor(animatedViewBackgroundColor));

        layerDrawable.setDrawableByLayerId(R.id.animated_drawable, animatedViewIcon);
        animatedView.setImageDrawable(layerDrawable);

        animatedView.getLayoutParams().height = animatedView.getLayoutParams().width = animatedViewMeasure;
    }

    private void setDoubleTap(Context context) {
        final GestureDetector gestureDetector = new GestureDetector(context, new GestureListener(context, this, animatedView));
        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setOnDoubleTapEventListener(onDoubleTapEventListener eventListener) {
        doubleTapEventListener = eventListener;
    }

    public onDoubleTapEventListener getDoubleTapEventListener() {
        return doubleTapEventListener;
    }
}

interface onDoubleTapEventListener {
    void onDoubleTap();
}