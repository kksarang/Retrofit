package com.example.retrofitfullfill.Api;

import com.example.retrofitfullfill.Model.CategoryModel;
import com.example.retrofitfullfill.Model.ModelClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("top_courses")
    Call<ArrayList<ModelClass>> getModelCall();

    @GET("categories")
    Call<ArrayList<CategoryModel>> getCategoryCall();


}
