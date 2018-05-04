package com.example.dell.androiddev.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.androiddev.R;


import java.util.ArrayList;

import Adapters.MainIndexAdapter;
import Entities.ActivityItem;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ActivityItem> activityItemArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.index_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        activityItemArrayList.add(new ActivityItem("Calculator","Mobile Calculator",R.mipmap.calculator_1, ActivityItem.ActivityID.CALC));
        activityItemArrayList.add(new ActivityItem("Birthday Ex","Birthday Shit dick",R.mipmap.gift_1, ActivityItem.ActivityID.BDAY));
        mRecyclerView.setAdapter(new MainIndexAdapter(activityItemArrayList));

    }



}
