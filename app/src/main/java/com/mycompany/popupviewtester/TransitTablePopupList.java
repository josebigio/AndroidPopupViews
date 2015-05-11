package com.mycompany.popupviewtester;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by josebigio on 5/8/15.
 */
public class TransitTablePopupList extends BasePopupList {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public TransitTablePopupList(Context context) {
        super(context, R.layout.transit_table_popoup_view_layout);
        init();
    }

    public void init() {

        mRecyclerView = (RecyclerView) findViewById(R.id.transit_table_popup_view_recycler);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TransitTableAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }


}
