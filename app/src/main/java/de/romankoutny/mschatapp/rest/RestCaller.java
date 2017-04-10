package de.romankoutny.mschatapp.rest;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by XHU6032 on 09.04.2017.
 */

public class RestCaller
{
    static final String TAG = "MSChatApp";


    public void call(final String query)
    {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        RequestBody body = new RequestBody()
        {
            @Override
            public MediaType contentType()
            {
                return MediaType.parse("application/json");
            }
            @Override
            public void writeTo(BufferedSink sink) throws IOException
            {
                sink.write(query.getBytes());
            }
        };

        Call<QnAResponse> call = apiService.getAnswer(IDS.qnamakerSubscriptionKey, body);
        call.enqueue(new Callback<QnAResponse>() {
            @Override
            public void onResponse(Call<QnAResponse>call, Response<QnAResponse> response) {
                String answer = response.body().getAnswer();
                double score = response.body().getScore();
                Log.i(TAG, "Answer: " + answer);
                Log.i(TAG, "Score: " + score);
            }

            @Override
            public void onFailure(Call<QnAResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }


        });
    }
}
