package com.example.wedding_hall.harith;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wedding_hall.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Search extends AppCompatActivity {

    Calendar calendar;
    int year;
    int month;
    int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Calendar calendar = Calendar.getInstance();


        final TextView DateFrom = findViewById(R.id.button_date_from);
        final TextView DateTo =   findViewById(R.id.button_date_to);

        DateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDateDialog();
                DateFrom.setText(year+"/"+month+"/"+day);
            }
        });


        DateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDateDialog();
                DateTo.setText(year+"/"+month+"/"+day);
            }
        });


        Spinner spinner = findViewById(R.id.location_name);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }



    public void openDateDialog()
    {

        DatePickerDialog datePickerDialog = new DatePickerDialog(Search.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                
                Toast.makeText(Search.this, year+" / "+month+" / "+ day, Toast.LENGTH_SHORT).show();
            }
        },year,month,day);

        datePickerDialog.show();
    }
}
