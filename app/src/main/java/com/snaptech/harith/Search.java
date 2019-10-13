package com.snaptech.harith;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;



import com.snaptech.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Search extends AppCompatActivity {

    Button DateFrom, DateTo;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        calendar = Calendar.getInstance();
        DateFrom = findViewById(R.id.button_date_from);
        DateTo = findViewById(R.id.button_date_to);


    }


    public void setdate(final View view) {


        DatePickerDialog.OnDateSetListener date;

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                calendar.set(Calendar.YEAR, y);
                calendar.set(Calendar.MONTH, m);
                calendar.set(Calendar.DAY_OF_MONTH, d);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

                if (view.getTag().equals("from"))
                    DateFrom.setText(sdf.format(calendar.getTime()));
                else
                    DateTo.setText(sdf.format(calendar.getTime()));
            }
        };
        //=======================================================================
        new DatePickerDialog(this, date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void fillsearchfillter(View view) {

        new Intent(this, HallList.class);
    }

    public void setdate2(View view) {
    }
}

