package com.example.pifalafatec.eventos;

import com.example.pifalafatec.eventos.Eventos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiInterfaceEventos {

    @GET("/evento")
    Call<List<Eventos>> getEventos();

}
