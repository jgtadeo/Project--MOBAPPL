package ph.edu.apc.renzo.salesandproductreport.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 01/11/2016.
 */

public class SalesFragment extends Fragment {

    private EditText date, gross, bread, grocery, eload, smart, globe, sun;
    private Button compute;
    private String dateStr;
    private float grossFlt, breadFlt, groceryFlt;
    private int eloadFlt, smartFlt, globeFlt, sunFlt;

    public SalesFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
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
                dateStr = date.getText().toString();
                grossFlt = Float.parseFloat(gross.getText().toString());
                breadFlt = Float.parseFloat(bread.getText().toString());
                groceryFlt = Float.parseFloat(grocery.getText().toString());
                eloadFlt = Integer.parseInt(eload.getText().toString());
                smartFlt = Integer.parseInt(smart.getText().toString());
                globeFlt = Integer.parseInt(globe.getText().toString());
                sunFlt = Integer.parseInt(sun.getText().toString());

            }
        });
        return view;
    }

}


