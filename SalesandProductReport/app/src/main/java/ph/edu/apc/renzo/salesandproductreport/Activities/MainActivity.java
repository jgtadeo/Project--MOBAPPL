package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 28/10/2016.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button sales;
    private TextView logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sales = (Button)findViewById(R.id.button_MainSales);
        sales.setOnClickListener(this);
        logout = (TextView)findViewById(R.id.textView_MainLogout);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_MainSales:
                Intent sales = new Intent(MainActivity.this, SalesActivity.class);
                startActivity(sales);
                finish();
                break;
            case R.id.textView_MainLogout:
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(logout);
                finish();
                break;
        }

    }
}
