package com.dyvoker.gitsearch.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.dyvoker.gitsearch.R;
import com.dyvoker.gitsearch.core.ApiInterface;
import com.dyvoker.gitsearch.core.TestApi;

public class SearchActivity extends AppCompatActivity {

    private ApiInterface api = TestApi.Instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
