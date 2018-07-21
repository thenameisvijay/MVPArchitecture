package com.android.vj.mvparchitecture.model.network;

import com.android.vj.mvparchitecture.model.entity.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface RetrofitService {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getUserRepos(@Path("user") String user);
}
