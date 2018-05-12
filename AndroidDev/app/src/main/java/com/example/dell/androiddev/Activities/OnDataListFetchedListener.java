package com.example.dell.androiddev.Activities;

import java.util.List;

import Entities.BdayItem;

/**
 * Created by Dell on 12/05/2018.
 */

public interface OnDataListFetchedListener {

    void onDataListFetched(List<BdayItem> list);
}
