package com.fukaimei.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_recycler_linear).setOnClickListener(this);
        findViewById(R.id.btn_recycler_grid).setOnClickListener(this);
        findViewById(R.id.btn_recycler_combine).setOnClickListener(this);
        findViewById(R.id.btn_recycler_staggered).setOnClickListener(this);
        findViewById(R.id.btn_recycler_dynamic).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_recycler_linear) {
            Intent intent = new Intent(this, RecyclerLinearActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_recycler_grid) {
            Intent intent = new Intent(this, RecyclerGridActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_recycler_combine) {
            Intent intent = new Intent(this, RecyclerCombineActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_recycler_staggered) {
            Intent intent = new Intent(this, RecyclerStaggeredActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_recycler_dynamic) {
            Intent intent = new Intent(this, RecyclerDynamicActivity.class);
            startActivity(intent);
        }
    }

}
