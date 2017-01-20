package com.dyvoker.gitsearch.core;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface for Retrofit
 */

public interface GitApiInterface {

    @GET("search/repositories") //Get page of repositories by query from GitHub Api
    Call<GitRepositoryPage> getPage(@Query("q") String query,
                                    @Query("page") int page);
}
