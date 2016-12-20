package ph.edu.apc.renzo.salesandproductreport.Fragments;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ph.edu.apc.renzo.salesandproductreport.Model.Products;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 12/11/2016.
 */

public class ListOfProductsFragment extends Fragment {

    private DatabaseReference database;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseRecyclerAdapter<Products, ProductsViewHolder> firebaseRecyclerAdapter;

    private String mUid;

    private RecyclerView pAdapter;

    private LinearLayoutManager LLM;

    public ListOfProductsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_listofproducts, container, false);

        /*mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mUid = mUser.getUid();*/

        database = FirebaseDatabase.getInstance().getReference().child("users").child("products");

        pAdapter = (RecyclerView) view.findViewById(R.id.recyclerViewP);
        pAdapter.setHasFixedSize(true);

        LLM = new LinearLayoutManager(getContext());
        LLM.setReverseLayout(true);
        LLM.setStackFromEnd(true);

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Products, ProductsViewHolder>(
                Products.class,
                R.layout.product_row_layout,
                ProductsViewHolder.class,
                database) {
            @Override
            protected void populateViewHolder(ProductsViewHolder viewHolder, Products model, final int position) {
                viewHolder.setExpiration_date(model.getExpiration_date());
                viewHolder.setProduct_name(model.getProduct_name());
                viewHolder.setCategory(model.getCategory());
                viewHolder.setCost(model.getCost());
                viewHolder.setPrice(model.getPrice());
                viewHolder.setQuantity(model.getQuantity());
                viewHolder.setWeight(model.getWeight());

                viewHolder.mView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
                        build.setTitle("Delete data");
                        build.setMessage("Do you want to delete the data?");
                        build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                firebaseRecyclerAdapter.getRef(position).removeValue();
                                dialogInterface.dismiss();
                                Toast.makeText(getActivity(), "Successfully deleted data", Toast.LENGTH_SHORT).show();
                            }
                        });
                        build.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        build.show();
                        return true;
                    }
                });
            }
        };

        pAdapter.setLayoutManager(LLM);
        pAdapter.setAdapter(firebaseRecyclerAdapter);

        return view;
    }

    private static class ProductsViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public ProductsViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setExpiration_date(String expiration_date) {
            TextView post_expiration_date = (TextView) mView.findViewById(R.id.textView_ProductDate);
            post_expiration_date.setText("Expiration Date: " + expiration_date);
        }

        public void setProduct_name(String product_name) {
            TextView post_product_name = (TextView) mView.findViewById(R.id.textView_ProductName);
            post_product_name.setText("Product Name: " + product_name);
        }

        public void setCategory(String category) {
            TextView post_category = (TextView) mView.findViewById(R.id.textView_ProductCategory);
            post_category.setText("Category: " + category);
        }

        public void setCost(double cost) {
            TextView post_cost = (TextView) mView.findViewById(R.id.textView_ProductCost);
            post_cost.setText("Product Cost: " + Double.toString(cost));
        }

        public void setPrice(double price) {
            TextView post_price = (TextView) mView.findViewById(R.id.textView_ProductPrice);
            post_price.setText("Product Price: " + Double.toString(price));
        }

        public void setQuantity(double quantity) {
            TextView post_quantity = (TextView) mView.findViewById(R.id.textView_ProductQuantity);
            post_quantity.setText("Quantity: " + Double.toString(quantity));
        }

        public void setWeight(double weight) {
            TextView post_weight = (TextView) mView.findViewById(R.id.textView_ProductWeight);
            post_weight.setText("Weight: " + Double.toString(weight));
        }
    }
}
