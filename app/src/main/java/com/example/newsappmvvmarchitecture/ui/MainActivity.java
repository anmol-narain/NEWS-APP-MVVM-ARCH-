package com.example.newsappmvvmarchitecture.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.newsappmvvmarchitecture.R;
import com.example.newsappmvvmarchitecture.adapters.TopArticleAdapter;
import com.example.newsappmvvmarchitecture.adapters.TopHeadlineAdapter;
import com.example.newsappmvvmarchitecture.models.Article;
import com.example.newsappmvvmarchitecture.models.TopArticle;
import com.example.newsappmvvmarchitecture.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView,recyclerView2;
    List<Article> articleList;
    List<TopArticle> topArticleList;
    MainViewModel mainViewModel;
    TopHeadlineAdapter topHeadlineAdapter;
    TopArticleAdapter topArticleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initialize();
        getNews();
        getTopArticles();
    }

    private void getTopArticles() {
        mainViewModel.getTopArticleData().observe(this,mainResponse -> {
            if(mainResponse != null && mainResponse.getArticles() != null && !mainResponse.getArticles().isEmpty()){
                List<TopArticle> article = mainResponse.getArticles();
                topArticleList.addAll(article);
                topArticleAdapter.notifyDataSetChanged();
            }
        });
    }

    private void getNews() {
        mainViewModel.getHomeScreenData().observe(this,mainResponse -> {
            if(mainResponse != null && mainResponse.getArticles() != null && !mainResponse.getArticles().isEmpty()){
                List<Article> article = mainResponse.getArticles();
                articleList.addAll(article);
                topHeadlineAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initialize() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);

        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView2.setHasFixedSize(true);

        articleList = new ArrayList<>();
        topHeadlineAdapter = new TopHeadlineAdapter(articleList,this);
        recyclerView.setAdapter(topHeadlineAdapter);

        topArticleList = new ArrayList<>();
        topArticleAdapter = new TopArticleAdapter(topArticleList,this);
        recyclerView2.setAdapter(topArticleAdapter);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }
}