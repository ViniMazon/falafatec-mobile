package com.example.pifalafatec.eventos;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientEventos {

    private static final String BASE_URL = "https://fala-fatec.herokuapp.com";
    private static Retrofit retrofit = null;

    public static ApiInterfaceEventos getRetrofitClient(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterfaceEventos.class);

    }

}
