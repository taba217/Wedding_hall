package com.snaptech.user_operations;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.snaptech.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Extest extends AppCompatActivity {
    private TextView mTextView;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tet);
        calendar = Calendar.getInstance();
      calendar.add(Calendar.DATE,1);
        mTextView = findViewById(R.id.textView);

        //mTextView += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        Button buttonTimePicker = findViewById(R.id.button_timepicker);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlarm(calendar);
            }
        });

        Button buttonCancelAlarm = findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }


    private void Exmethoe() {


        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String counttoEX=  getSharedPreferences ("userdata",MODE_PRIVATE).getString("counttoEX","7");
        calendar.add(Calendar.DATE, Integer.parseInt(counttoEX));
        sp.format(calendar.getTime());
        String rentEx="16/10/2019";//getSharedPreferences ("userdata",MODE_PRIVATE).getString("rentEx","0");
        // if (sp.format(calendar.getTime()).equals(rentEx)) //sp.format(calendar.getTime(),5);

        // if (counttoEX)
//        if(sp.format(calendar.getTime()).compareTo(rentEx) < MAX_WAIT_DAYS){
//            Toast.makeText(this, "rentEx ", Toast.LENGTH_LONG).show();
//        }
        //  startActivity(new Intent(this, notify_dialog.class));
    }

//    private void updateTimeText(Calendar c) {
//        String timeText = "Alarm set for: ";
//        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
//
//        mTextView.setText(timeText);
//    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

//        if (c.before(Calendar.getInstance())) {
//            c.add(Calendar.DATE, 1);
//        }

        assert alarmManager != null;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        mTextView.setText("Alarm canceled");
    }
}