# Double Tap View
[![GitHub version](https://badge.fury.io/gh/douglasspgyn%2FDoubleTapView.svg)](https://badge.fury.io/gh/douglasspgyn%2FDoubleTapView)
[![JitPack version](https://jitpack.io/v/douglasspgyn/DoubleTapView.svg)](https://jitpack.io/#douglasspgyn/DoubleTapView)

A custom view with some cool animation when double tap it and an easy callback implementation.

For now you have a listener, enable and disable double tap and can change the animated view background color, drawable and size.

![](https://media.giphy.com/media/l41JFwECYpeyPknm0/giphy.gif) 

### XML:
```xml
<douglasspgyn.com.github.doubletapview.DoubleTapView
                android:layout_width="200dp"
                android:layout_height="200dp"
                android:background="#ccc"
                app:animatedViewBackgroundColor="#AA55AA"
                app:animatedViewDrawable="@drawable/ic_android"
                app:animatedViewMeasure="100dp" />
```

### Programmatically:
```java
doubleTapView.setAnimatedViewBackgroundColor("#3F51B5");
doubleTapView.setAnimatedViewBackgroundColor(R.color.colorPrimary);

doubleTapView.setAnimatedViewDrawable(R.drawable.ic_android);
doubleTapView.setAnimatedViewDrawable(getResources().getDrawable(R.drawable.ic_android));
doubleTapView.setAnimatedViewDrawable(ContextCompat.getDrawable(this, R.drawable.ic_android));

doubleTapView.setAnimatedViewMeasure(100);
```

### Callback Example:
```java
doubleTapView.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(context, "Double Tap Callback", Toast.LENGTH_SHORT).show();
            }
        });
```

You can see a [Sample Project here](https://github.com/douglasspgyn/DoubleTapViewSample).

## How to use

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
    compile 'com.github.douglasspgyn:DoubleTapView:0.1.1'
 }
```

###### I'm trying to improve it with custom animation and custom animated background shape.
