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

import Entities.ActivityItem;

import static Entities.ActivityItem.ActivityID.CALC;


/**
 * Created by Dell on 04/05/2018.
 */

public class MainIndexAdapter extends RecyclerView.Adapter<MainIndexAdapter.ViewHolder> {

    private ArrayList<ActivityItem> myActivityList;
    private Context mContext;

    public MainIndexAdapter(ArrayList<ActivityItem> myActivityList, Context context) {
        this.myActivityList = myActivityList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewGroup itemView =(ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_row_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ActivityItem myActivity = myActivityList.get(position);
        final ViewHolder viewHolder = holder;
        holder.title.setText(myActivity.getTitle());
        holder.decsription.setText(myActivity.getDescription());
        holder.image.setImageResource(myActivity.getImageResource());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final Context context = viewHolder.itemView.getContext();
                Intent intent = null;
                switch(myActivity.getActivityID()) {
                    case CALC:
                        intent = new Intent(mContext, CalculatorActivity.class);
                        break;
                    case BDAY:
                        intent = new Intent(mContext, BirthdayMainScreen.class);
                        break;
                }
                if(intent != null) {
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myActivityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title, decsription;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.activity_row_title);
            decsription = itemView.findViewById(R.id.activity_row_description);
            image = itemView.findViewById(R.id.activity_row_image);
        }
    }
}
