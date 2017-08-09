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
    private ImageView animatedView;

    GestureListener(Context context, ImageView animatedView) {
        this.context = context;
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
        return true;
    }
}
