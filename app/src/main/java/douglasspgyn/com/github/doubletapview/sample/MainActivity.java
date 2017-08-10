package douglasspgyn.com.github.doubletapview.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import douglasspgyn.com.github.doubletapview.DoubleTapView;
import douglasspgyn.com.github.doubletapview.R;

public class MainActivity extends AppCompatActivity {

    private Button enableCallbackButton;
    private Button disableCallbackButton;
    private Button enableDoubleTapButton;
    private Button disableDoubleTapButton;

    private DoubleTapView doubleTapView1;
    private DoubleTapView doubleTapView2;
    private DoubleTapView doubleTapView3;
    private DoubleTapView doubleTapView4;
    private DoubleTapView doubleTapView5;
    private DoubleTapView doubleTapView6;
    private DoubleTapView doubleTapView7;
    private DoubleTapView doubleTapView8;

    private int enabledColor;
    private int disableColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        setColors();
        setListeners();

        doubleTapView5.setAnimatedViewBackgroundColor("#3F51B5");
        //doubleTapView5.setAnimatedViewBackgroundColor(R.color.colorPrimary);
        doubleTapView5.setAnimatedViewDrawable(R.drawable.ic_android);
        //doubleTapView5.setAnimatedViewDrawable(getResources().getDrawable(R.drawable.ic_android));
        //doubleTapView5.setAnimatedViewDrawable(ContextCompat.getDrawable(this, R.drawable.ic_android));
        doubleTapView5.setAnimatedViewMeasure(100);
    }

    private void bindView() {
        enableCallbackButton = (Button) findViewById(R.id.enable_callback);
        disableCallbackButton = (Button) findViewById(R.id.disable_callback);
        enableDoubleTapButton = (Button) findViewById(R.id.enable_doubletap);
        disableDoubleTapButton = (Button) findViewById(R.id.disable_doubletap);

        doubleTapView1 = (DoubleTapView) findViewById(R.id.dt1);
        doubleTapView2 = (DoubleTapView) findViewById(R.id.dt2);
        doubleTapView3 = (DoubleTapView) findViewById(R.id.dt3);
        doubleTapView4 = (DoubleTapView) findViewById(R.id.dt4);
        doubleTapView5 = (DoubleTapView) findViewById(R.id.dt5);
        doubleTapView6 = (DoubleTapView) findViewById(R.id.dt6);
        doubleTapView7 = (DoubleTapView) findViewById(R.id.dt7);
        doubleTapView8 = (DoubleTapView) findViewById(R.id.dt8);
    }

    private void setColors() {
        enabledColor = Color.parseColor("#888888");
        disableColor = Color.parseColor("#DDDDDD");

        enableCallbackButton.setBackgroundColor(disableColor);
        disableCallbackButton.setBackgroundColor(enabledColor);
        enableDoubleTapButton.setBackgroundColor(enabledColor);
        disableDoubleTapButton.setBackgroundColor(disableColor);
    }

    private void setListeners() {
        enableCallbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableCallback();
            }
        });

        disableCallbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableCallback();
            }
        });

        enableDoubleTapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableDoubleTap();
            }
        });

        disableDoubleTapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableDoubleTap();
            }
        });
    }

    private void enableCallback() {
        enableCallbackButton.setBackgroundColor(enabledColor);
        disableCallbackButton.setBackgroundColor(disableColor);

        doubleTapView1.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
        });

        doubleTapView2.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        });

        doubleTapView3.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
            }
        });

        doubleTapView4.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
            }
        });

        doubleTapView5.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
            }
        });

        doubleTapView6.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "6", Toast.LENGTH_SHORT).show();
            }
        });

        doubleTapView7.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "7", Toast.LENGTH_SHORT).show();
            }
        });

        doubleTapView8.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "8", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void disableCallback() {
        enableCallbackButton.setBackgroundColor(disableColor);
        disableCallbackButton.setBackgroundColor(enabledColor);

        doubleTapView1.removeOnDoubleTapEventListener();
        doubleTapView2.removeOnDoubleTapEventListener();
        doubleTapView3.removeOnDoubleTapEventListener();
        doubleTapView4.removeOnDoubleTapEventListener();
        doubleTapView5.removeOnDoubleTapEventListener();
        doubleTapView6.removeOnDoubleTapEventListener();
        doubleTapView7.removeOnDoubleTapEventListener();
        doubleTapView8.removeOnDoubleTapEventListener();
    }

    private void enableDoubleTap() {
        enableDoubleTapButton.setBackgroundColor(enabledColor);
        disableDoubleTapButton.setBackgroundColor(disableColor);

        doubleTapView1.enableDoubleTap();
        doubleTapView2.enableDoubleTap();
        doubleTapView3.enableDoubleTap();
        doubleTapView4.enableDoubleTap();
        doubleTapView5.enableDoubleTap();
        doubleTapView6.enableDoubleTap();
        doubleTapView7.enableDoubleTap();
        doubleTapView8.enableDoubleTap();
    }

    private void disableDoubleTap() {
        enableDoubleTapButton.setBackgroundColor(disableColor);
        disableDoubleTapButton.setBackgroundColor(enabledColor);

        doubleTapView1.disableDoubleTap();
        doubleTapView2.disableDoubleTap();
        doubleTapView3.disableDoubleTap();
        doubleTapView4.disableDoubleTap();
        doubleTapView5.disableDoubleTap();
        doubleTapView6.disableDoubleTap();
        doubleTapView7.disableDoubleTap();
        doubleTapView8.disableDoubleTap();
    }
}
