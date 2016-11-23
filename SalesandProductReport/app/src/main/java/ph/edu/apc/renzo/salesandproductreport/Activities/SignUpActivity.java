package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ph.edu.apc.renzo.salesandproductreport.Model.Information;
import ph.edu.apc.renzo.salesandproductreport.Model.SalesProductDB;
import ph.edu.apc.renzo.salesandproductreport.Model.SalesProductDBAdapter;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 28/10/2016.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private SalesProductDBAdapter salesproductDBAdapter = new SalesProductDBAdapter(this);
    private TextView back;
    private EditText name, username, password, email;
    private String namestr, usernamestr, passwordstr, emailstr;
    private Button register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(this);

        name = (EditText)findViewById(R.id.editText_SignupName);
        username = (EditText)findViewById(R.id.editText_SignupUsername);
        password = (EditText)findViewById(R.id.editText_SignupPassword);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        email = (EditText)findViewById(R.id.editText_SignupEmail);

        register = (Button)findViewById(R.id.button_SignUp);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_BackElous:
                Intent back = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(back);
                finish();
                break;
            case R.id.button_SignUp:

                if (name.length() == 0) {
                    name.setError("Name is required");
                    return;
                } else if (username.length() == 0) {
                    username.setError("Username is required");
                    return;
                } else if (password.length() == 0) {
                    password.setError("Password is required");
                    return;
                } else if (email.length() == 0) {
                    email.setError("Email is required");
                    return;
                } else {
                    namestr = name.getText().toString();
                    usernamestr = username.getText().toString();
                    passwordstr = password.getText().toString();
                    emailstr = email.getText().toString();

                    Information information = new Information();
                    information.setName(namestr);
                    information.setUsername(usernamestr);
                    information.setPassword(passwordstr);
                    information.setEmail(emailstr);

                    salesproductDBAdapter.insertInformation(information);

                    Intent signup = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(signup);
                    finish();
                    Toast.makeText(this, "Successfully signed up!", Toast.LENGTH_LONG).show();
                    break;
                }
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(back);
        finish();
    }
}
