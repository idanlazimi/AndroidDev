package Model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.example.dell.androiddev.Activities.OnDataListFetchedListener;

import java.util.ArrayList;
import java.util.List;

import Entities.BdayItem;

/**
 * Created by Dell on 10/05/2018.
 */

@Database(entities = BdayItem.class, version=2, exportSchema = false)
public abstract class BdayDB extends RoomDatabase {

    private static BdayDB mBdayDBInstane;
    private Context mContext;

    public static BdayDB getInstance(Context context) {

        synchronized (BdayDB.class) {
            if (mBdayDBInstane == null) {
                // notice getApplicationContext
                // -- it prevents the memory leak that would happen if the activity was passed
                mBdayDBInstane = Room.databaseBuilder(context.getApplicationContext(),
                        BdayDB.class, NameUtil.BDAY_ITEM_NAME)
                        .addMigrations(MIGRATION_1_2) // placeholder for future db versions
                        .build();
            }
            return mBdayDBInstane;
        }
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "CREATE TABLE IF NOT EXISTS bday_items(" +
                            "birthday_id INTEGER," +
                            "birth_date_day DATE_DAY, " +
                            "birth_date_month DATE_MONTH, " +
                            "birth_date_YEAR DATE_YEAR, " +
                            "person_name VARCHAR(128), " +
                            "image_id   INTEGER, " +
                            "PRIMARY KEY(birthday_id))"
            );
        }
    };

    public abstract BdayDao getBirthdayDao();

    public List<BdayItem> getBdays() {

        return getBirthdayDao().getBdayitems();

    }

    public void addBdayItem(final BdayItem bday) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getBirthdayDao().insertBdayItem(bday);
            }
        }).start();
    }


}
