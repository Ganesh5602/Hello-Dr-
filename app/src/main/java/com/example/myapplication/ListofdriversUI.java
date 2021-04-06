package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListofdriversUI extends AppCompatActivity {
    RecyclerView Ambu_RecyclerView;
    AmbulanceAdapter ambulanceAdapter;
    ArrayList<Ambulance_driver> ambList;
    EditText DriverSearchViewBar;
    CharSequence dsearch = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofdrivers_ui);

        //searchbar
        DriverSearchViewBar = findViewById(R.id.searchBarAmbu);

        DriverSearchViewBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ambulanceAdapter.getFiltered().filter(s);
                dsearch = s;

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //list of doctors info
        ambList = new ArrayList<>();


                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Ram Kumar", "James Speciality Hospital", "Chennai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Vijay Kannan", "J.P Ambulance Service", "Chennai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Saravana", "VijayaRaj Speciality Hospital", "Chennai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Ravi", "James Speciality Hospital", "Chennai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Shivan", "J.P Ambulance Service", "Chennai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Krishnan", "Britto Speciality Hospital", "Chennai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Ravi", "Social Service Ambulance", "Trichy"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Jamal", "Kavery Hospital", "Trichy"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Hassun", "24/7 Service Ambulance", "Trichy"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Vikram", "Kavery Hospital", "Trichy"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Kawin Kumar", "Vaigai Ambulance Service", "Madurai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Abbas", "Vikram Hospital", "Madurai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Prakash", "Fast Ambulance Service", "Madurai"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Xavier", "Global Hospital", "Coimbatore"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Samuel Raj", "Quality Care Hospital", "Coimbatore"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Kiran Kumar", "Allwin Ambulance Service", "Erode"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.James ", "R.S Ambulance Service", "Erode"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Ramesh Babu", "M.M Ambulance Service", "Namakkal"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Abdul", "Keerthi Hospital", "Namakkal"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Britto", "Rajeev Hospital", "Salem"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Sankar", "G.V Hospital", "Salem"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Bharath", "Jeevan Ambulance Service", "Ariyalur"));
                ambList.add(new Ambulance_driver(R.drawable.ambtn, "Mr.Manikandan", " Cuddalore Krishna Hospital", "Cuddalore"));

        setUserRecycler(ambList);

    }

    private void setUserRecycler(ArrayList<Ambulance_driver> ambList) {
        Ambu_RecyclerView = findViewById(R.id.ambu_recyclerview);
        Ambu_RecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        Ambu_RecyclerView.setLayoutManager(layoutManager);
        ambulanceAdapter = new AmbulanceAdapter(ambList,this);
        Ambu_RecyclerView.setAdapter(ambulanceAdapter);
    }
}

