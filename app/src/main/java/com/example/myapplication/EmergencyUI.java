package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EmergencyUI extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner Amb_location;
    Button SearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_ui);

        //current location
        Amb_location = findViewById(R.id.driverLoc);
        Amb_location.setOnItemSelectedListener(this);
        //search button
        SearchBtn = findViewById(R.id.ambusearch_btn);
        SearchBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),ListofdriversUI.class)));
    }

    //implements methods
    @Override
    public void onItemSelected(AdapterView<?> DadapterView, View view, int position, long id) {
        Toast.makeText(this, DadapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}