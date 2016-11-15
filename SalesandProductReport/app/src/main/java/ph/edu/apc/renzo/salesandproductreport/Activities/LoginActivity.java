package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ph.edu.apc.renzo.salesandproductreport.Model.SalesProductDB;
import ph.edu.apc.renzo.salesandproductreport.Model.SalesProductDBAdapter;
import ph.edu.apc.renzo.salesandproductreport.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    SalesProductDBAdapter salesproductDBAdapter = new SalesProductDBAdapter(this);
    private EditText username, password;
    private String usernamestr, passwordstr, passwordauth;
    private Button login;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.editText_LoginUsername);
        password = (EditText)findViewById(R.id.editText_LoginPassword);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        login = (Button)findViewById(R.id.button_Login);
        login.setOnClickListener(this);
        signup = (TextView)findViewById(R.id.textView_LoginSignup);
        signup.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Login:

                usernamestr = username.getText().toString();
                passwordstr = password.getText().toString();

                passwordauth = salesproductDBAdapter.searchPass(usernamestr);
                if (passwordstr.equals(passwordauth)) {
                    Intent login = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(login);
                    finish();
                    Toast.makeText(this, "You have successfully login " + salesproductDBAdapter.displayName(usernamestr), Toast.LENGTH_LONG).show();
                    break;
                } else {
                    Toast.makeText(this, "Username or Password does not exist", Toast.LENGTH_LONG).show();
                    break;
                }
            case R.id.textView_LoginSignup:
                Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signup);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        final AlertDialog bye = new AlertDialog.Builder(this).create();
        bye.setTitle("Close the app");
        bye.setMessage("Do you really want to close the app?");
        bye.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                LoginActivity.super.onBackPressed();
            }
        });
        bye.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        bye.show();
    }
}
