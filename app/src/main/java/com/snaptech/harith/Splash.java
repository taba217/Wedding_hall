package com.snaptech.harith;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.snaptech.R;
import com.snaptech.internet_con.BaseUrl;
import com.snaptech.internet_con.Connect;
import com.snaptech.user_operations.notify_dialog;
import com.squareup.picasso.Picasso;


import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import static com.snaptech.internet_con.BaseUrl.BASE_URL;
import static com.snaptech.internet_con.Connect.respons;


public class Splash extends AppCompatActivity {

    String imageurl= BASE_URL+"image/";
    int MAX_WAIT_DAYS=8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final pl.droidsonroids.gif.GifImageView imageView;

//        Calendar calendar1 = Calendar.getInstance();
      final TextView view = findViewById(R.id.text);
     // imageView = findViewById(R.id.image1);
      Exmethoe();

        Connect c=new Connect();
        c.connect(getApplicationContext(), c.connectTo().login("123", "123"), new Runnable() {
            @Override
            public void run() {
                String[] name;
                if (respons != null) {
                    name = new String[respons.size()];
                for (int i = 0; i < respons.size(); i++) {
                    Log.i("data", respons.get(i).getName());
                // view.setText(respons.get(i).getName());
                 Toast.makeText(getApplicationContext(), respons.get(i).getName(), Toast.LENGTH_SHORT).show();
                }
            }
            }
        });
//
        c.connect(this, c.connectTo().getHalls(), new Runnable() {
            @Override
            public void run() {
                if (respons != null)
                for (int i = 0; i < respons.size(); i++) {
                    view.append(
                            respons.get(i).getName()+"\n"+
                            respons.get(i).getLocation()+"\n"+
                            respons.get(i).getAm_price());
                }
            }
        });


//        Picasso.with(Splash.this)
//                .load(imageurl+"home.jpg")//respons.get(i).getImageResource())
//                .into(imageView);
    }

    private void Exmethoe() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        String counttoEX=  getSharedPreferences ("userdata",MODE_PRIVATE).getString("counttoEX","7");
        calendar.add(Calendar.DATE, Integer.parseInt(counttoEX));
        sp.format(calendar.getTime());
        String rentEx="16/10/2019";//getSharedPreferences ("userdata",MODE_PRIVATE).getString("rentEx","0");
       // if (sp.format(calendar.getTime()).equals(rentEx)) //sp.format(calendar.getTime(),5);

       // if (counttoEX)
        if(sp.format(calendar.getTime()).compareTo(rentEx) < MAX_WAIT_DAYS){
            Toast.makeText(this, "rentEx ", Toast.LENGTH_LONG).show();
        }
      //  startActivity(new Intent(this, notify_dialog.class));
    }


}

