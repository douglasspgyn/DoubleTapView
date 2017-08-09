package douglasspgyn.com.github.doubletapimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dt1)
    DoubleTapView doubleTapView1;
    @BindView(R.id.dt4)
    DoubleTapView doubleTapView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        doubleTapView1.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "GG 1", Toast.LENGTH_SHORT).show();
            }
        });

        doubleTapView4.setOnDoubleTapEventListener(new DoubleTapView.onDoubleTapEventListener() {
            @Override
            public void onDoubleTap() {
                Toast.makeText(MainActivity.this, "GG 4", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
