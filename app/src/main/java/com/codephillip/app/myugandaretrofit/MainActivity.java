package com.codephillip.app.myugandaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codephillip.app.myugandaretrofit.mymodel.chapters.Chapter;
import com.codephillip.app.myugandaretrofit.mymodel.chapters.Chapters;
import com.codephillip.app.myugandaretrofit.mymodel.districts.District;
import com.codephillip.app.myugandaretrofit.mymodel.districts.Districts;
import com.codephillip.app.myugandaretrofit.mymodel.events.Event;
import com.codephillip.app.myugandaretrofit.mymodel.events.Events;
import com.codephillip.app.myugandaretrofit.mymodel.feedbacks.Feedback;
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

//        loadDistricts();
//        loadMinistrys();
//        loadEvents();
//        loadChapters();
        sendFeedback();
    }

    private void sendFeedback() {
        Feedback feedback = new Feedback("dummy title2", "dummy content, dummy content2");
        Call<Feedback> call = apiInterface.createFeedback(feedback);
        call.enqueue(new Callback<Feedback>() {
            @Override
            public void onResponse(Call<Feedback> call, Response<Feedback> response) {
                int statusCode = response.code();
                Feedback feedback1 = response.body();
                Log.d(TAG, "onResponse: #" + feedback1.getTitle() + feedback1.getContent() + statusCode);
            }

            @Override
            public void onFailure(Call<Feedback> call, Throwable t) {

            }
        });
    }

    private void loadChapters() {
        Call<Chapters> call = apiInterface.allChapters();
        call.enqueue(new Callback<Chapters>() {
            @Override
            public void onResponse(Call<Chapters> call, Response<Chapters> response) {
                Chapters chapters = response.body();
                saveChapters(chapters);
            }

            @Override
            public void onFailure(Call<Chapters> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void saveChapters(Chapters chapters) {
        if (chapters == null)
            throw new NullPointerException("Chapters not found");
        List<Chapter> chapterList = chapters.getChapters();
        for (Chapter chapter : chapterList) {
            Log.d(TAG, "saveChapter: " + chapter.getId() + chapter.getTitle() + chapter.getImage() + chapter.getMinistry().getName() + chapter.getDistrict().getName());
        }
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
        if (events == null)
            throw new NullPointerException("Events not found");
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
        if (ministrys == null)
            throw new NullPointerException("Ministrys not found");
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


    private void saveDistricts(Districts districts) {
        if (districts == null)
            throw new NullPointerException("Districts not found");
        Log.d(TAG, "saveDistrict: #" + districts);
        List<District> districtList = districts.getDistricts();

        for (District district : districtList) {
            Log.d(TAG, "saveDistrict: " + district.getId() + district.getName() + district.getRegion());
        }

    }
}
