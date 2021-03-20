package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorInfoUI extends AppCompatActivity {
    TextView DrName,DrSpecialist, DrLoctaion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinfo_ui);

        DrName = findViewById(R.id.dr_name_info);
        DrSpecialist = findViewById(R.id.dr_spl_info);
        DrLoctaion = findViewById(R.id.dr_loca_info);

        String drname_str =getIntent().getStringExtra("Doctor Name");
        String drspl_str =getIntent().getStringExtra("Specialist");
        String drloca_str =getIntent().getStringExtra("Location");

        DrName.setText(drname_str);
        DrSpecialist.setText(drspl_str);
        DrLoctaion.setText(drloca_str);

    }
}
