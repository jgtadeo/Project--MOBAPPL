package ph.edu.apc.renzo.salesandproductreport.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ph.edu.apc.renzo.salesandproductreport.Activities.LoginActivity;
import ph.edu.apc.renzo.salesandproductreport.Model.Information;
import ph.edu.apc.renzo.salesandproductreport.Model.SalesProductDBAdapter;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 01/11/2016.
 */

public class SalesFragment extends Fragment implements View.OnClickListener{

    private SalesProductDBAdapter salesproductDBAdapter = new SalesProductDBAdapter(getContext());
    private EditText date, gross, bread, grocery, eload, smart, globe, sun;
    private TextView logout;
    private Button compute;
    private String dateStr;
    private int grossInt = 0, breadInt = 0, groceryInt = 0, eloadInt = 0, smartInt = 0, globeInt = 0, sunInt = 0;

    public SalesFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales, container, false);

        date = (EditText)view.findViewById(R.id.editText_SaleDate);
        gross = (EditText)view.findViewById(R.id.editText_SaleGross);
        bread = (EditText)view.findViewById(R.id.editText_SaleBread);
        grocery = (EditText)view.findViewById(R.id.editText_SaleGrocery);
        eload = (EditText)view.findViewById(R.id.editText_SaleEload);
        smart = (EditText)view.findViewById(R.id.editText_SaleSmart);
        globe = (EditText)view.findViewById(R.id.editText_SaleGlobe);
        sun = (EditText)view.findViewById(R.id.editText_SaleSun);

        logout = (TextView)view.findViewById(R.id.textView_SalesLogout);
        logout.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        logout.setOnClickListener(this);

        compute = (Button)view.findViewById(R.id.button_SalesCompute);
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (date.getText().toString().length() == 0) {
                    date.setError("Date is required");
                    return;
                } else if (gross.getText().toString().length() == 0) {
                    gross.setError("Gross Sale is required");
                    return;
                } else if (bread.getText().toString().length() == 0) {
                    bread.setError("Bread is required");
                    return;
                } else if (grocery.getText().toString().length() == 0) {
                    grocery.setError("Grocery is required");
                    return;
                } else if (eload.getText().toString().length() == 0) {
                    eload.setError("Eload is required");
                    return;
                } else if (smart.getText().toString().length() == 0) {
                    smart.setError("Smart is required");
                    return;
                } else if (globe.getText().toString().length() == 0) {
                    globe.setError("Globe is required");
                    return;
                } else if (sun.getText().toString().length() == 0) {
                    sun.setError("Sun is required");
                    return;
                } else {
                    dateStr = date.getText().toString();
                    grossInt = Integer.parseInt(gross.getText().toString());
                    breadInt = Integer.parseInt(bread.getText().toString());
                    groceryInt = Integer.parseInt(grocery.getText().toString());
                    eloadInt = Integer.parseInt(eload.getText().toString());
                    smartInt = Integer.parseInt(smart.getText().toString());
                    globeInt = Integer.parseInt(globe.getText().toString());
                    sunInt = Integer.parseInt(sun.getText().toString());

                    Information salesinformation = new Information();
                    salesinformation.setDate(dateStr);
                    salesinformation.setGross(grossInt);
                    salesinformation.setBread(breadInt);
                    salesinformation.setGrocery(groceryInt);
                    salesinformation.setEload(eloadInt);
                    salesinformation.setSmart(smartInt);
                    salesinformation.setGlobe(globeInt);
                    salesinformation.setSun(sunInt);

                    salesproductDBAdapter.insertSalesInformation(salesinformation);

                    Toast.makeText(getContext(), "All sales information has been saved", Toast.LENGTH_LONG).show();

                }
            }
        });
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView_SalesLogout:
                AlertDialog DYWlogout = new AlertDialog.Builder(getActivity()).create();
                DYWlogout.setTitle("Logout");
                DYWlogout.setMessage("Do you really want to logout?");
                DYWlogout.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent logout = new Intent(getActivity(), LoginActivity.class);
                        startActivity(logout);
                        getActivity().finish();
                    }
                });
                DYWlogout.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                DYWlogout.show();
                break;
        }
    }
}


