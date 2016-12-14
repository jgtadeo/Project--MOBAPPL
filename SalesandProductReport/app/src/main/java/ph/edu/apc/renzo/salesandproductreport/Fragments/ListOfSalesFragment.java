package ph.edu.apc.renzo.salesandproductreport.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import ph.edu.apc.renzo.salesandproductreport.Model.Sales;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 01/11/2016.
 */

public class ListOfSalesFragment extends Fragment {

    private DatabaseReference database;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseRecyclerAdapter<Sales, SalesViewHolder> firebaseRecyclerAdapter;

    private String mUid;

    private RecyclerView sAdapter;

    private LinearLayoutManager LLM;

    public ListOfSalesFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listofsales, container, false);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mUid = mUser.getUid();

        database = FirebaseDatabase.getInstance().getReference().child("users").child("sales");

        sAdapter = (RecyclerView) view.findViewById(R.id.recyclerViewS);
        sAdapter.setHasFixedSize(true);

        LLM = new LinearLayoutManager(getContext());
        LLM.setReverseLayout(true);
        LLM.setStackFromEnd(true);

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Sales, SalesViewHolder>(
                Sales.class,
                R.layout.sales_row_layout,
                SalesViewHolder.class,
                database) {
            @Override
            protected void populateViewHolder(SalesViewHolder viewHolder, Sales model, int position) {
                viewHolder.setDate(model.getDate());
                viewHolder.setGross(model.getGross());
                viewHolder.setBread(model.getBread());
                viewHolder.setGrocery(model.getGrocery());
                viewHolder.setComputed_gross(model.getComputed_gross());
                viewHolder.setEload(model.getEload());
                viewHolder.setSmart(model.getSmart());
                viewHolder.setGlobe(model.getGlobe());
                viewHolder.setSun(model.getSun());
                viewHolder.setComputed_eload(model.getComputed_eload());
            }
        };

        sAdapter.setLayoutManager(LLM);
        sAdapter.setAdapter(firebaseRecyclerAdapter);

        return view;
    }

    private static class SalesViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public SalesViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setDate(String date) {
            TextView post_date = (TextView) mView.findViewById(R.id.textView_SaleDate);
            post_date.setText("Date Entered: " + date);
        }

        public void setGross(double gross) {
            TextView post_gross = (TextView) mView.findViewById(R.id.textView_SaleGross);
            post_gross.setText("Entered Gross: " + Double.toString(gross));
        }

        public void setBread(double bread) {
            TextView post_bread = (TextView) mView.findViewById(R.id.textView_SaleBread);
            post_bread.setText("Number of Bread Sold: " + Double.toString(bread));
        }

        public void setGrocery(double grocery) {
            TextView post_grocery = (TextView) mView.findViewById(R.id.textView_SaleGrocery);
            post_grocery.setText("Number of Grocery Items Sold: " + Double.toString(grocery));
        }

        public void setComputed_gross(double computed_gross) {
            TextView post_computed_gross = (TextView) mView.findViewById(R.id.textView_SaleComputedGross);
            post_computed_gross.setText("Computed Gross: " + Double.toString(computed_gross));
        }

        public void setEload(double eload) {
            TextView post_eload = (TextView) mView.findViewById(R.id.textView_SaleEload);
            post_eload.setText("Entered E-load: " + Double.toString(eload));
        }

        public void setSmart(double smart) {
            TextView post_smart = (TextView) mView.findViewById(R.id.textView_SaleSmart);
            post_smart.setText("Smart Load: " + Double.toString(smart));
        }

        public void setGlobe(double globe) {
            TextView post_globe = (TextView) mView.findViewById(R.id.textView_SaleGlobe);
            post_globe.setText("Globe Load: " + Double.toString(globe));
        }

        public void setSun(double sun) {
            TextView post_sun = (TextView) mView.findViewById(R.id.textView_SaleSun);
            post_sun.setText("Sun Load: " + Double.toString(sun));
        }

        public void setComputed_eload(double computed_eload) {
            TextView post_computed_eload = (TextView) mView.findViewById(R.id.textView_SaleComputedEload);
            post_computed_eload.setText("Computed E-load: " + Double.toString(computed_eload));
        }
    }
}
