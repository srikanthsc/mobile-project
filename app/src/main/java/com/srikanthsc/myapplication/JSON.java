package com.srikanthsc.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSON {

    @GET("posts")
    Call<List<ModelRetrofit>> getPost();
}