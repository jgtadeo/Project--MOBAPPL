package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import ph.edu.apc.renzo.salesandproductreport.Model.Sales;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 29/10/2016.
 */

public class SalesActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editGross, editBread, editGrocery, editEload, editSmart, editGlobe, editSun;
    private TextView back, textDate;
    private Button addDate, compute;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference database;
    private String mUid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        textDate = (TextView)findViewById(R.id.textView_SaleDate);
        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(this);

        editGross = (EditText)findViewById(R.id.editText_SaleGross);
        editBread = (EditText)findViewById(R.id.editText_SaleBread);
        editGrocery = (EditText)findViewById(R.id.editText_SaleGrocery);
        editEload = (EditText)findViewById(R.id.editText_SaleEload);
        editSmart = (EditText)findViewById(R.id.editText_SaleSmart);
        editGlobe = (EditText)findViewById(R.id.editText_SaleGlobe);
        editSun = (EditText)findViewById(R.id.editText_SaleSun);

        addDate = (Button)findViewById(R.id.button_SalesAddDate);
        addDate.setOnClickListener(this);

        compute = (Button)findViewById(R.id.button_SalesCompute);
        compute.setOnClickListener(this);

        database = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_BackElous:
                Intent back = new Intent(SalesActivity.this, MainActivity.class);
                startActivity(back);
                finish();
                break;

            case R.id.button_SalesAddDate:
                Calendar c = Calendar.getInstance();
                int year_x = c.get(Calendar.YEAR);
                int month_x = c.get(Calendar.MONTH);
                int day_x = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year_x, month_x, day_x);
                date.show();
                break;

            case R.id.button_SalesCompute:
                String Date = textDate.getText().toString();
                Double Gross = Double.valueOf(String.valueOf(Double.parseDouble(editGross.getText().toString())));
                Double Bread = Double.valueOf(String.valueOf(Double.parseDouble(editBread.getText().toString())));
                Double Grocery = Double.valueOf(String.valueOf(Double.parseDouble(editGrocery.getText().toString())));
                Double Eload = Double.valueOf(String.valueOf(Double.parseDouble(editEload.getText().toString())));
                Double Smart = Double.valueOf(String.valueOf(Double.parseDouble(editSmart.getText().toString())));
                Double Globe = Double.valueOf(String.valueOf(Double.parseDouble(editGlobe.getText().toString())));
                Double Sun = Double.valueOf(String.valueOf(Double.parseDouble(editSun.getText().toString())));

                addSales(Date, Gross, Bread, Grocery, Eload, Smart, Globe, Sun);
        }
    }

    private void addSales(String Date, Double Gross, Double Bread, Double Grocery, Double Eload, Double Smart, Double Globe, Double Sun) {

        double computeGross, computeEload;

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mUid = mUser.getUid();

        Log.d("debug", "Date:" + Date);
        Log.d("debug", "Gross:" + Gross);
        Log.d("debug", "Bread:" + Bread);
        Log.d("debug", "Grocery:" + Grocery);
        Log.d("debug", "Eload:" + Eload);
        Log.d("debug", "Smart:" + Smart);
        Log.d("debug", "Globe:" + Globe);
        Log.d("debug", "Sun:" + Sun);

        Sales sales = new Sales(Date, Gross, Bread, Grocery, Eload, Smart, Globe, Sun);

        computeGross = Bread + Grocery;
        Log.d("debug", "Computed Gross:" + computeGross);

        computeEload = Smart + Globe + Sun;
        Log.d("debug", "Computed Eload:" + computeEload);

        database.child("users").child(mUid);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(SalesActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
