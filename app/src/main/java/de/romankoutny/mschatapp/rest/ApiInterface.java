package de.romankoutny.mschatapp.rest;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface
{
    @POST("generateAnswer")
    Call<QnAResponse> getAnswer(@Header("Ocp-Apim-Subscription-Key") String apiKey, @Body Map<String,String> query);


}
