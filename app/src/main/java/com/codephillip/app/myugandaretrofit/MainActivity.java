package com.codephillip.app.myugandaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codephillip.app.myugandaretrofit.mymodel.districts.District;
import com.codephillip.app.myugandaretrofit.mymodel.districts.Districts;
import com.codephillip.app.myugandaretrofit.mymodel.ministrys.Ministry;
import com.codephillip.app.myugandaretrofit.mymodel.ministrys.Ministrys;
import com.codephillip.app.myugandaretrofit.retrofit.ApiClient;
import com.codephillip.app.myugandaretrofit.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        saveDistricts();
        saveMinistrys();
    }

    private void saveMinistrys() {
        Call<Ministrys> call = apiInterface.allMinistrys();
        call.enqueue(new Callback<Ministrys>() {
            @Override
            public void onResponse(Call<Ministrys> call, Response<Ministrys> response) {
                Ministrys ministrys = response.body();
                saveMinistry(ministrys);
            }

            @Override
            public void onFailure(Call<Ministrys> call, Throwable t) {

            }
        });
    }

    private void saveMinistry(Ministrys ministrys) {
        List<Ministry> ministryList = ministrys.getMinistrys();
        for (Ministry ministry : ministryList) {
            Log.d(TAG, "saveMinistry: " + ministry.getId() + ministry.getName() + ministry.getImage());
        }
    }


    private void saveDistricts() {
        Call<Districts> call = apiInterface.allDistricts();
        call.enqueue(new Callback<Districts>() {
            @Override
            public void onResponse(Call<Districts> call, Response<Districts> response) {
                Districts ministrys = response.body();
                saveDistrict(ministrys);
            }

            @Override
            public void onFailure(Call<Districts> call, Throwable t) {

            }
        });
    }


    private void saveDistrict(Districts ministrys) {
        if (ministrys != null) {
            Log.d(TAG, "saveDistrict: #" + ministrys);
            List<District> ministryList = ministrys.getDistricts();

            for (District ministry : ministryList) {
                Log.d(TAG, "saveDistrict: " + ministry.getId() + ministry.getName() + ministry.getRegion());
            }

        } else {
            throw new NullPointerException("District not found");
        }
    }
}
