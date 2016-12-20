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

public class ExpensesActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView back, textDate;
    private Button addDate, add;
    private EditText expenseName, expenseCost;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(this);
        textDate = (TextView)findViewById(R.id.textView_ExpensesDate);

        addDate = (Button)findViewById(R.id.button_ExpensesAddDate);
        addDate.setOnClickListener(this);

        expenseName = (EditText) findViewById(R.id.editText_ExpenseName);
        expenseCost = (EditText)findViewById(R.id.editText_ExpenseCost);

        add = (Button)findViewById(R.id.button_ExpensesAdd);
        add.setOnClickListener(this);

        database = FirebaseDatabase.getInstance().getReference().child("users").child("expenses");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_BackElous:
                Intent back = new Intent(ExpensesActivity.this, MainActivity.class);
                startActivity(back);
                finish();
                break;

            case R.id.button_ExpensesAddDate:
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

            case R.id.button_ExpensesAdd:
                if (textDate.length() == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ExpensesActivity.this);
                    builder.setMessage("Please choose a date")
                            .setTitle("Unknown Date Error!")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                } else if (expenseName.getText().toString().isEmpty()) {
                    expenseName.setError("Input expense name");
                    return;
                } else if (expenseCost.getText().toString().isEmpty()) {
                    expenseCost.setError("Input expense cost");
                    return;
                } else {
                    String Date = textDate.getText().toString();
                    String ExpenseName = expenseName.getText().toString();
                    Double ExpenseCost = Double.parseDouble(expenseCost.getText().toString());

                    addExpense(Date, ExpenseName, ExpenseCost);
                }
                break;
            }
        }

    private void addExpense(String Date, String ExpenseName, Double ExpenseCost) {

        Log.d("debug", "Date:" + Date);
        Log.d("debug", "Expenses name:" + ExpenseName);
        Log.d("debug", "Expenses cost:" + ExpenseCost);

        DatabaseReference mData = database.push();

        mData.child("date").setValue(Date);
        mData.child("expense_name").setValue(ExpenseName);
        mData.child("expense_cost").setValue(ExpenseCost);

        Toast.makeText(this, "All information has been saved!", Toast.LENGTH_LONG).show();

        textDate.setText("");
        expenseName.setText("");
        expenseCost.setText("");
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ExpensesActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
