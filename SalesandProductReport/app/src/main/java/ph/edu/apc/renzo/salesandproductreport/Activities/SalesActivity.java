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

import ph.edu.apc.renzo.salesandproductreport.Fragments.ListOfSalesFragment;
import ph.edu.apc.renzo.salesandproductreport.Fragments.SalesFragment;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 29/10/2016.
 */

public class SalesActivity extends AppCompatActivity {

    private TextView back;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        back();

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void back() {
        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(SalesActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setText("INPUT SALES");
        tabLayout.getTabAt(1).setText("LIST OF SALES");
    }

    protected void setupViewPager(ViewPager viewPager) {

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new SalesFragment(), "");
        adapter.addFragment(new ListOfSalesFragment(), "");
        viewPager.setAdapter(adapter);
    }

    class ViewPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> sFragmentList = new ArrayList<>();
        private final List<String> sFragmentTitleList = new ArrayList<>();

        public ViewPageAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return sFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return sFragmentList.size();
        }

        public void addFragment(SalesFragment fragment, String title) {
            sFragmentList.add(fragment);
            sFragmentTitleList.add(title);
        }

        public void addFragment(ListOfSalesFragment fragment, String title) {
            sFragmentList.add(fragment);
            sFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return sFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(SalesActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
