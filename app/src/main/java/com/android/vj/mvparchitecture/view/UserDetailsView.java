package com.android.vj.mvparchitecture.view;

import com.android.vj.mvparchitecture.model.entity.GitHubRepo;

import java.util.List;

public interface UserDetailsView extends LoadingView {
    void renderInitialData(List<GitHubRepo> gitHubRepo);

}
