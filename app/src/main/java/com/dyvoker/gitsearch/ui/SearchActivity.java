package com.dyvoker.gitsearch.ui;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dyvoker.gitsearch.R;
import com.dyvoker.gitsearch.core.GitHubService;
import com.dyvoker.gitsearch.core.GitRepositoryPage;
import com.dyvoker.gitsearch.core.SearchListener;

public class SearchActivity extends AppCompatActivity
    implements SearchListener {

    private GitHubService gitHubService = GitHubService.Instance;

    private RecyclerView searchResultView;
    private final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    private SearchResultAdapter searchResultAdapter;

    private boolean loading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        //Set up RecyclerView
        searchResultView = (RecyclerView) findViewById(R.id.search_result_view);
        searchResultView.setHasFixedSize(true);
        searchResultView.setLayoutManager(layoutManager);

        searchResultAdapter = new SearchResultAdapter();
        searchResultView.setAdapter(searchResultAdapter);
        searchResultView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(final RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!loading) {
                    if (dy > 0) {
                        int totalItemCount = layoutManager.getItemCount();
                        int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                        GitRepositoryPage page = searchResultAdapter.getRepositoryPage(lastVisibleItem);
                        if ((totalItemCount - lastVisibleItem) <=
                                page.items.length) {
                            loading = true;
                            gitHubService.loadNextPage();
                        }
                    }
                }
            }
        });

        //Set up service
        gitHubService.setSearchListener(this);
        searchResultAdapter.setGitRepositoryPages(gitHubService.GetRepositoryPages());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gitHubService.setSearchListener(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        final MenuItem searchMenuItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                MenuItemCompat.collapseActionView(searchMenuItem);
                gitHubService.setSearchQuery(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public void onAllUpdated() {
        searchResultAdapter.setGitRepositoryPages(gitHubService.GetRepositoryPages());
        layoutManager.scrollToPositionWithOffset(0, 0);
        loading = false;
    }

    @Override
    public void onPageLoad(GitRepositoryPage page) {
        searchResultAdapter.addGitRepositoryPage(page);
        loading = false;
    }
}
