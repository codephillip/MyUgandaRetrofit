package com.codephillip.app.myugandaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codephillip.app.myugandaretrofit.mymodel.districts.District;
import com.codephillip.app.myugandaretrofit.mymodel.districts.Districts;
import com.codephillip.app.myugandaretrofit.mymodel.events.Event;
import com.codephillip.app.myugandaretrofit.mymodel.events.Events;
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

        loadDistricts();
        loadMinistrys();
        loadEvents();
    }

    private void loadEvents() {
        Call<Events> call = apiInterface.allEvents();
        call.enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                Events events = response.body();
                saveEvents(events);
            }

            @Override
            public void onFailure(Call<Events> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void saveEvents(Events events) {
        List<Event> eventList = events.getEvents();
        for (Event event : eventList) {
            Log.d(TAG, "saveEvent: " + event.getId() + event.getTitle() + event.getLocation() + event.getMinistry().getName());
        }
    }

    private void loadMinistrys() {
        Call<Ministrys> call = apiInterface.allMinistrys();
        call.enqueue(new Callback<Ministrys>() {
            @Override
            public void onResponse(Call<Ministrys> call, Response<Ministrys> response) {
                Ministrys ministrys = response.body();
                saveMinistrys(ministrys);
            }

            @Override
            public void onFailure(Call<Ministrys> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void saveMinistrys(Ministrys ministrys) {
        List<Ministry> ministryList = ministrys.getMinistrys();
        for (Ministry ministry : ministryList) {
            Log.d(TAG, "saveMinistry: " + ministry.getId() + ministry.getName() + ministry.getImage());
        }
    }


    private void loadDistricts() {
        Call<Districts> call = apiInterface.allDistricts();
        call.enqueue(new Callback<Districts>() {
            @Override
            public void onResponse(Call<Districts> call, Response<Districts> response) {
                Districts ministrys = response.body();
                saveDistricts(ministrys);
            }

            @Override
            public void onFailure(Call<Districts> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }


    private void saveDistricts(Districts ministrys) {
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
