package com.android.vj.mvparchitecture.view.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.vj.mvparchitecture.R;
import com.android.vj.mvparchitecture.adapter.RepoAdapter;
import com.android.vj.mvparchitecture.model.entity.GitHubRepo;
import com.android.vj.mvparchitecture.presenter.UserDetailsPresenter;
import com.android.vj.mvparchitecture.view.UserDetailsView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserDetailsView {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRepoRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRepoRV = findViewById(R.id.repo_rv);

        GitHubRepo gitHubRepo = new Gson().fromJson("", GitHubRepo.class);
        UserDetailsPresenter userDetailsPresenter = new UserDetailsPresenter(this, gitHubRepo);
        userDetailsPresenter.initialize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRepoRV.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void renderInitialData(List<GitHubRepo> gitHubRepo) {
        showBasicData(gitHubRepo);
    }

    @Override
    public void showLoading() {
        //CommonUtil.showProgressBar(this);
    }

    @Override
    public void hideLoading() {
        //CommonUtil.hideProgressBar();
    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showTemporaryMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showBasicData(List<GitHubRepo> gitHubRepo) {
        if (gitHubRepo.size() > 0 && !gitHubRepo.get(0).getName().isEmpty()) {
            Log.v(TAG, gitHubRepo.get(0).getName());
        }

        RepoAdapter repoAdapter = new RepoAdapter(this, gitHubRepo);
        mRepoRV.setAdapter(repoAdapter);
        repoAdapter.notifyDataSetChanged();

    }
}
