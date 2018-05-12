package Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Model.NameUtil;

/**
 * Created by Dell on 05/05/2018.
 */
@Entity(tableName = NameUtil.BDAY_TABLE_NAME)
public class BdayItem  {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = NameUtil.BDAY_ITEM_NAME)
    public String mName;

    @ColumnInfo(name = NameUtil.BDAY_ITEM_DATE_DAY)
    public int day;

    @ColumnInfo(name = NameUtil.BDAY_ITEM_DATE_MONTH)
    public int month;

    @ColumnInfo(name = NameUtil.BDAY_ITEM_DATE_YEAR)
    public int year;

    @ColumnInfo(name = NameUtil.IMAGE_RESOURCE)
    public int imageResource;

    @ColumnInfo(name = NameUtil.DAYS_TO_BDAY)
    public int daysToBirthday;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getDaysToBirthday() {
        return daysToBirthday;
    }

    public void setDaysToBirthday(int daysToBirthday) {
        this.daysToBirthday = daysToBirthday;
    }

    public BdayItem(){}

    public BdayItem(String mName, int day, int month, int year,int delta, int imageResource) {
        this.mName = mName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.daysToBirthday = delta;
        this.imageResource = imageResource;
        this.daysToBirthday = computeBirthdayDelta();
    }

    private int computeBirthdayDelta() {

//        DateTime current = new Date();
//        daysToBirthday = Days.daysBetween(new LocalDate(),new LocalDateTime(year,month,day,12,12));
        //TODO add logic
        return 10;
    }

}
