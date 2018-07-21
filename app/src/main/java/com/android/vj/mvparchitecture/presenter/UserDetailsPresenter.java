package com.android.vj.mvparchitecture.presenter;

import com.android.vj.mvparchitecture.model.GitHub.GitRepository;
import com.android.vj.mvparchitecture.model.entity.GitHubRepo;
import com.android.vj.mvparchitecture.view.UserDetailsView;

import java.util.List;

public class UserDetailsPresenter implements Presenter, GitRepository.UserDetailsListener {

    private UserDetailsView userDetailsView;
    private GitRepository gitRepository;
    private GitHubRepo gitHubRepo;

    public UserDetailsPresenter(UserDetailsView userDetailsView, GitHubRepo gitHubRepo) {
        this.userDetailsView = userDetailsView;
        this.gitHubRepo = gitHubRepo;
        this.gitRepository = new GitRepository(userDetailsView.getContext());
    }

    @Override
    public void initialize() {
        userDetailsView.showLoading();
        userDetailsView.hideRetry();
        gitRepository.getUserDetails(this);
    }

    @Override
    public void destroy() {
        userDetailsView = null;
        gitRepository = null;
        gitHubRepo = null;
    }

    @Override
    public void onUserListReceived(List<GitHubRepo> users) {
        userDetailsView.hideLoading();
        userDetailsView.renderInitialData(users);
    }

    @Override
    public void onFailure(String message) {
        userDetailsView.hideLoading();
        userDetailsView.showRetry();
        userDetailsView.showTemporaryMessage(message);
    }
}
