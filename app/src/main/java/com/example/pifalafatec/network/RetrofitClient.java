package com.example.pifalafatec.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Objects;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    private static final String BaseUrl = "https://fala-fatec.herokuapp.com";

    public static Retrofit getRetrofit(){
        if(retrofit == null){

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

           // Objects objects = gson.fromJson(, Object.class);

            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
