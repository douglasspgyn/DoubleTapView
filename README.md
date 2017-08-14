# Double Tap View
[![GitHub version](https://badge.fury.io/gh/douglasspgyn%2FDoubleTapView.svg)](https://badge.fury.io/gh/douglasspgyn%2FDoubleTapView)
[![JitPack version](https://jitpack.io/v/douglasspgyn/DoubleTapView.svg)](https://jitpack.io/#douglasspgyn/DoubleTapView)

A custom view with some cool animation when double tap it and an easy callback implementation.

You have a listener, enable and disable double tap and can change the animated view animation, background shape, background color, drawable, size.

![](https://media.giphy.com/media/l41JFwECYpeyPknm0/giphy.gif) 

### XML:
```xml
<douglasspgyn.com.github.doubletapview.DoubleTapView
        android:id="@+id/doubleTapView"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:background="#CCC"
        app:animatedViewAnimation="@anim/bounce_in_out"
        app:animatedViewBackground="@drawable/background_view"
        app:animatedViewBackgroundColor="@color/colorAccent"
        app:animatedViewDrawable="@drawable/ic_android"
        app:animatedViewMeasure="100dp"
        app:backgroundScaleType="centerInside" />
```

### Programmatically:
```java
doubleTapView.setAnimatedViewAnimation(R.anim.bounce_in_out);

doubleTapView.setAnimatedViewBackground(R.drawable.background_view);
doubleTapView.setAnimatedViewDrawable(getResources().getDrawable(R.drawable.background_view));
doubleTapView.setAnimatedViewDrawable(ContextCompat.getDrawable(this, R.drawable.background_view));

doubleTapView.setAnimatedViewBackgroundColor("#FF4081");
doubleTapView.setAnimatedViewBackgroundColor(R.color.colorAccent);

doubleTapView.setAnimatedViewDrawable(R.drawable.ic_android);
doubleTapView.setAnimatedViewDrawable(getResources().getDrawable(R.drawable.ic_android));
doubleTapView.setAnimatedViewDrawable(ContextCompat.getDrawable(this, R.drawable.ic_android));

doubleTapView.setAnimatedViewMeasure(100);

doubleTapView.enableDoubleTap();
doubleTapView.disableDoubleTap();
doubleTapView.isDoubleTapEnabled()
```

### Callback:
```java
doubleTapView.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(context, "Double Tap Callback", Toast.LENGTH_SHORT).show();
            }
        });
        

doubleTapView.getDoubleTapEventListener();
doubleTapView.removeOnDoubleTapEventListener();
```

### Work with image libraries (like Picasso)
```java
Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(doubleTapView.getBackgroundImageView());
```
You can see a [Sample Project here](https://github.com/douglasspgyn/DoubleTapViewSample).

## Add to your project:

Add maven jitpack.io on Project Grable:
```xml
 allprojects {
    repositories {
      maven { url 'https://jitpack.io' }
    }
 }
```

and de lib dependence on Module Gradle:

```xml
 dependencies {
    compile 'com.github.douglasspgyn:DoubleTapView:0.4.0'
 }
```
