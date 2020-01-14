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
import com.example.careersatunitedremote.helper.EndlessRecyclerViewScrollListener;
import com.example.careersatunitedremote.model.RepositoryResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RepositoriesListFragment extends Fragment implements RepositoriesListView{

    private RepositoriesListPresenter repositoriesListPresenter;
    private LinearLayoutManager linearLayoutManager;
    private List<RepositoryResponse.Repository> repositoryList;
    private RepositoriesListFragmentAdapter repositoriesListFragmentAdapter;

    private static final int PAGE_START = 1;
    public static final String DATE_QUERY="created:>2017-10-22";

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
        linearLayoutManager = new LinearLayoutManager(getContext());
        loadMoreListener();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repositoriesListPresenter.getRepositoriesList(DATE_QUERY, PAGE_START);

    }

    private void loadMoreListener() {
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                repositoriesListPresenter.loadMore(DATE_QUERY, page);
            }
        });
    }

    @Override
    public void setRepositoriesList(RepositoryResponse repositoryResponse) {
        repositoryList = repositoryResponse.getRepositories();
        repositoriesListFragmentAdapter = new RepositoriesListFragmentAdapter(repositoryList, getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setClipToPadding(false);
        recyclerView.setAdapter(repositoriesListFragmentAdapter);
        repositoriesListFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadMore(List<RepositoryResponse.Repository> repositories) {
        repositoryList.addAll(repositories);
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
        progressBar.setVisibility(View.GONE);
    }
}
