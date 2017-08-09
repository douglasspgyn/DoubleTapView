package douglasspgyn.com.github.doubletapimage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Douglas on 08/08/17.
 */

class GestureListener extends GestureDetector.SimpleOnGestureListener {

    private Context context;
    private DoubleTapView doubleTapView;
    private ImageView animatedView;

    GestureListener(Context context, DoubleTapView doubleTapView, ImageView animatedView) {
        this.context = context;
        this.doubleTapView = doubleTapView;
        this.animatedView = animatedView;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Animation pulse = AnimationUtils.loadAnimation(context, R.anim.bounce_in_out);
        animatedView.startAnimation(pulse);

        if (doubleTapView.getDoubleTapEventListener() != null) {
            doubleTapView.getDoubleTapEventListener().onDoubleTap();
        }

        return true;
    }
}
