package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ph.edu.apc.renzo.salesandproductreport.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.button_Login);
        login.setOnClickListener(this);
        signup = (TextView)findViewById(R.id.textView_LoginSignup);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Login:
                Intent login = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(login);
                finish();
                break;
            case R.id.textView_LoginSignup:
                Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signup);
                finish();
                break;
        }
    }
}
