package com.example.newsappmvvmarchitecture.api;

import static com.example.newsappmvvmarchitecture.constants.NewsAppConstants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofirClient {

    private static Retrofit retrofit;
    public static  Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
