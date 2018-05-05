package com.example.dell.androiddev.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.dell.androiddev.R;

import java.util.ArrayList;

import Adapters.BdayListAdapter;
import Entities.BdayItem;

public class BirthdayListActivity extends AppCompatActivity {

    private ArrayList<BdayItem> mBdayArrayList = new ArrayList<>();
    private RecyclerView mRecyclerview;
    private BdayListAdapter mBdayListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_list);

        mRecyclerview = findViewById(R.id.bday_list_recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerview.setLayoutManager(mLayoutManager);

        mBdayArrayList.add(new BdayItem("John John",22,12,1933,50,R.mipmap.boy));
        mBdayArrayList.add(new BdayItem("Ha Zilla",30,11,1987,90,R.mipmap.girl));

        mBdayListAdapter = new BdayListAdapter(mBdayArrayList);
        mRecyclerview.setAdapter(mBdayListAdapter);

    }

}
