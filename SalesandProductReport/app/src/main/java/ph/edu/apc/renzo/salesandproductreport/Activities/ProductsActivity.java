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

import ph.edu.apc.renzo.salesandproductreport.Fragments.ListOfProductsFragment;
import ph.edu.apc.renzo.salesandproductreport.Fragments.ProductsFragment;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 11/11/2016.
 */

public class ProductsActivity extends AppCompatActivity {

    private TextView back;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

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
                Intent back = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    protected void setupTabIcons() {
        tabLayout.getTabAt(0).setText("INPUT PRODUCTS");
        tabLayout.getTabAt(1).setText("LIST OF PRODUCTS");
    }

    protected void setupViewPager(ViewPager viewPager) {
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProductsFragment(), "");
        adapter.addFragment(new ListOfProductsFragment(), "");
        viewPager.setAdapter(adapter);
    }

    class ViewPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> pFragmentList = new ArrayList<>();
        private final List<String> pFragmentTitleList = new ArrayList<>();

        public ViewPageAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return pFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return pFragmentList.size();
        }

        public void addFragment(ProductsFragment fragment, String title) {
            pFragmentList.add(fragment);
            pFragmentTitleList.add(title);
        }

        public void addFragment(ListOfProductsFragment fragment, String title) {
            pFragmentList.add(fragment);
            pFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ProductsActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
