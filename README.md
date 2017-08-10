# Double Tap View

A custom view with some cool animation when double tap it with an easy callback implementation.

For now you have a listener, enable and disable doubletap and can change the animated view background color, drawable and size in XML.

### Callback Example:
```
doubleTapView.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(context, "Double Tap Callback", Toast.LENGTH_SHORT).show();
            }
        });
```

### XML Example:
```
<douglasspgyn.com.github.doubletapview.DoubleTapView
                android:layout_width="200dp"
                android:layout_height="200dp"
                android:background="#ccc"
                app:animatedViewBackgroundColor="#AA55AA"
                app:animatedViewDrawable="@drawable/ic_android"
                app:animatedViewMeasure="100dp" />
```

###### I'm trying to improve it with custom animation, custom animated background shape and programmatically sets.
