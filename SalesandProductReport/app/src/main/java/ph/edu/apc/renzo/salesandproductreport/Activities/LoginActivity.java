package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editEmail, editPassword;
    private Button login;
    private TextView signup, forgotpassword;
    private FirebaseAuth mAuth;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = (EditText)findViewById(R.id.editText_LoginEmail);
        editPassword = (EditText)findViewById(R.id.editText_LoginPassword);
        editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        login = (Button)findViewById(R.id.button_Login);
        login.setOnClickListener(this);
        signup = (TextView)findViewById(R.id.textView_LoginSignup);
        signup.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        signup.setOnClickListener(this);
        forgotpassword = (TextView)findViewById(R.id.textView_LoginForgotPassword);
        forgotpassword.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        forgotpassword.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

        progress = (ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Login:
                String Email = editEmail.getText().toString().trim();
                String Password = editPassword.getText().toString().trim();

                if (Email.isEmpty() || Password.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Please make sure you enter an email address and password!")
                            .setTitle("Sign In Error!")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {

                    progress.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(Email, Password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent signin = new Intent(LoginActivity.this, MainActivity.class);
                                        signin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        signin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(signin);
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                        builder.setMessage(task.getException().getMessage())
                                                .setTitle("Error!")
                                                .setPositiveButton(android.R.string.ok, null);
                                        AlertDialog dialog = builder.create();
                                        dialog.show();
                                    }
                                    progress.setVisibility(View.GONE);
                                }
                            });
                }
                break;

            case R.id.textView_LoginSignup:
                Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signup);
                finish();
                break;

            case R.id.textView_LoginForgotPassword:
                Intent forgot = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(forgot);
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
