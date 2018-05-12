package Model;

import android.arch.persistence.room.Database;
import android.content.Context;
import android.os.AsyncTask;

import com.example.dell.androiddev.Activities.BirthdayListActivity;

import java.util.List;

import Entities.BdayItem;

/**
 * Created by Dell on 12/05/2018.
 */

public class DataDownloader extends AsyncTask<Void,Void,List<BdayItem>> {

    private OnFetchedListUpdateListener listener;
    private Context mContext;
    public interface OnFetchedListUpdateListener {
        void OnFetchUpdateUI(List<BdayItem> list);
    }

    public DataDownloader(Context context, OnFetchedListUpdateListener listener){

        this.mContext = context;
        this.listener = listener;
    }
    @Override
    protected List<BdayItem> doInBackground(Void... voids) {

        return BdayDB.getInstance(mContext).getBdays();
    }

    @Override
    protected void onPostExecute(List<BdayItem> bdayItems) {
        super.onPostExecute(bdayItems);
        if( listener != null){
            listener.OnFetchUpdateUI(bdayItems);
        }
    }
}
