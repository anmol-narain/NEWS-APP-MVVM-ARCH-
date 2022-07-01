package com.example.newsappmvvmarchitecture.api;

import static com.example.newsappmvvmarchitecture.constants.NewsAppConstants.API_KEY;

import com.example.newsappmvvmarchitecture.response.MainResponse;
import com.example.newsappmvvmarchitecture.response.TopMainArticleResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequestInterface {

    @GET("top-headlines?country=us&category=business&apiKey="+API_KEY)
    Call<MainResponse> getTopHeadline();

    @GET("everything?domains=wsj.com&apiKey="+API_KEY)
    Call<TopMainArticleResponse> getTopArticles();
}
