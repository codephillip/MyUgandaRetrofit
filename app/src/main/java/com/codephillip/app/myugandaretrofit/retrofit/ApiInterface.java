package com.codephillip.app.myugandaretrofit.retrofit;

import com.codephillip.app.myugandaretrofit.mymodel.chapters.Chapters;
import com.codephillip.app.myugandaretrofit.mymodel.districts.Districts;
import com.codephillip.app.myugandaretrofit.mymodel.events.Events;
import com.codephillip.app.myugandaretrofit.mymodel.feedbacks.Feedback;
import com.codephillip.app.myugandaretrofit.mymodel.ministrys.Ministrys;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by codephillip on 22/12/16.
 */

public interface ApiInterface {

    @GET("/api/v1/districts?format=json")
    Call<Districts> allDistricts();

    @GET("/api/v1/ministrys?format=json")
    Call<Ministrys> allMinistrys();

    @GET("/api/v1/events?format=json")
    Call<Events> allEvents();

    @GET("/api/v1/chapters?format=json")
    Call<Chapters> allChapters();

    @POST("/api/v1/feedbacks/post")
    Call<Feedback> createFeedback(@Body Feedback feedback);

}
