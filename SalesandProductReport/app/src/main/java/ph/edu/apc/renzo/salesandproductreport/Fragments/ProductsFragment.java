package ph.edu.apc.renzo.salesandproductreport.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.preference.DialogPreference;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import ph.edu.apc.renzo.salesandproductreport.Activities.LoginActivity;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 12/11/2016.
 */

public class ProductsFragment extends Fragment implements View.OnClickListener {

    private TextView logout;

    public ProductsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        logout = (TextView)view.findViewById(R.id.textView_ProductsLogout);
        logout.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        logout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView_ProductsLogout:
                AlertDialog DYWLogout = new AlertDialog.Builder(getActivity()).create();
                DYWLogout.setTitle("Logout");
                DYWLogout.setMessage("Do you really want to logout?");
                DYWLogout.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent logout = new Intent(getActivity(), LoginActivity.class);
                        startActivity(logout);
                        getActivity().finish();
                    }
                });
                DYWLogout.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                DYWLogout.show();
                break;
        }
    }
}
