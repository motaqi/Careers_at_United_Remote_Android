package com.example.careersatunitedremote.api;

import com.example.careersatunitedremote.model.RepositoryResponse;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepositoryApi {

    @GET("repositories")
    Observable<RepositoryResponse> getRepositories(@Query("q") String date,
                                                   @Query(("page")) int page);
}
