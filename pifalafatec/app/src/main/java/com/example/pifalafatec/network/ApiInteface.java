package com.example.pifalafatec.network;

import com.example.pifalafatec.model.PostModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInteface {

    @POST("/signin")
    Call<PostModel> postData(@Body PostModel postModel);


}
