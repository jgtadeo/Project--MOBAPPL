package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ph.edu.apc.renzo.salesandproductreport.Fragments.ExpensesFragment;
import ph.edu.apc.renzo.salesandproductreport.Fragments.ListOfExpensesFragment;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 11/11/2016.
 */

public class ExpensesActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView back, textDate;
    private Button addDate, add, done;
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

        add = (Button)findViewById(R.id.button_ExpensesAdd);
        add.setOnClickListener(this);
        done = (Button)findViewById(R.id.button_ExpensesDone);
        done.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ExpensesActivity.this, MainActivity.class);
        startActivity(back);
        finish();
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


                break;

            case R.id.button_ExpensesDone:


                break;
        }
    }
}
