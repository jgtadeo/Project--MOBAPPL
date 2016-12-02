package ph.edu.apc.renzo.salesandproductreport.Activities;

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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ph.edu.apc.renzo.salesandproductreport.Fragments.ExpensesFragment;
import ph.edu.apc.renzo.salesandproductreport.Fragments.ListOfExpensesFragment;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 11/11/2016.
 */

public class ExpensesActivity extends AppCompatActivity {

    private TextView back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        back();

    }

    private void back() {
        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ExpensesActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ExpensesActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
