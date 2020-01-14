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
import com.example.careersatunitedremote.util.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoriesListFragmentAdapter extends RecyclerView.Adapter<RepositoriesListFragmentAdapter.RepositoriesViewHolder>{

    private List<RepositoryResponse.Repository> repositoryList;
    private Context context;


    public RepositoriesListFragmentAdapter(List<RepositoryResponse.Repository> repositoryList, Context context){
        this.repositoryList = repositoryList;
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
        String RepoName = repositoryList.get(position).getName()!=null?repositoryList.get(position).getName():"";
        holder.repsName.setText(RepoName);
        String RepoDesc = repositoryList.get(position).getDescription()!= null? repositoryList.get(position).getDescription(): "";
        holder.repoDesc.setText(RepoDesc);
        String RepoOwnerName = repositoryList.get(position).getOwner().getLogin()!= null? repositoryList.get(position).getOwner().getLogin():"";
        holder.repoOwnerName.setText(RepoOwnerName);
        int StartsNumber = repositoryList.get(position).getStargazersCount()!= null ? repositoryList.get(position).getStargazersCount():0;
        holder.startsNumber.setText(Utils.formattingNumber(StartsNumber));
        Picasso.get().load(repositoryList.get(position).getOwner().getAvatarUrl()).into(holder.imageOwner);
    }

    @Override
    public int getItemCount() {
        if (repositoryList!= null){
            return repositoryList.size();
        }else {
            return 0;
        }

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
