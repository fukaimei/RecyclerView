package com.fukaimei.recyclerview;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fukaimei.recyclerview.adapter.LinearDynamicAdapter;
import com.fukaimei.recyclerview.bean.GoodsInfo;
import com.fukaimei.recyclerview.widget.RecyclerExtras;
import com.fukaimei.recyclerview.widget.SpacesItemDecoration;

public class RecyclerDynamicActivity extends AppCompatActivity implements OnClickListener
        , RecyclerExtras.OnItemClickListener, RecyclerExtras.OnItemLongClickListener, RecyclerExtras.OnItemDeleteClickListener {

    private RecyclerView rv_dynamic;
    private LinearDynamicAdapter mAdapter;
    private ArrayList<GoodsInfo> mPublicArray;
    private ArrayList<GoodsInfo> mAllArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_dynamic);
        findViewById(R.id.btn_recycler_add).setOnClickListener(this);
        rv_dynamic = (RecyclerView) findViewById(R.id.rv_dynamic);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayout.VERTICAL);
        rv_dynamic.setLayoutManager(manager);

        mAllArray = GoodsInfo.getDefaultList();
        mPublicArray = GoodsInfo.getDefaultList();
        mAdapter = new LinearDynamicAdapter(this, mPublicArray);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemLongClickListener(this);
        mAdapter.setOnItemDeleteClickListener(this);
        rv_dynamic.setAdapter(mAdapter);
        rv_dynamic.setItemAnimator(new DefaultItemAnimator());
        rv_dynamic.addItemDecoration(new SpacesItemDecoration(1));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_recycler_add) {
            int position = (int) (Math.random() * 100 % mAllArray.size());
            GoodsInfo old_item = mAllArray.get(position);
            GoodsInfo new_item = new GoodsInfo(old_item.pic_id, old_item.title, old_item.desc);
            mPublicArray.add(0, new_item);
            mAdapter.notifyItemInserted(0);
            rv_dynamic.scrollToPosition(0);
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {
        GoodsInfo item = mPublicArray.get(position);
        item.bPressed = !item.bPressed;
        mPublicArray.set(position, item);
        mAdapter.notifyItemChanged(position);
    }

    @Override
    public void onItemClick(View view, int position) {
        String desc = String.format("您点击了第%d项，标题是%s", position + 1,
                mPublicArray.get(position).title);
        Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemDeleteClick(View view, int position) {
        mPublicArray.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

}
