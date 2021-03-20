package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class FindDrUI extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner SplSpinner,CurrLocSpinner;
    EditText date_app;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int day;
    EditText time_app;
    TimePickerDialog timePickerDialog;
    int currentHour;
    int currentMinute;
    String amPm;
    Button search_button;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddr_ui);

        SplSpinner = findViewById(R.id.splname_spinner);
        CurrLocSpinner = findViewById(R.id.currLoc_spinner);
        date_app = findViewById(R.id.editTextDate);
        time_app = findViewById(R.id.editTextTime);
        search_button = findViewById(R.id.search_btn);

        //specialist name
        SplSpinner.setOnItemSelectedListener(this);

        //current location
        CurrLocSpinner.setOnItemSelectedListener(this);

        //date
        Calendar calendar = Calendar.getInstance();
        date_app.setOnClickListener(v -> {
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            datePickerDialog = new DatePickerDialog(FindDrUI.this, (view, year, month, dayOfMonth) ->
                    date_app.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime())),year,month,day);
            datePickerDialog.show();
        });

        //time
        time_app.setOnClickListener(v -> {
            currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            currentMinute = calendar.get(Calendar.MINUTE);
            timePickerDialog = new TimePickerDialog(FindDrUI.this, (view, hourOfDay, minutes) -> {
                if(hourOfDay >= 12){
                    amPm = "PM";
                }else{
                    amPm = "AM";
                }
                time_app.setText(String.format("%02d :%02d %s", hourOfDay, minutes, amPm));
            }, currentHour,currentMinute,true);
            timePickerDialog.show();
        });

        //search btn
        search_button.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),AppointmentUI.class)));
    }

    //implements methods
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
