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

import java.text.DateFormat;
import java.util.Date;

import ph.edu.apc.renzo.salesandproductreport.Model.Expenses;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 12/11/2016.
 */

public class ListOfExpensesFragment extends Fragment {

    private DatabaseReference database;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseRecyclerAdapter<Expenses, ExpensesViewHolder> firebaseRecyclerAdapter;

    private String mUid;

    private RecyclerView eAdapter;

    private LinearLayoutManager LLM;

    public ListOfExpensesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listofexpenses, container, false);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mUid = mUser.getUid();

        String currentDate = DateFormat.getDateInstance().format(new Date());

        database = FirebaseDatabase.getInstance().getReference().child("users").child("expenses");

        eAdapter = (RecyclerView) view.findViewById(R.id.recyclerViewE);
        eAdapter.setHasFixedSize(true);

        LLM = new LinearLayoutManager(getContext());
        LLM.setReverseLayout(true);
        LLM.setStackFromEnd(true);

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Expenses, ExpensesViewHolder>(
                Expenses.class,
                R.layout.expense_row_layout,
                ExpensesViewHolder.class,
                database) {
            @Override
            protected void populateViewHolder(ExpensesViewHolder viewHolder, Expenses model, final int position) {
                viewHolder.setDate(model.getDate());
                viewHolder.setExpense_name(model.getExpense_name());
                viewHolder.setExpense_cost(model.getExpense_cost());

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

        eAdapter.setLayoutManager(LLM);
        eAdapter.setAdapter(firebaseRecyclerAdapter);

        return view;
    }

    private static class ExpensesViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public ExpensesViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setDate(String date) {
            TextView post_date = (TextView) mView.findViewById(R.id.textView_ExpenseDate);
            post_date.setText("Date Entered: " + date);
        }

        public void setExpense_name(String expense_name) {
            TextView post_expense_name = (TextView) mView.findViewById(R.id.textView_ExpenseName);
            post_expense_name.setText("Expense Name: " + expense_name);
        }

        public void setExpense_cost(double expense_cost) {
            TextView post_expense_cost = (TextView) mView.findViewById(R.id.textView_ExpenseCost);
            post_expense_cost.setText("Expense cost: " + Double.toString(expense_cost));
        }
    }
}
