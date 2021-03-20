package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactUI extends AppCompatActivity {
    Button FB,G_mail,LinkedIn,Git;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_ui);

        FB = findViewById(R.id.fb);
        G_mail = findViewById(R.id.goog);
        LinkedIn = findViewById(R.id.linked);
        Git = findViewById(R.id.git);

        FB.setOnClickListener(v -> gotoUrl("https://m.facebook.com/suresh.ganesh.12576"));
        LinkedIn.setOnClickListener(v -> gotoUrl("https://www.linkedin.com/in/ganesh-s-832324189/"));
        Git.setOnClickListener(v -> gotoUrl("https://github.com/Ganesh5602"));
        G_mail.setOnClickListener(v -> sendEmail());
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    
    protected void sendEmail(){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:hellodr03@gmail.com")).setType("text/plain");
        try {
            startActivity(Intent.createChooser(emailIntent,"Send mail..."));
            finish();
            Log.i("Finished!","");
        } catch (Exception e) {
            Toast.makeText(ContactUI.this, "No Email ...", Toast.LENGTH_SHORT).show();
        }
    }
}
