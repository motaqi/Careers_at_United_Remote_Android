package com.example.careersatunitedremote.ui.repositoriesList;

import com.example.careersatunitedremote.model.RepositoryResponse;

import java.util.List;

public interface RepositoriesListView {

    void setRepositoriesList(List<RepositoryResponse.Repository> repositories);
    void showLoading();
    void hideLoading();
    void onError(String message);

}
