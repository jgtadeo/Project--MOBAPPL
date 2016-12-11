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

import ph.edu.apc.renzo.salesandproductreport.Model.Products;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 12/11/2016.
 */

public class ListOfProductsFragment extends Fragment {

    private DatabaseReference database;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private String mUid;
    private RecyclerView pAdapter;
    private FirebaseRecyclerAdapter<Products, ProductsViewHolder> firebaseRecyclerAdapter;
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

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mUid = mUser.getUid();

        database = FirebaseDatabase.getInstance().getReference().child("users").child(mUid).child("products");

        pAdapter = (RecyclerView) view.findViewById(R.id.recyclerView);
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
            protected void populateViewHolder(ProductsViewHolder viewHolder, Products model, int position) {
                viewHolder.setExpiration_date(model.getExpiration_date());
                viewHolder.setProduct_name(model.getProduct_name());
                viewHolder.setCategory(model.getCategory());
                viewHolder.setCost(model.getCost());
                viewHolder.setPrice(model.getPrice());
                viewHolder.setQuantity(model.getQuantity());
                viewHolder.setWeight(model.getWeight());
            }


                /*TextView productDate = (TextView) view.findViewById(R.id.textView_ProductDate);
                TextView productName = (TextView) view.findViewById(R.id.textView_ProductName);
                TextView productCategory = (TextView) view.findViewById(R.id.textView_ProductCategory);
                TextView productPrice = (TextView) view.findViewById(R.id.textView_ProductPrice);
                TextView productCost = (TextView) view.findViewById(R.id.textView_ProductCost);
                TextView productQuantity = (TextView) view.findViewById(R.id.textView_ProductQuantity);
                TextView productWeight = (TextView) view.findViewById(R.id.textView_ProductWeight);*/

                /*viewHolder.setDate(model.getProductDate());
                viewHolder.setName(model.getProductName());
                viewHolder.setCategory(model.getProductCategory());
                viewHolder.setPrice(model.getProductPrice());
                viewHolder.setCost(model.getProductCost());
                viewHolder.setQuantity(model.getProductQuantity());
                viewHolder.setWeight(model.getProductWeight());*/

                /*productDate.setText(model.getProductDate());
                productName.setText(model.getProductName());
                productCategory.setText(model.getProductCategory());
                productPrice.setText((int) model.getProductPrice());
                productCost.setText((int) model.getProductCost());
                productQuantity.setText((int) model.getProductQuantity());
                productWeight.setText((int) model.getProductWeight());*/

            };

        pAdapter.setLayoutManager(LLM);
        pAdapter.setAdapter(firebaseRecyclerAdapter);

        return view;
        }

        /*firebaseRecyclerAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);

                int productCount = firebaseRecyclerAdapter.getItemCount();
                int visiblePosition = linearManager.findLastCompletelyVisibleItemPosition();

                if (visiblePosition == -1 || (positionStart >= (productCount - 1) && visiblePosition == (positionStart - 1))) {
                    pAdapter.scrollToPosition(positionStart);
                }
            }
        });

        pAdapter.setAdapter(firebaseRecyclerAdapter);
        pAdapter.setLayoutManager(linearManager);*/

        //displayProductList();

       /* FirebaseRecyclerAdapter<Products, ProductsHolder> Precycleradapter = new FirebaseRecyclerAdapter
                <Products, ProductsHolder>(Products.class, R.layout.product_row_layout, ProductsHolder.class,
                database.child("users").child(mUid).child(dateStamp).child("products").getRef()) {
            @Override
            protected void populateViewHolder(ProductsHolder viewHolder, Products model, int position) {
                viewHolder.productDate.setText(model.getProductD ate());
                viewHolder.productName.setText(model.getProductName());
                viewHolder.productCategory.setText(model.getProductCategory());
            }
        };*/

    public static class ProductsViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public ProductsViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setExpiration_date(String expiration_date) {
            TextView post_expiration_date = (TextView) mView.findViewById(R.id.textView_ProductDate);
            post_expiration_date.setText(expiration_date);
        }

        public void setProduct_name(String product_name) {
            TextView post_product_name = (TextView) mView.findViewById(R.id.textView_ProductName);
            post_product_name.setText(product_name);
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
