package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardUI extends AppCompatActivity {
    Button contact_btn,finddr_btn,emergency_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_ui);

        contact_btn = findViewById(R.id.button_contact);
        finddr_btn = findViewById(R.id.button_finddr);
        emergency_btn = findViewById(R.id.button_ambulance);

        contact_btn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),ContactUI.class)));
        finddr_btn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),FindDrUI.class)));
        emergency_btn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),EmergencyUI.class)));

    }
}
