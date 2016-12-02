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
 * Created by Renzo on 11/11/2016.
 */

public class ProductsActivity extends AppCompatActivity {

    private TextView back;
    private EditText editProductName, editCategory, editCost, editPrice, editQuantity, editWeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        editProductName = (EditText)findViewById(R.id.editText_ProductName);
        editCategory = (EditText)findViewById(R.id.editText_ProductCategory);
        editCost = (EditText)findViewById(R.id.editText_ProductCost);
        editPrice = (EditText)findViewById(R.id.editText_ProductPrice);
        editQuantity = (EditText)findViewById(R.id.editText_ProductQuantity);
        editWeight = (EditText)findViewById(R.id.editText_ProductWeight);

        back();

    }

    private void back() {
        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ProductsActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
