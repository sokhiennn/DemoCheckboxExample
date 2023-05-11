package sg.edu.rp.c346.id22013179.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbEnabled = findViewById(R.id.checkBoxDiscount);
        Button btnCheck = findViewById(R.id.buttonCheck);
        TextView tvShow = findViewById(R.id.textView);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                if (cbEnabled.isChecked()) {
                    double pay = calcPay(100, 20);
                    tvShow.setText("The discount is given. You need to pay " + pay);
                } else {
                    double pay = calcPay(100, 0);
                    tvShow.setText("The discount is not given. You need to pay " + pay);
                }
            }

        });

        Log.i("MyActivity", "Inside onClick()");
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = cbEnabled.isChecked();

                Toast.makeText(MainActivity.this, "Button Click", Toast.LENGTH_LONG).show();

                String discountState;
                if (isChecked) {
                    discountState = "given";
                } else {
                    discountState = "not given";
                }

                tvShow.setText("The discount is " + discountState);
            }

        });
    }
    private double calcPay(double price, double discount){
        double pay = price*(1-discount/100);
        return pay;
    }
}

