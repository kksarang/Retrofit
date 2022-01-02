package com.example.retrofitfullfill.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitfullfill.Adapter.SecondAdapter;
import com.example.retrofitfullfill.Api.ApiInterface;
import com.example.retrofitfullfill.Model.CategoryModel;
import com.example.retrofitfullfill.Model.ModelClass;
import com.example.retrofitfullfill.Adapter.MyAdapter;
import com.example.retrofitfullfill.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView1, recyclerView2;
    private ApiInterface myApi;

    private  static final String url="https://futursity.com/course/api/";

    private ArrayList<ModelClass> modelArrayList;

    private ArrayList<CategoryModel> categoryModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1=findViewById(R.id.recview);

        recyclerView2=findViewById(R.id.second_recycler);



        modelArrayList=new ArrayList<>();

        categoryModels= new ArrayList<>();



        viewJsonData();

    }

    private void viewJsonData() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).build();


        myApi = retrofit.create(ApiInterface.class);

        Call<ArrayList<ModelClass>> arrayListCall = myApi.getModelCall();

        arrayListCall.enqueue(new Callback<ArrayList<ModelClass>>() {

            @Override
            public void onResponse(Call<ArrayList<ModelClass>> call, Response<ArrayList<ModelClass>> response) {

                modelArrayList = response.body();

                int i= 0;

                for (i=0;i< modelArrayList.size();i++)
                {
                    MyAdapter myAdapter = new MyAdapter(modelArrayList,MainActivity.this);

                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,
                                         recyclerView1.HORIZONTAL,false);

                    recyclerView1.setLayoutManager(linearLayoutManager);

                    recyclerView1.setAdapter(myAdapter);

                    recyclerView1.setHasFixedSize(true);
                }}

            @Override
            public void onFailure(Call<ArrayList<ModelClass>> call, Throwable t) {

            }
        });


        Call<ArrayList<CategoryModel>> arrayListCall1 =myApi.getCategoryCall();

        arrayListCall1.enqueue(new Callback<ArrayList<CategoryModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CategoryModel>> call, Response<ArrayList<CategoryModel>> response) {

                categoryModels = response.body();

                int i = 0;

                for (i=0;i<categoryModels.size();i++)
                {
                    SecondAdapter secondAdapter= new SecondAdapter(categoryModels,MainActivity.this);

                    GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);

                    recyclerView2.setLayoutManager(gridLayoutManager);

                    recyclerView2.setAdapter(secondAdapter);

                    recyclerView2.setHasFixedSize(true);

                }

            }

            @Override
            public void onFailure(Call<ArrayList<CategoryModel>> call, Throwable t) {

            }
        });







    }


}