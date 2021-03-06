package com.dyvoker.gitsearch.core;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Api for Git Hub with using retrofit
 */

public class GitApi {

    public static final GitApiInterface INSTANCE;

    private static final String BASE_URL = "https://api.github.com/";

    static {
        //INSTANCE = new TestGitApi();
        //For test api: uncomment before and comment below
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        INSTANCE = retrofit.create(GitApiInterface.class);
    }
}
