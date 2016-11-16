package ph.edu.apc.renzo.salesandproductreport.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ph.edu.apc.renzo.salesandproductreport.Model.Information;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 01/11/2016.
 */

public class SalesFragment extends Fragment {

    private EditText date, gross, bread, grocery, eload, smart, globe, sun;
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

                    Information information = new Information();
                    information.setDate(dateStr);
                    information.setGross(grossInt);
                    information.setBread(breadInt);
                    information.setGrocery(groceryInt);
                    information.setEload(eloadInt);
                    information.setSmart(smartInt);
                    information.setGlobe(globeInt);
                    information.setSun(sunInt);
                }
            }
        });
        return view;
    }

}


