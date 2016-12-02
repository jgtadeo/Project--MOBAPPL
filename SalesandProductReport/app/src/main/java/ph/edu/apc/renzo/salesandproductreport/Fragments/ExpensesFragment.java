package ph.edu.apc.renzo.salesandproductreport.Fragments;

import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 12/11/2016.
 */

public class ExpensesFragment extends Fragment implements View.OnClickListener{

    private Button addmore;
    private Button done;
    private EditText date, expense, totalcost;
    private TextView logout;
    private String dateEx, nameEx;
    private int totalcostEx = 0;

    public ExpensesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);

        //date = (EditText) view.findViewById(R.id.editText_date);
        //expense = (EditText) view.findViewById(R.id.editText_expense);
        //totalcost = (EditText) view.findViewById(R.id.editText_totalcost);

        //logout = (TextView)view.findViewById(R.id.textView_ExpensesLogout);
        logout.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        logout.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
