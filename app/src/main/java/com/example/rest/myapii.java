package com.example.rest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myapii {
    @FormUrlEncoded
    @POST("register.php")
    Call<modell> adddata(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );
}
