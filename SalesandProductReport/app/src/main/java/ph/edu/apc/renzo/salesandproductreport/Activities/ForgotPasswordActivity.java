package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import ph.edu.apc.renzo.salesandproductreport.Model.Information;
import ph.edu.apc.renzo.salesandproductreport.R;

/**
 * Created by Renzo on 02/12/2016.
 */

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView back;
    private EditText forgotEmail;
    private Button  reset;
    private ProgressBar progress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        back = (TextView)findViewById(R.id.textView_BackElous);
        back.setOnClickListener(this);

        forgotEmail = (EditText)findViewById(R.id.editText_ForgotEmail);

        reset = (Button)findViewById(R.id.button_Reset);
        reset.setOnClickListener(this);

        progress = (ProgressBar)findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_BackElous:
                Intent back = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(back);
                finish();
                break;

            case R.id.button_Reset:
                String Email = forgotEmail.getText().toString().trim();

                if (Email.isEmpty()) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_LONG).show();
                    return;
                } else {

                    progress.setVisibility(View.VISIBLE);

                    mAuth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ForgotPasswordActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_LONG).show();
                                forgotEmail.setText("");
                            } else {
                                Toast.makeText(ForgotPasswordActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                            }
                            progress.setVisibility(View.GONE);
                        }
                    });
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
        startActivity(back);
        finish();
    }
}
