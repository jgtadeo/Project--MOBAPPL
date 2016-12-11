package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import java.util.HashMap;
import java.util.Map;

import ph.edu.apc.renzo.salesandproductreport.Model.Products;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 11/11/2016.
 */

public class ProductsActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView back, textDate;
    private EditText editProductName, editCategory, editCost, editPrice, editQuantity, editWeight;
    private Button addDate, add;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference database;
    private String mUid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(this);

        editProductName = (EditText)findViewById(R.id.editText_ProductName);
        editCategory = (EditText)findViewById(R.id.editText_ProductCategory);
        editCost = (EditText)findViewById(R.id.editText_ProductCost);
        editPrice = (EditText)findViewById(R.id.editText_ProductPrice);
        editQuantity = (EditText)findViewById(R.id.editText_ProductQuantity);
        editWeight = (EditText)findViewById(R.id.editText_ProductWeight);

        textDate = (TextView)findViewById(R.id.textView_ProductDate);

        addDate = (Button)findViewById(R.id.button_ProductAddDate);
        addDate.setOnClickListener(this);
        add = (Button)findViewById(R.id.button_ProductsAdd);
        add.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mUid = mUser.getUid();

        database = FirebaseDatabase.getInstance().getReference().child("users").child(mUid).child("products");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_BackElous:
                Intent back = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(back);
                finish();
                break;

            case R.id.button_ProductAddDate:
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

            case R.id.button_ProductsAdd:
                if (textDate.length() == 0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductsActivity.this);
                    builder.setMessage("Please choose a date")
                            .setTitle("Unknown Date Error!!!")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }else if (editProductName.getText().toString().isEmpty()){
                    editProductName.setError("Input Product name!!!!!!!!!!!!!!!!!!!!!!!!!");
                    return;
                }else if (editCategory.getText().toString().isEmpty()){
                    editCategory.setError("Input Product Name!!!");
                    return;
                }else if(editCost.getText().toString().isEmpty()){
                    editCost.setError("Input Cost!");
                    return;
                }else if (editPrice.getText().toString().isEmpty()){
                    editPrice.setError("Input Price");
                    return;
                }else if (editQuantity.getText().toString().isEmpty()){
                    editQuantity.setError("Input quantity");
                    return;
                }else if (editWeight.getText().toString().isEmpty()){
                    editWeight.setError("Input weight");
                    return;
                }else {
                    String Date = textDate.getText().toString();
                    String ProductName = editProductName.getText().toString();
                    String Category = editCategory.getText().toString();
                    Double Cost = Double.parseDouble(editCost.getText().toString());
                    Double Price = Double.parseDouble(editPrice.getText().toString());
                    Double Quantity = Double.parseDouble(editQuantity.getText().toString());
                    Double Weight = Double.parseDouble(editWeight.getText().toString());

                    addProduct(Date, ProductName, Category, Cost, Price, Quantity, Weight);
                }
                break;
            }
        }

    private void addProduct(String Date, String ProductName, String Category, Double Cost,
                            Double Price, Double Quantity, Double Weight) {

        Log.d("debug", "Date:" + Date);
        Log.d("debug", "Product name:" + ProductName);
        Log.d("debug", "Category:" + Category);
        Log.d("debug", "Cost:" + Cost);
        Log.d("debug", "Price:" + Price);
        Log.d("debug", "Quantity:" + Quantity);
        Log.d("debug", "Weight:" + Weight);

        DatabaseReference mData = database.push();

        mData.child("expiration_date").setValue(Date);
        mData.child("product_name").setValue(ProductName);
        mData.child("category").setValue(Category);
        mData.child("cost").setValue(Cost);
        mData.child("price").setValue(Price);
        mData.child("quantity").setValue(Quantity);
        mData.child("weight").setValue(Weight);

        /*database.child("users").child(mUid).child(dateStamp).child("products").push().setValue("date: " + Date);
        database.child("users").child(mUid).child(dateStamp).child("products").push().setValue("product name: " + ProductName);
        database.child("users").child(mUid).child(dateStamp).child("products").push().setValue("category: " + Category);
        database.child("users").child(mUid).child(dateStamp).child("products").push().setValue("cost: " + Cost);
        database.child("users").child(mUid).child(dateStamp).child("products").push().setValue("Price: " + Price);
        database.child("users").child(mUid).child(dateStamp).child("products").push().setValue("quantity: " + Quantity);
        database.child("users").child(mUid).child(dateStamp).child("products").push().setValue("weight: " + Weight);*/

        Toast.makeText(this, "All information has been saved!", Toast.LENGTH_LONG).show();

        textDate.setText("");
        editProductName.setText("");
        editCategory.setText("");
        editCost.setText("");
        editPrice.setText("");
        editQuantity.setText("");
        editWeight.setText("");
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ProductsActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
