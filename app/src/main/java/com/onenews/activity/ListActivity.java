package com.onenews.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.onenews.R;
import com.onenews.widgets.DividerItemDecoration;

public abstract class ListActivity extends BaseActivity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.city_rl);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(getAdapter());
        setRecyclerViewStyle(mRecyclerView);
        init();
    }


    abstract void setRecyclerViewStyle(RecyclerView recyclerView);


    abstract RecyclerView.Adapter getAdapter();

    abstract void init();
}
