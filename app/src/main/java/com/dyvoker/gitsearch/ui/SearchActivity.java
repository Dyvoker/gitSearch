package com.dyvoker.gitsearch.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.dyvoker.gitsearch.R;
import com.dyvoker.gitsearch.core.ApiInterface;
import com.dyvoker.gitsearch.core.TestApi;

public class SearchActivity extends AppCompatActivity {

    private ApiInterface api = TestApi.Instance;

    private RecyclerView searchResultView;
    private SearchResultAdapter searchResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        //Set up RecyclerView
        searchResultView = (RecyclerView) findViewById(R.id.search_result_view);
        searchResultView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        searchResultView.setLayoutManager(layoutManager);

        searchResultAdapter = new SearchResultAdapter(api.getGitRepInfoList("req", 0, 1));
        searchResultView.setAdapter(searchResultAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
