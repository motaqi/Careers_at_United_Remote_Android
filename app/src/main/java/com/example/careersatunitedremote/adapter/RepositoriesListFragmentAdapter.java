package com.example.careersatunitedremote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careersatunitedremote.R;
import com.example.careersatunitedremote.model.RepositoryResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoriesListFragmentAdapter extends RecyclerView.Adapter<RepositoriesListFragmentAdapter.RepositoriesViewHolder>{

    private RepositoryResponse repositoryResponse;
    private Context context;


    public RepositoriesListFragmentAdapter(RepositoryResponse repositoryResponse, Context context){
        this.repositoryResponse = repositoryResponse;
        this.context = context;
    }

    @NonNull
    @Override
    public RepositoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_repo_item,
                parent, false);
        return new RepositoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoriesViewHolder holder, int position) {
        String RepoName = repositoryResponse.getRepositories().get(position).getName()!=null?repositoryResponse.getRepositories().get(position).getName():"";
        holder.repsName.setText(RepoName);
        String RepoDesc = repositoryResponse.getRepositories().get(position).getDescription()!= null? repositoryResponse.getRepositories().get(position).getDescription(): "";
        holder.repoDesc.setText(RepoDesc);
        String RepoOwnerName = repositoryResponse.getRepositories().get(position).getOwner().getLogin()!= null? repositoryResponse.getRepositories().get(position).getOwner().getLogin():"";
        holder.repoOwnerName.setText(RepoOwnerName);
        int StartsNumber = repositoryResponse.getRepositories().get(position).getStargazersCount()!= null ? repositoryResponse.getRepositories().get(position).getStargazersCount():0;
        holder.startsNumber.setText(String.valueOf(StartsNumber));
        Picasso.get().load(repositoryResponse.getRepositories().get(position).getOwner().getAvatarUrl()).into(holder.imageOwner);
    }

    @Override
    public int getItemCount() {
       return repositoryResponse.getRepositories().size();
    }

    static class RepositoriesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repoName)
        TextView repsName;
        @BindView(R.id.repoDesc)
        TextView repoDesc;
        @BindView(R.id.numberOfStarts)
        TextView startsNumber;
        @BindView(R.id.repoOwnerName)
        TextView repoOwnerName;
        @BindView(R.id.imgOwner)
        ImageView imageOwner;

        RepositoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
