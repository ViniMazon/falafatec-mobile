package com.example.pifalafatec.network;

import com.example.pifalafatec.model.PostModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("/signin")
    Call<PostModel> postData(@Body PostModel postModel);

}
