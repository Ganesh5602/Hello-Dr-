package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RespondDrUI extends AppCompatActivity {
    Button GoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsedr_ui);

        GoHome = findViewById(R.id.go_to);

        GoHome.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),DashboardUI.class)));
    }
}
