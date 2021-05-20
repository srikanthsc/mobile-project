package com.srikanthsc.myapplication; // nom du package
//import
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSON {   //interface pour le retrofit

    @GET("posts")
    Call<List<ModelRetrofit>> getPost();
}