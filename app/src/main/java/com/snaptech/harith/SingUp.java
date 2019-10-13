package com.snaptech.harith;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.snaptech.R;


public class SingUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

    }

    public void register(View view) {

//        if ()
        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));
    }
}
