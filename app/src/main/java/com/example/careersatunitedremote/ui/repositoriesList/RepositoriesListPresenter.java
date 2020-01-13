package com.example.careersatunitedremote.ui.repositoriesList;

import android.content.Context;

import com.example.careersatunitedremote.manager.ApiManager;
import com.example.careersatunitedremote.model.RepositoryResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RepositoriesListPresenter {

    private RepositoriesListView repositoriesListView;
    private Context context;

    public RepositoriesListPresenter(Context context, RepositoriesListView repositoriesListView){
        this.context = context;
        this.repositoriesListView = repositoriesListView;
    }

    void getRepositoriesList(String date,int page){
        repositoriesListView.showLoading();
        ApiManager.getInstance().getRepository(date, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RepositoryResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RepositoryResponse repositoryResponse) {
                        repositoriesListView.setRepositoriesList(repositoryResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repositoriesListView.onError(e.getLocalizedMessage());
                        repositoriesListView.hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        repositoriesListView.hideLoading();
                    }
                });
    }
}
