# Double Tap View
[![GitHub version](https://badge.fury.io/gh/douglasspgyn%2FDoubleTapView.svg)](https://badge.fury.io/gh/douglasspgyn%2FDoubleTapView)
[![JitPack version](https://jitpack.io/v/douglasspgyn/DoubleTapView.svg)](https://jitpack.io/#douglasspgyn/DoubleTapView)

A fully customizable view with a cool animation when double tap it and a simple listener.

You can see a [Sample Project here](https://github.com/douglasspgyn/DoubleTapViewSample) and learn more on the [Wiki](https://github.com/douglasspgyn/DoubleTapView/wiki).

![](http://i.imgur.com/7reSNWr.gif) 

### XML:
```xml
<douglasspgyn.com.github.doubletapview.DoubleTapView
        android:id="@+id/doubleTapView"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:background="#CCC"
        app:animatedViewAnimation="@anim/bounce_in_out"
        app:animatedViewBackground="@drawable/background_view"
        app:animatedViewBackgroundColor="@color/colorPrimary"
        app:animatedViewDrawable="@drawable/ic_android"
        app:animatedViewDrawableColor="@color/colorAccent"
        app:animatedViewMeasure="100dp"
        app:backgroundScaleType="centerInside" />
```

### Programmatically:
```java
doubleTapView.setAnimatedViewAnimation(R.anim.bounce_in_out);

doubleTapView.setAnimatedViewBackground(R.drawable.background_view);

doubleTapView.setAnimatedViewBackgroundColor(R.color.colorPrimary);

doubleTapView.setAnimatedViewDrawable(R.drawable.ic_android);

doubleTapView.setAnimatedViewDrawableColor(R.color.colorAccent);

doubleTapView.setAnimatedViewMeasure(100);

doubleTapView.enableDoubleTap();
doubleTapView.disableDoubleTap();
doubleTapView.isDoubleTapEnabled()
```

### Listener:
```java
doubleTapView.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(context, "Double Tap Callback", Toast.LENGTH_SHORT).show();
            }
        });
        
doubleTapView.removeOnDoubleTapEventListener();
doubleTapView.getDoubleTapEventListener();
```

### Works with image libraries (like Picasso)
```java
Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(doubleTapView.getBackgroundImageView());
```

## Add to your project:

Add maven jitpack.io on Project Gradle:
```xml
 allprojects {
    repositories {
      maven { url 'https://jitpack.io' }
    }
 }
```

and de library dependence on Module Gradle:

```xml
 dependencies {
    compile 'com.github.douglasspgyn:DoubleTapView:0.5.0'
 }
```
