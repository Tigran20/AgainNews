package com.alextroy.againnews;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("search")
    Call<GeneralNews> getNews(
            @Query("show-fields") String show_fields,
            @Query("api-key") String key);
}
