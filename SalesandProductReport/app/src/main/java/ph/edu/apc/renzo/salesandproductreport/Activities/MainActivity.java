package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 28/10/2016.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button sales, products, graph, expenses, records;
    private TextView logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sales = (Button)findViewById(R.id.button_MainSales);
        sales.setOnClickListener(this);

        products = (Button)findViewById(R.id.button_MainProducts);
        products.setOnClickListener(this);

        graph = (Button)findViewById(R.id.button_MainGraph);
        graph.setOnClickListener(this);

        expenses = (Button)findViewById(R.id.button_MainExpenses);
        expenses.setOnClickListener(this);

        records = (Button)findViewById(R.id.button_MainRecords);
        records.setOnClickListener(this);

        logout = (TextView)findViewById(R.id.textView_MainLogout);
        logout.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
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

            case R.id.button_MainProducts:
                Intent products = new Intent(MainActivity.this, ProductsActivity.class);
                startActivity(products);
                finish();
                break;

            case R.id.button_MainGraph:
                Intent graph = new Intent(MainActivity.this, GraphActivity.class);
                startActivity(graph);
                finish();
                break;

            case R.id.button_MainExpenses:
                Intent expenses = new Intent(MainActivity.this, ExpensesActivity.class);
                startActivity(expenses);
                finish();
                break;

            case R.id.button_MainRecords:
                Intent records = new Intent(MainActivity.this, RecordsActivity.class);
                startActivity(records);
                finish();
                break;

            case R.id.textView_MainLogout:
                AlertDialog DYWlogout = new AlertDialog.Builder(this).create();
                DYWlogout.setTitle("Logout");
                DYWlogout.setMessage("Do you really want to logout?");
                DYWlogout.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(logout);
                        finish();
                    }
                });
                DYWlogout.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                DYWlogout.show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog DYWlogout = new AlertDialog.Builder(this).create();
        DYWlogout.setTitle("Logout");
        DYWlogout.setMessage("Do you really want to logout?");
        DYWlogout.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(logout);
                finish();
            }
        });
        DYWlogout.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        DYWlogout.show();
    }
}
