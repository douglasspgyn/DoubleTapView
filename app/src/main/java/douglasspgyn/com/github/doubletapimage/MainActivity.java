package douglasspgyn.com.github.doubletapimage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.enable_callback)
    Button enableCallbackButton;
    @BindView(R.id.disable_callback)
    Button disableCallbackButton;
    @BindView(R.id.enable_doubletap)
    Button enableDoubleTapButton;
    @BindView(R.id.disable_doubletap)
    Button disableDoubleTapButton;

    @BindView(R.id.dt1)
    DoubleTapView doubleTapView1;
    @BindView(R.id.dt2)
    DoubleTapView doubleTapView2;
    @BindView(R.id.dt3)
    DoubleTapView doubleTapView3;
    @BindView(R.id.dt4)
    DoubleTapView doubleTapView4;
    @BindView(R.id.dt5)
    DoubleTapView doubleTapView5;
    @BindView(R.id.dt6)
    DoubleTapView doubleTapView6;
    @BindView(R.id.dt7)
    DoubleTapView doubleTapView7;
    @BindView(R.id.dt8)
    DoubleTapView doubleTapView8;

    private int enabledColor;
    private int disableColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        enabledColor = Color.parseColor("#888888");
        disableColor = Color.parseColor("#DDDDDD");

        enableCallbackButton.setBackgroundColor(disableColor);
        disableCallbackButton.setBackgroundColor(enabledColor);
        enableDoubleTapButton.setBackgroundColor(enabledColor);
        disableDoubleTapButton.setBackgroundColor(disableColor);
    }

    @OnClick(R.id.enable_callback)
    public void enableCallback() {
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

    @OnClick(R.id.disable_callback)
    public void disableCallback() {
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

    @OnClick(R.id.enable_doubletap)
    public void enableDoubleTap() {
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

    @OnClick(R.id.disable_doubletap)
    public void disableDoubleTap() {
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
