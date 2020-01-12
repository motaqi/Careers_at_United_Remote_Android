package com.example.careersatunitedremote.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.careersatunitedremote.R;
import com.example.careersatunitedremote.manager.ApiManager;
import com.example.careersatunitedremote.model.RepositoryResponse;
import com.example.careersatunitedremote.ui.repositoriesList.RepositoriesListFragment;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RepositoriesListFragment repositoriesListFragment = new RepositoriesListFragment();
    }
}
