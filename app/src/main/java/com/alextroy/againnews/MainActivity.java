package com.alextroy.againnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private static final String KEY = "test";
    private static final String FIELDS = "thumbnail,trailText";

    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private List<NewsItem> news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list);

        init();
    }

    private void init() {
        news = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NewsAdapter(getApplicationContext(), news);
        recyclerView.setAdapter(adapter);

        getNews();
    }

    private void getNews() {
        App.getApi().getNews(FIELDS, KEY).enqueue(new Callback<com.alextroy.againnews.GeneralNews>() {
            @Override
            public void onResponse(Call<com.alextroy.againnews.GeneralNews> call, retrofit2.Response<com.alextroy.againnews.GeneralNews> response) {
                if (response.body() != null) {
                    news.clear();
                    adapter.setData(response.body().getResponse().getResults());
                }

                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<com.alextroy.againnews.GeneralNews> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
