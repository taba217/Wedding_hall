package com.snaptech.internet_con;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface {


    @GET("login")
    Call<List<object>> login(@Query("phone") String phone, @Query("pass") String pass);


    @GET("renter/halls/all")
    Call<List<object>> getHalls();

//    @GET("register")
//    Call<List<object>> getHalls();
//
//    @GET("gethalls.php")
//    Call<List<object>> getHalls();
//
//    @GET("gethalls.php")
//    Call<List<object>> getHalls();
//
//    @GET("register.php")
//    Call<List<object>> getNa(@Query("phone") String phone, @Query("pass") String pass);


//    @GET("loginn.php")
//    Call<insert> getlogin(@Query("phone") String phone, @Query("pass") String pass);
}
