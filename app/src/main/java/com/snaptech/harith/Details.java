package com.snaptech.harith;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



import com.snaptech.R;


public class Details extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detales);

        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("decription");
        String date = getIntent().getStringExtra("date");
        // String img = getIntent().getStringExtra("image");
//        title = preferences.getString("title", title);
//        desc = preferences.getString("description", desc);
//        preferences.edit().putString("title", null)
//                .putString("description", null).apply();
        Bitmap image = getIntent().getParcelableExtra("image");

    }

    public void rentaction(View view) {
        startActivity(new Intent(this,Splash.class));

    }

    public void loin(View view) {
    }
}


