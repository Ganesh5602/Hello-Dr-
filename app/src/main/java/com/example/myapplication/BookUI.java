package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class BookUI extends AppCompatActivity {
    EditText PatName,PhNum,AppointDate;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int day;
    Button Confirm;
    Button Eight,Two,Ten,Seven,Notava,Six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ui);

        PatName = findViewById(R.id.patname);
        PhNum = findViewById(R.id.patphnum);
        AppointDate = findViewById(R.id.appdate);
        Confirm = findViewById(R.id.confirm);
        Eight = findViewById(R.id.eight_am);
        Two = findViewById(R.id.two_pm);
        Ten = findViewById(R.id.ten_am);
        Seven = findViewById(R.id.seven_pm);
        Notava = findViewById(R.id.not_avail);
        Six = findViewById(R.id.six_pm);

        Calendar calendar = Calendar.getInstance();
        AppointDate.setOnClickListener(v -> {
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            datePickerDialog = new DatePickerDialog(BookUI.this, (view, year, month, dayOfMonth) ->
                    AppointDate.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime())),year,month,day);
            datePickerDialog.show();
        });

        Eight.setOnClickListener(v -> Toast.makeText(BookUI.this, "08:00 AM", Toast.LENGTH_SHORT).show());
        Ten.setOnClickListener(v -> Toast.makeText(BookUI.this, "10:00 AM", Toast.LENGTH_SHORT).show());
        Two.setOnClickListener(v -> Toast.makeText(BookUI.this, "02:00 PM", Toast.LENGTH_SHORT).show());
        Notava.setOnClickListener(v -> Toast.makeText(BookUI.this, "04:30PM Not Available..", Toast.LENGTH_SHORT).show());
        Six.setOnClickListener(v -> Toast.makeText(BookUI.this, "06:00 PM", Toast.LENGTH_SHORT).show());
        Seven.setOnClickListener(v -> Toast.makeText(BookUI.this, "07:45 PM", Toast.LENGTH_SHORT).show());

        Confirm.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),RespondDrUI.class)));
    }
}
