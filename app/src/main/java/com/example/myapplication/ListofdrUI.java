package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListofdrUI extends AppCompatActivity {
    RecyclerView DR_RecyclerView;
    AllergistsAdapter allergistsAdapter;
    ArrayList<Allergists_Dr> arrayList;
    EditText SearchViewBar;
    CharSequence search ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofdr_ui);

        //searchbar
        SearchViewBar = findViewById(R.id.searchBar);
        SearchViewBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                allergistsAdapter.getFilter().filter(s);
                search = s;

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //list of doctors info
        arrayList = new ArrayList<>();
        arrayList.add(new Allergists_Dr(R.drawable.dr1,"Dr.Ram Kumar","Allergists","Chennai"));
        arrayList.add(new Allergists_Dr(R.drawable.d2,"Dr.Sheela","Allergists","Trichy"));
        arrayList.add(new Allergists_Dr(R.drawable.dr1,"Dr.Balasubramanian","Allergists","Trichy"));
        arrayList.add(new Allergists_Dr(R.drawable.d3,"Dr.Hemanth Kumar","Allergists","Madurai"));
        arrayList.add(new Allergists_Dr(R.drawable.dr1,"Dr.Ravikrishnan","Allergists","Coimbatore"));
        arrayList.add(new Allergists_Dr(R.drawable.d2,"Dr.Preethi","Allergists","Chennai"));
        arrayList.add(new Allergists_Dr(R.drawable.d2,"Dr.Shobha Ranir","Allergists","Madurai"));
        arrayList.add(new Allergists_Dr(R.drawable.d2,"Dr.Shivangi Pawar","Allergists","Coimbatore"));
        arrayList.add(new Allergists_Dr(R.drawable.d3,"Dr.Karthick Kumar","Allergists","Erode"));
        arrayList.add(new Allergists_Dr(R.drawable.d3,"Dr.Srinivasan ","Allergists","Erode"));

        setUserRecycler(arrayList);
    }

    private void setUserRecycler(ArrayList<Allergists_Dr> arrayList) {
        DR_RecyclerView = findViewById(R.id.dr_recyclerview);
        DR_RecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager
                (this, RecyclerView.VERTICAL, false);
        DR_RecyclerView.setLayoutManager(layoutManager);
        allergistsAdapter = new AllergistsAdapter(arrayList, this);
        DR_RecyclerView.setAdapter(allergistsAdapter);
    }

}
