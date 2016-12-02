package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 29/10/2016.
 */

public class SalesActivity extends AppCompatActivity {

    private EditText date, gross, bread, grocery, eload, smart, globe, sun;
    private TextView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        date = (EditText)findViewById(R.id.editText_SaleDate);
        gross = (EditText)findViewById(R.id.editText_SaleGross);
        bread = (EditText)findViewById(R.id.editText_SaleBread);
        grocery = (EditText)findViewById(R.id.editText_SaleGrocery);
        eload = (EditText)findViewById(R.id.editText_SaleEload);
        smart = (EditText)findViewById(R.id.editText_SaleSmart);
        globe = (EditText)findViewById(R.id.editText_SaleGlobe);
        sun = (EditText)findViewById(R.id.editText_SaleSun);

        back();

    }

    private void back() {
        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(SalesActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(SalesActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
