package com.android.vj.mvparchitecture.model.GitHub;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.vj.mvparchitecture.model.RepositoryListener;
import com.android.vj.mvparchitecture.model.entity.GitHubRepo;

import java.util.List;

public class GitRepository {

    public static final String TAG = GitRepository.class.getSimpleName();
    private final GitHubClient gitHubClient;

    public GitRepository(Context context) {
        gitHubClient = new GitHubClient();
    }

    public void getUserDetails(@NonNull final UserDetailsListener callback) {

        UserDetailsListener userDetailsListener = new UserDetailsListener() {

            @Override
            public void onUserListReceived(List<GitHubRepo> users) {
                // Return response to callback
                callback.onUserListReceived(users);
            }

            @Override
            public void onFailure(String message) {
                callback.onFailure(message);
            }
        };

        gitHubClient.getDetails(userDetailsListener);

    }

    public interface UserDetailsListener extends RepositoryListener {
        void onUserListReceived(List<GitHubRepo> users);
    }
}
