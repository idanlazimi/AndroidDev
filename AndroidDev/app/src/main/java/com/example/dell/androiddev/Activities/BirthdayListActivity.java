package com.example.dell.androiddev.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.androiddev.R;

import java.util.ArrayList;
import java.util.List;

import Adapters.BdayListAdapter;
import Entities.BdayItem;
import Model.BdayDB;
import Model.DataDownloader;

public class BirthdayListActivity extends AppCompatActivity implements DataDownloader.OnFetchedListUpdateListener{

    private RecyclerView mRecyclerview;
    private BdayListAdapter mBdayListAdapter;
    private DataDownloader dataDownloader;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_list);


        mRecyclerview = findViewById(R.id.bday_list_recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerview.setLayoutManager(mLayoutManager);
        this.mBdayListAdapter = new BdayListAdapter(new ArrayList<>());
        mRecyclerview.setAdapter(mBdayListAdapter);

        dataDownloader = new DataDownloader(this,this);
        dataDownloader.execute();
        Log.d("MDG","FUKKKKK 222222");

    }


    @Override
    public void OnFetchUpdateUI(List<BdayItem> list) {
        this.mBdayListAdapter.updateList(list);
        Log.d("MDG","FUKKKKK");
    }
}
