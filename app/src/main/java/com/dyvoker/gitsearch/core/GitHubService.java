package com.dyvoker.gitsearch.core;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Service for work with git hub
 */

public class GitHubService {

    public static final GitHubService Instance = new GitHubService();

    private ArrayList<GitRepositoryPage> pages = new ArrayList<>();
    private SearchListener searchListener;
    private String searchQuery;
    private int lastLoadedPage = 0;
    private int totalCountForQuery = 0;

    public ArrayList<GitRepositoryPage> GetRepositoryPages() {
        return pages;
    }

    public void loadNextPage() {
        if (getLoadedRepoCount() < totalCountForQuery) { //Don't load if all repositories for search request already loaded
            GitApi.Instance.getPage(searchQuery, lastLoadedPage + 1).enqueue(new Callback<GitRepositoryPage>() {
                @Override
                public void onResponse(Call<GitRepositoryPage> call, Response<GitRepositoryPage> response) {
                    if (response.body() == null) {
                        //Error or limit of requests
                        //response.message() == "Forbidden"
                    } else {
                        lastLoadedPage++;
                        pages.add(response.body());
                        if (searchListener != null) {
                            searchListener.onPageLoad(pages.get(pages.size() - 1));
                        }
                    }
                }

                @Override
                public void onFailure(Call<GitRepositoryPage> call, Throwable t) {
                }
            });
        }
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
        GitApi.Instance.getPage(searchQuery, 1).enqueue(new Callback<GitRepositoryPage>() {
            @Override
            public void onResponse(Call<GitRepositoryPage> call, Response<GitRepositoryPage> response) {
                lastLoadedPage = 1;
                pages = new ArrayList<>();
                if (response.body() == null) {
                    //Didn't find results or error or limit of requests
                    //response.message() == "Forbidden"
                } else {
                    pages.add(response.body());
                    totalCountForQuery = response.body().total_count;
                }
                if (searchListener != null) {
                    searchListener.onAllUpdated();
                }
            }

            @Override
            public void onFailure(Call<GitRepositoryPage> call, Throwable t) {}
        });
    }

    public void setSearchListener(SearchListener listener) {
        searchListener = listener;
    }

    private int getLoadedRepoCount() {
        int count = 0;
        for (GitRepositoryPage page : pages) {
            if (page != null && page.items != null) {
                count += page.items.length;
            }
        }
        return count;
    }
}
