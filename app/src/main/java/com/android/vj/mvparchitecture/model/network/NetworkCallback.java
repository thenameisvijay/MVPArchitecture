package com.android.vj.mvparchitecture.model.network;

import com.android.vj.mvparchitecture.model.entity.GitHubRepo;

import java.util.List;

import retrofit2.Response;

public interface NetworkCallback {

    void success(Response<List<GitHubRepo>> response);

    void failure(String body);
}
