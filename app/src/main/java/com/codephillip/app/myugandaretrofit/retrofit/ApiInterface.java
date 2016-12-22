package com.codephillip.app.myugandaretrofit.retrofit;

import com.codephillip.app.myugandaretrofit.models.districts.District;
import com.codephillip.app.myugandaretrofit.models.districts.Districts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by codephillip on 22/12/16.
 */

public interface ApiInterface {

    @GET("/api/v1/districts?format=json")
    Call<Districts> allDistricts();

}
