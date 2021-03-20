package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginUI extends AppCompatActivity {
    EditText email,password;
    Button Login,Dr_btn,Ambulance_btn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    TextView signUp_btn,forgetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ui);

        email = findViewById(R.id.email_editText);
        password = findViewById(R.id.pass_editText);
        progressBar = findViewById(R.id.progressBar2);
        fAuth = FirebaseAuth.getInstance();
        Login = findViewById(R.id.login_button);
        Dr_btn = findViewById(R.id.dr_btn);
        Ambulance_btn = findViewById(R.id.am_btn);
        signUp_btn = findViewById(R.id.signup_textView);
        forgetPass = findViewById(R.id.forget_textView);

        //patient login
        Login.setOnClickListener(v -> {
            String emailUser = email.getText().toString().trim();
            String passUser = password.getText().toString().trim();

            if(TextUtils.isEmpty(emailUser)){
                email.setError("Email is Required..");
                return;
            }

            if(TextUtils.isEmpty(passUser)){
                password.setError("Password is Required..");
                return;
            }

            if(passUser.length() < 6){
                password.setError("Password Must be >= 6 characters..");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            //authenticate the user
            fAuth.signInWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(LoginUI.this, "Logged In Successfully..", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginUI.this,DashboardUI.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginUI.this, "Error!!!" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        });

        //dr login
        Dr_btn.setOnClickListener(v -> {
            String emailUser = email.getText().toString().trim();
            String passUser = password.getText().toString().trim();

            if(TextUtils.isEmpty(emailUser)){
                email.setError("Email is Required..");
                return;
            }

            if(TextUtils.isEmpty(passUser)){
                password.setError("Password is Required..");
                return;
            }

            if(passUser.length() < 6){
                password.setError("Password Must be >= 6 characters..");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            //authenticate the user
            fAuth.signInWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(LoginUI.this, "Logged In Successfully..", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginUI.this,DashboardUI.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginUI.this, "Error!!!" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        });

        //ambulance driver login
        Ambulance_btn.setOnClickListener(v -> {
            String emailUser = email.getText().toString().trim();
            String passUser = password.getText().toString().trim();

            if(TextUtils.isEmpty(emailUser)){
                email.setError("Email is Required..");
                return;
            }

            if(TextUtils.isEmpty(passUser)){
                password.setError("Password is Required..");
                return;
            }

            if(passUser.length() < 6){
                password.setError("Password Must be >= 6 characters..");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            //authenticate the user
            fAuth.signInWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(LoginUI.this, "Logged In Successfully..", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginUI.this,DashboardUI.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginUI.this, "Error!!!" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        });


        signUp_btn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),RegisterUI.class)));

        forgetPass.setOnClickListener(v -> {
            EditText resetMail = new EditText(v.getContext());
            AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
            passwordResetDialog.setTitle("Reset Password ?");
            passwordResetDialog.setTitle("Enter Your Email to receive reset link.");
            passwordResetDialog.setView(resetMail);

            passwordResetDialog.setPositiveButton("Yes", (dialog, which) -> {
                  //extract the mail and send reset link
                String mail = resetMail.getText().toString();
                fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(aVoid -> Toast.makeText(LoginUI.this, "Reset Link sent to your email..", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(LoginUI.this, "Sorry, Error!! Unable to send.."+ e.getMessage(), Toast.LENGTH_SHORT).show());
            });

            passwordResetDialog.setNegativeButton("No", (dialog, which) -> {

            });
 
            passwordResetDialog.create().show();
        });

    }
}
