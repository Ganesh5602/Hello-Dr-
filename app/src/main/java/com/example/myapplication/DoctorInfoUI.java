package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorInfoUI extends AppCompatActivity {
    TextView DrName,DrSpecialist, DrLoctaion;
    Button BookApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinfo_ui);

        DrName = findViewById(R.id.dr_name_info);
        DrSpecialist = findViewById(R.id.dr_spl_info);
        DrLoctaion = findViewById(R.id.dr_loca_info);
        BookApp = findViewById(R.id.book_app2);

        String drname_str =getIntent().getStringExtra("Doctor Name");
        String drspl_str =getIntent().getStringExtra("Specialist");
        String drloca_str =getIntent().getStringExtra("Location");

        DrName.setText(drname_str);
        DrSpecialist.setText(drspl_str);
        DrLoctaion.setText(drloca_str);


        BookApp.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),BookUI.class)));

    }
}
