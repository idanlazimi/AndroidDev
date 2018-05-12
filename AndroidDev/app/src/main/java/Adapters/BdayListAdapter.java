package Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.androiddev.Activities.BirthdayMainScreen;
import com.example.dell.androiddev.Activities.CalculatorActivity;
import com.example.dell.androiddev.R;

import java.util.ArrayList;
import java.util.List;

import Entities.ActivityItem;
import Entities.BdayItem;

import static Entities.ActivityItem.ActivityID.CALC;


/**
 * Created by Dell on 04/05/2018.
 */

public class BdayListAdapter extends RecyclerView.Adapter<BdayListAdapter.MyViewHolder> {

    private List<BdayItem> myActivityList;
    private Context mContext;

    public BdayListAdapter(List<BdayItem> myActivityList) {
        this.myActivityList = myActivityList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewGroup itemView =(ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.birthday_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final BdayItem bdayItem = myActivityList.get(position);

        final MyViewHolder viewHolder = holder;

        holder.name.setText(bdayItem.getmName());
        holder.date.setText(bdayItem.getDay() + "/" + bdayItem.getMonth() + "/" + bdayItem.getYear() + "");
        holder.delta.setText(bdayItem.getDaysToBirthday() + "");
        holder.image.setImageResource(bdayItem.getImageResource());

    }

    @Override
    public int getItemCount() {
        return myActivityList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, date, delta;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.bday_item_name);
            date = itemView.findViewById(R.id.bday_item_date);
            delta = itemView.findViewById(R.id.bday_item_days_to_bday);

            image = itemView.findViewById(R.id.bday_item_pic);


        }
    }
}
