package com.example.newsappmvvmarchitecture.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.newsappmvvmarchitecture.repository.ArticleRepo;
import com.example.newsappmvvmarchitecture.response.MainResponse;
import com.example.newsappmvvmarchitecture.response.TopMainArticleResponse;

public class MainViewModel extends AndroidViewModel {

    private ArticleRepo articleRepo;
    private LiveData<MainResponse> mainResponseLiveData;
    private LiveData<TopMainArticleResponse> topMainArticleResponseLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);

        articleRepo = new ArticleRepo();
        this.mainResponseLiveData = articleRepo.getTopHeadlineUs();
        this.topMainArticleResponseLiveData = articleRepo.getTopArticles();
    }

    public LiveData<MainResponse> getHomeScreenData(){
        return mainResponseLiveData;
    }

    public LiveData<TopMainArticleResponse> getTopArticleData(){
        return topMainArticleResponseLiveData;
    }
}
