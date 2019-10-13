package com.snaptech.internet_con;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.snaptech.internet_con.BaseUrl.BASE_URL;

public class Connect {


    public static List<object> respons;

        public void connect(final Context context,Call<List<object>> call,final Runnable onsuccess) {

            call.enqueue(new Callback<List<object>>() {
                @Override
                public void onResponse(Call<List<object>> call, Response<List<object>> response) {
                    respons = response.body();
                    onsuccess.run();
                }
                @Override
                public void onFailure(Call<List<object>> call, Throwable t) {
                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public Interface connectTo() {
            //Here we are using the GsonConverterFactory to directly convert json data to object
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();
          return retrofit.create(Interface.class);
        }

}
