package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.Calendar;

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

        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ProductsActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
