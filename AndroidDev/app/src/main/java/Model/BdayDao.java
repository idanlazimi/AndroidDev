package Model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import Entities.BdayItem;


/**
 * Created by Dell on 10/05/2018.
 */

@Dao
public interface BdayDao {


    @Query(NameUtil.GET_BDAY_ITEMS)
    List<BdayItem> getBdayitems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBdayItem(BdayItem bdayItem);

}
