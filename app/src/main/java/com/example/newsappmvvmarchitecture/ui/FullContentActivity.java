package com.example.newsappmvvmarchitecture.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsappmvvmarchitecture.R;
import com.example.newsappmvvmarchitecture.models.Article;
import com.makeramen.roundedimageview.RoundedImageView;

public class FullContentActivity extends AppCompatActivity {

    Article article = null;
    TextView title,desc,author,content,publishedAt;
    RoundedImageView detimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_content);

        detimg = findViewById(R.id.det_img);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.des);
        author = findViewById(R.id.author);
        content = findViewById(R.id.content);
        publishedAt = findViewById(R.id.publish_at);

        final Object object = getIntent().getSerializableExtra("newsData");
        if(object instanceof  Article){
            article = (Article) object;
        }

        if(article!=null){
            Glide.with(getApplicationContext()).load(article.getUrlToImage()).into(detimg);
            title.setText((article.getTitle()));
            desc.setText((article.getDescription()));
            author.setText((article.getSource().getName()));
            content.setText((article.getContent()));
            publishedAt.setText((article.getPublishedAt()));
        }


    }
}