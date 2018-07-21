package com.android.vj.mvparchitecture.model.network;

import com.android.vj.mvparchitecture.model.entity.GitHubRepo;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static final String TAG = Network.class.getSimpleName();
    private RetrofitService service;

    public Network(String baseUrl) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RetrofitService.class);
    }

    public void makeRequest(final String path, final NetworkCallback networkCallback) {
        Call<List<GitHubRepo>> response = service.getUserRepos(path);
        response.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                //checkResponse(response, networkCallback);
                networkCallback.success(response);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                networkCallback.failure(t.getMessage());
            }
        });
    }

    /*private void checkResponse(retrofit2.Response<List<GitHubRepo>> response, NetworkCallback networkCallback) {
        List<GitHubRepo> body = getBodyFromResponse(response);
        if (response.isSuccessful()) {
            networkCallback.success(body);
        } else {
            networkCallback.failure(body.toString());
        }
    }

    private List<GitHubRepo> getBodyFromResponse(retrofit2.Response<List<GitHubRepo>> response) {
        List<GitHubRepo> body = null;
        try {
            if (response != null && response.body() != null) {
                body = response.body();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }


    public String appendDefaultQueryString(String url) {
        return url;
    }*/

}
