package com.example.careersatunitedremote.ui.repositoriesList;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.careersatunitedremote.R;
import com.example.careersatunitedremote.adapter.RepositoriesListFragmentAdapter;
import com.example.careersatunitedremote.model.RepositoryResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RepositoriesListFragment extends Fragment implements RepositoriesListView{

    private RepositoriesListPresenter repositoriesListPresenter;

    // UI Variables
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;

    public RepositoriesListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_repositories_list, container, false);
        ButterKnife.bind(this, rootView);
        repositoriesListPresenter = new RepositoriesListPresenter(getContext(), this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repositoriesListPresenter.getRepositoriesList("created:>2017-10-22", 1);
    }

    @Override
    public void setRepositoriesList(RepositoryResponse repositoryResponse) {
       for (RepositoryResponse.Repository repository: repositoryResponse.getRepositories()){
           Log.d("REPOS", "setRepositoriesList: "+repository.getFullName());
       }

        RepositoriesListFragmentAdapter repositoriesListFragmentAdapter = new RepositoriesListFragmentAdapter(repositoryResponse, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setClipToPadding(false);
        recyclerView.setAdapter(repositoriesListFragmentAdapter);
        repositoriesListFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        Log.d("REPOERROR", "onError: "+message);
    }
}
