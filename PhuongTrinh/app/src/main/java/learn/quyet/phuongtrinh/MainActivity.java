package learn.quyet.phuongtrinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tvA) TextView tvA;
    @BindView(R.id.tvB) TextView tvB;
    @BindView(R.id.txtA) TextView txtA;
    @BindView(R.id.txtB) TextView txtB;
    @BindView(R.id.txtC) TextView txtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }
    private void setupUI(){
        tvA.setText(Html.fromHtml("X<sup>2</sup>"));
        tvB.setText("X");
    }

}
