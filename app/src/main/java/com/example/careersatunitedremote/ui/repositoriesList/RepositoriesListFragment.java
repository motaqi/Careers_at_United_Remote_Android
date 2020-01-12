package com.example.careersatunitedremote.ui.repositoriesList;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.careersatunitedremote.R;
import com.example.careersatunitedremote.model.RepositoryResponse;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RepositoriesListFragment extends Fragment implements RepositoriesListView{

    private RepositoriesListPresenter repositoriesListPresenter;

    public RepositoriesListFragment() {
        repositoriesListPresenter = new RepositoriesListPresenter(getContext(), this);
        repositoriesListPresenter.getRepositoriesList("created:>2019-10-22", 1);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_repositories_list, container, false);
        return rootView;
    }

    @Override
    public void setRepositoriesList(List<RepositoryResponse.Repository> repositories) {
        Log.d("REPOS", "setRepositoriesList: "+repositories.size());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }
}
