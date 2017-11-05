package com.fukaimei.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import com.fukaimei.recyclerview.adapter.StaggeredAdapter;
import com.fukaimei.recyclerview.bean.GoodsInfo;
import com.fukaimei.recyclerview.widget.SpacesItemDecoration;

public class RecyclerStaggeredActivity extends AppCompatActivity {

    private RecyclerView rv_staggered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_staggered);
        rv_staggered = (RecyclerView) findViewById(R.id.rv_staggered);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
        rv_staggered.setLayoutManager(manager);

        StaggeredAdapter adapter = new StaggeredAdapter(this, GoodsInfo.getDefaultStag());
        adapter.setOnItemClickListener(adapter);
        adapter.setOnItemLongClickListener(adapter);
        rv_staggered.setAdapter(adapter);
        rv_staggered.setItemAnimator(new DefaultItemAnimator());
        rv_staggered.addItemDecoration(new SpacesItemDecoration(3));
    }

}
