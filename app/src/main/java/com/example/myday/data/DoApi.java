package com.example.myday.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DoApi {
    @GET("api/activity")
    Call<ModelDao> getActivities();

    @GET("/api/activity/{key}")
    Call<ModelDao>getActivityByKey
            (@Query("key") String key);

    @GET("/api/activity?price")
    Call<ModelDao>getActivityPrice
            (@Query("price") double price);


}
