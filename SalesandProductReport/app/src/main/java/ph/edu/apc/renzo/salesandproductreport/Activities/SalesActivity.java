package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

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

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mUid = mUser.getUid();

        database = FirebaseDatabase.getInstance().getReference().child("users").child("sales");

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
                if (textDate.length() == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SalesActivity.this);
                    builder.setMessage("Please choose a date")
                            .setTitle("Unknown Date Error!")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                } else if (editGross.getText().toString().isEmpty()) {
                    //editGross.setError("Input gross");
                    return;
                } else if (editBread.getText().toString().isEmpty()) {
                    editBread.setError("Input bread");
                    return;
                } else if (editGrocery.getText().toString().isEmpty()) {
                    editGrocery.setError("Input grocery");
                    return;
                } else if (editEload.getText().toString().isEmpty()) {
                    editEload.setError("Input eload");
                    return;
                } else if (editSmart.getText().toString().isEmpty()) {
                    editSmart.setError("Input smart");
                    return;
                } else if (editGlobe.getText().toString().isEmpty()) {
                    editGlobe.setError("Input globe");
                    return;
                } else if (editSun.getText().toString().isEmpty()) {
                    editSun.setError("Input sun");
                    return;
                } else {
                    String Date = textDate.getText().toString();
                    Double Gross = Double.parseDouble(editGross.getText().toString());
                    Double Bread = Double.parseDouble(editBread.getText().toString());
                    Double Grocery = Double.parseDouble(editGrocery.getText().toString());
                    Double Eload = Double.parseDouble(editEload.getText().toString());
                    Double Smart = Double.parseDouble(editSmart.getText().toString());
                    Double Globe = Double.parseDouble(editGlobe.getText().toString());
                    Double Sun = Double.parseDouble(editSun.getText().toString());

                    addSales(Date, Gross, Bread, Grocery, Eload, Smart, Globe, Sun);
                }
                break;
            }
        }

    private void addSales(String Date, Double Gross, Double Bread, Double Grocery,
                          Double Eload, Double Smart, Double Globe, Double Sun) {

        double computeGross, computeEload;

        Log.d("debug", "Date:" + Date);
        Log.d("debug", "Gross:" + Gross);
        Log.d("debug", "Bread:" + Bread);
        Log.d("debug", "Grocery:" + Grocery);
        Log.d("debug", "Eload:" + Eload);
        Log.d("debug", "Smart:" + Smart);
        Log.d("debug", "Globe:" + Globe);
        Log.d("debug", "Sun:" + Sun);

        computeGross = Bread + Grocery;
        Log.d("debug", "Computed Gross:" + computeGross);

        computeEload = Smart + Globe + Sun;
        Log.d("debug", "Computed Eload:" + computeEload);

        DatabaseReference mData = database.push();

        mData.child("date").setValue(Date);
        mData.child("gross").setValue(Gross);
        mData.child("computed_gross").setValue(computeGross);
        mData.child("grocery").setValue(Grocery);
        mData.child("bread").setValue(Bread);
        mData.child("eload").setValue(Eload);
        mData.child("computed_eload").setValue(computeEload);
        mData.child("smart").setValue(Smart);
        mData.child("globe").setValue(Globe);
        mData.child("sun").setValue(Sun);

       /* database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("date: " + Date );
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("gross: " + Gross);
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("computed_gross: " + computeGross);
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("grocery: " + Grocery);
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("bread: " + Bread);
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("eload: " + Eload);
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("computed_eload: " + computeEload);
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("smart: " + Smart);
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("globe: " + Globe);
        database.child("users").child(mUid).child(dateStamp).child("sales").push().setValue("sun: " + Sun);*/

        Toast.makeText(this, "All information has been saved!", Toast.LENGTH_LONG).show();

        textDate.setText("");
        editGross.setText("");
        editBread.setText("");
        editGrocery.setText("");
        editEload.setText("");
        editSmart.setText("");
        editGlobe.setText("");
        editSun.setText("");
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(SalesActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
