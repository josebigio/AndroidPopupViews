package com.mycompany.popupviewtester;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by josebigio on 5/9/15.
 */
public class TransitTableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = "TransitTableAdapter";

    private static final int TEST_ROWS = 100;
    private static final int ROWS_PER_HOUR = 3;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }

    }

    public static class HeaderHolder extends ViewHolder {

        public HeaderHolder(View itemView) {
            super(itemView);

        }

    }

    public static class TransitCellHolder extends ViewHolder {

        TextView initialTime;
        TextView nextTime;
        View realTimeView;
        ViewGroup initialTimeBlock;
        ViewGroup nextTimeBlock;
        View nextTimeArrow;
        boolean isShowingRealTime;
        boolean isShowingNextTime;

        public TransitCellHolder(View itemView) {
            super(itemView);
            initialTime = (TextView)itemView.findViewById(R.id.initialTimeTV);
            nextTime = (TextView)itemView.findViewById(R.id.nextTimeTV);
            realTimeView = itemView.findViewById(R.id.realtimeView);
            initialTimeBlock = (ViewGroup)itemView.findViewById(R.id.initialTimeBlock);
            nextTimeBlock = (ViewGroup)itemView.findViewById(R.id.nextTimeBlock);
            nextTimeArrow = itemView.findViewById(R.id.rightArrowTransit);
            isShowingRealTime = true;
            isShowingNextTime = true;
        }

        public void showRealTimeLabel(boolean value) {
            if(!value) {
                initialTimeBlock.removeView(realTimeView);
            }
            else {
                if(!isShowingRealTime)
                    initialTimeBlock.addView(realTimeView);
            }
            isShowingRealTime = value;
        }

        public void setNextTime(String nextDeparture) {
            if(nextDeparture==null) {
                nextTimeBlock.removeView(nextTimeArrow);
                nextTimeBlock.removeView(nextTime);
                isShowingNextTime = false;
            }
            else {

                if(!isShowingNextTime) {
                    nextTimeBlock.addView(nextTimeArrow);
                    nextTimeBlock.addView(nextTime);
                    nextTime.setText(nextDeparture);
                }
                else{
                    nextTime.setText(nextDeparture);
                }

                isShowingNextTime = true;
            }

        }

    }


    public static final int HEADER_TYPE = 0;
    public static final int TRANSIT_CELL_TYPE = 1;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        Log.v(TAG, "OnCreateViewHolder(" + viewGroup + ", " + i);
        View v;
        switch (i) {
            case HEADER_TYPE:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transit_table_header, viewGroup, false);
                return new HeaderHolder(v);
            case TRANSIT_CELL_TYPE:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transit_table_schedule_cell, viewGroup, false);
                return new TransitCellHolder(v);
            default:
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transit_table_schedule_cell, viewGroup, false);
                return new TransitCellHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getClass() == HeaderHolder.class) {

        }
        else if (viewHolder.getClass() == TransitCellHolder.class) {
            TransitCellHolder tch = (TransitCellHolder)viewHolder;
            if(i%3==0) {
                tch.setNextTime("10:59 AM");
            }
            else{
                tch.setNextTime(null);
            }

            if(i%2==0) {
                tch.showRealTimeLabel(false);
            }
            else{
                tch.showRealTimeLabel(true);
            }
        }
    }


    @Override
    public int getItemCount() {
        return TEST_ROWS;
    }

    @Override
    public int getItemViewType(int position) {
        Log.v(TAG, "getItemViewType(" + position + ")");

        return (position%(ROWS_PER_HOUR+1) == 0) ? HEADER_TYPE:TRANSIT_CELL_TYPE;
    }




}


