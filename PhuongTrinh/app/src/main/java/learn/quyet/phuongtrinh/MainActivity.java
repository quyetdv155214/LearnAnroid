package learn.quyet.phuongtrinh;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;



import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tvA) TextView tvA;
    @BindView(R.id.tvB) TextView tvB;
    @BindView(R.id.tvResult) TextView tvResult;
    @BindView(R.id.txtA) TextView txtA;
    @BindView(R.id.txtB) TextView txtB;
    @BindView(R.id.txtC) TextView txtC;
    @BindView(R.id.btnSolve) TextView btnSolve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        setActicn();
    }
    private void setupUI(){
        tvA.setText(Html.fromHtml("X<sup>2</sup>"));
        tvB.setText("X");
    }
    private void setActicn(){
        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = solve();
                tvResult.setText(result);

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }
        });
    }

    private double getValue(TextView textView){
        double result =0 ;
        try {
            result = Double.parseDouble(textView.getText().toString());
        }catch (Exception e){
        }
        textView.setText(result + "");
        return result;
    }
    public String solve(){
        double a = getValue(txtA);
        double b = getValue(txtB);
        double c = getValue(txtC);
        double x1;
        double x2;
        String result ="";
        double delta;
        if(a==0){
            if(b==0){
                if(c==0){
                    result= "Phuong trinh vo so nghiem ";
                }
                else{
                    result="Phuong trinh vo nghiem ";
                }
            }
            else{
                x1=(-c)/b;
                result="Phuong trinh co nghiem duy nhat : " + x1;
            }
        }
        else{
            delta= (b*b)-(4*a*c);
            if(delta<0){
                result="Phuong trinh vo nghiem";
            }
            if(delta==0){
                x1= -b/(2*a);
                result="Phuong trinh co nghiem duy nhat x = " + x1;
            }
            if(delta>0){
                x1=(-b+Math.sqrt(delta))/(2*a);
                x2=(-b-Math.sqrt(delta))/(2*a);
                result="Phuong trinh co 2 nghiem :\n x1 =" + x1 +"\n x2 = " +x2;

            }
        }
        return result;
    }



}
