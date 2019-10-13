package com.snaptech.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


import com.snaptech.R;
import com.snaptech.harith.HallList;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class myrent extends Fragment {
    Button DateFrom, DateTo;
    private Calendar calendar;
    private SimpleDateFormat sdf;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
context=getActivity();
        View v = inflater.inflate(R.layout.activity_search, container, false);

        final Button DateFrom= v.findViewById(R.id.button_date_from);
          final Button DateTo= v.findViewById(R.id.button_date_to);

        sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        DateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setdate(v);
            }
        });
        DateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setdate(v);
            }
        });

        return v;
    }
    private void setdate(final View view) {

        DatePickerDialog.OnDateSetListener date;

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                calendar.set(Calendar.YEAR, y);
                calendar.set(Calendar.MONTH, m);
                calendar.set(Calendar.DAY_OF_MONTH, d);

                if (view.getTag().equals("from"))
                     DateFrom.setText(sdf.format(calendar.getTime()));
                else
                     DateTo.setText(sdf.format(calendar.getTime()));

            }
        };
        new DatePickerDialog(context, date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void fillsearchfillter(View view) {

        new Intent(getActivity(), HallList.class);
    }
}
