package Entities;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dell on 05/05/2018.
 */

public class BdayItem  {

    private String mName;
    private int day, month, year;
    private int imageResource;
    private int daysToBirthday;
    private Date mDate;
    private Calendar mCalendar = Calendar.getInstance();

    public BdayItem(String mName, int day, int month, int year) {
        this.mName = mName;
        this.day = day;
        this.month = month;
        this.year = year;

        computeBirthdayDelta();
    }

    public BdayItem(String mName, int day, int month, int year,int delta, int imageResource) {
        this.mName = mName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.daysToBirthday = delta;
        this.imageResource = imageResource;
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

    private void computeBirthdayDelta() {


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


}
