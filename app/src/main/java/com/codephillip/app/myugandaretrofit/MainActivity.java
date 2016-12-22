package com.codephillip.app.myugandaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codephillip.app.myugandaretrofit.models.districts.District;
import com.codephillip.app.myugandaretrofit.models.districts.Districts;
import com.codephillip.app.myugandaretrofit.retrofit.ApiClient;
import com.codephillip.app.myugandaretrofit.retrofit.ApiInterface;

import java.sql.SQLInvalidAuthorizationSpecException;
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

        loadTodos();
//        loadTodos(1);
    }


    private void loadTodos() {
        Call<Districts> call = apiInterface.allDistricts();
        call.enqueue(new Callback<Districts>() {
            @Override
            public void onResponse(Call<Districts> call, Response<Districts> response) {
                Districts districts = response.body();
                displayDistrict(districts);
            }

            @Override
            public void onFailure(Call<Districts> call, Throwable t) {

            }
        });
    }


    private void displayDistrict(Districts districts) {
        if (districts != null) {
            Log.d(TAG, "displayDistrict: #" + districts);
            List<District> districtList = districts.getDistricts();

            for (District district : districtList) {
                Log.d(TAG, "displayDistrict: " + district.getId() + district.getName() + district.getRegion());
            }

        } else {
            throw new NullPointerException("District not found");
        }
    }
}
