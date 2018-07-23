package com.android.vj.mvparchitecture.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.vj.mvparchitecture.R;
import com.android.vj.mvparchitecture.model.entity.GitHubRepo;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.GitViewHolder> {


    private Context context;
    private List<GitHubRepo> gitHubRepo;

    public RepoAdapter(Context context, List<GitHubRepo> gitHubRepo) {
        this.context = context;
        this.gitHubRepo = gitHubRepo;
    }

    @NonNull
    @Override
    public GitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_adapter_layout, parent, false);
        return new GitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitViewHolder holder, int position) {
        holder.repoName.setText(gitHubRepo.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return gitHubRepo.size();
    }

    public class GitViewHolder extends RecyclerView.ViewHolder {
        TextView repoName;

        GitViewHolder(View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.repo_tv);
        }
    }
}
