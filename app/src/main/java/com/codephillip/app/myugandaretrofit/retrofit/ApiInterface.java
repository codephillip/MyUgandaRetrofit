package com.codephillip.app.myugandaretrofit.retrofit;

import com.codephillip.app.myugandaretrofit.mymodel.chapters.Chapters;
import com.codephillip.app.myugandaretrofit.mymodel.districts.Districts;
import com.codephillip.app.myugandaretrofit.mymodel.events.Events;
import com.codephillip.app.myugandaretrofit.mymodel.feedbacks.Feedback;
import com.codephillip.app.myugandaretrofit.mymodel.ministrys.Ministrys;
import com.codephillip.app.myugandaretrofit.mymodel.weatherdistricts.Weatherdistricts;
import com.codephillip.app.myugandaretrofit.mymodel.weathertoday.WeatherToday;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    //todo replace with weatherurl from server
    //http://api.openweathermap.org === appid=1f846e7a0e00cf8c2f96dd5e768580fb
    //233114,229278,229362,229380,229746,233508,229024,230166,226110,226234,  === @Path("id") String id,
    @GET("/data/2.5/group?&units=metric")
    Call<Weatherdistricts> allWeatherDistricts(@Query("id") String value, @Query("appid") String appid);

    @POST("/api/v1/feedbacks/post")
    Call<Feedback> createFeedback(@Body Feedback feedback);

    @GET("/data/2.5/forecast?&mode=json&units=metric&cnt=2")
    Call<WeatherToday> allWeatherToday(@Query("id") int value, @Query("appid") String appid);
}
