package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 28/10/2016.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView back;
    private EditText editName, editUsername, editPassword, editEmail;
    private Button register;
    private FirebaseAuth mAuth;
    private ProgressBar progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(this);

        editName = (EditText)findViewById(R.id.editText_SignupName);
        editUsername = (EditText)findViewById(R.id.editText_SignupUsername);
        editPassword = (EditText)findViewById(R.id.editText_SignupPassword);
        editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editEmail = (EditText)findViewById(R.id.editText_SignupEmail);

        register = (Button)findViewById(R.id.button_SignUp);
        register.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        progress = (ProgressBar)findViewById(R.id.progressBar);
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

                String Name = editName.getText().toString().trim();
                String Username = editUsername.getText().toString().trim();
                String Password = editPassword.getText().toString().trim();
                String Email = editEmail.getText().toString().trim();

                if (Name.isEmpty() || Username.isEmpty() || Password.isEmpty() || Email.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                    builder.setMessage("Please make sure to input all fields!")
                            .setTitle("Sign Up Error!")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                progress.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent signup = new Intent(SignUpActivity.this, LoginActivity.class);
                                    signup.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    signup.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(signup);
                                    finish();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                    builder.setMessage(task.getException().getMessage())
                                            .setTitle("Sign Up Error")
                                            .setPositiveButton(android.R.string.ok, null);
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                                progress.setVisibility(View.GONE);
                        }
                });
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(back);
        finish();
    }
}
