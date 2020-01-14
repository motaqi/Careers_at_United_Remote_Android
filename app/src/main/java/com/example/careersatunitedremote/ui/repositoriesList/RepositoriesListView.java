package com.example.careersatunitedremote.ui.repositoriesList;

import com.example.careersatunitedremote.model.RepositoryResponse;

import java.util.List;

public interface RepositoriesListView {

    void setRepositoriesList(RepositoryResponse repositoryResponse);
    void loadMore(List<RepositoryResponse.Repository> repositoryList);
    void showLoading();
    void hideLoading();
    void onError(String message);


}
