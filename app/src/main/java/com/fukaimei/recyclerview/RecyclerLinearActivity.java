package com.fukaimei.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.fukaimei.recyclerview.adapter.LinearAdapter;
import com.fukaimei.recyclerview.bean.GoodsInfo;
import com.fukaimei.recyclerview.widget.SpacesItemDecoration;

public class RecyclerLinearActivity extends AppCompatActivity {

    private RecyclerView rv_linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_linear);
        rv_linear = (RecyclerView) findViewById(R.id.rv_linear);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayout.VERTICAL);
        rv_linear.setLayoutManager(manager);

        LinearAdapter adapter = new LinearAdapter(this, GoodsInfo.getDefaultList());
        adapter.setOnItemClickListener(adapter);
        adapter.setOnItemLongClickListener(adapter);
        rv_linear.setAdapter(adapter);
        rv_linear.setItemAnimator(new DefaultItemAnimator());
        rv_linear.addItemDecoration(new SpacesItemDecoration(1));
    }

}
