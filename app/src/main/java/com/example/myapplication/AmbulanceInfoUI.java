package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AmbulanceInfoUI extends AppCompatActivity {
    TextView DriverName,DriverCompany, DriverLoctaion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverinfo_ui);

        DriverName = findViewById(R.id.driver_name_info);
        DriverCompany = findViewById(R.id.driver_company_info);
        DriverLoctaion = findViewById(R.id.driver_loca_info);

        String drivername_str =getIntent().getStringExtra("Driver Name");
        String drivercmpy_str =getIntent().getStringExtra("Company");
        String driverloc_str =getIntent().getStringExtra("Location");

        DriverName.setText(drivername_str);
        DriverCompany.setText(drivercmpy_str);
        DriverLoctaion.setText(driverloc_str);

    }
}
