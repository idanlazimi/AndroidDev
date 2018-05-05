package com.example.dell.androiddev.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dell.androiddev.R;

import Model.InputFilterMinMax;

public class BirthdayMainScreen extends AppCompatActivity {

    private EditText mNameField, mDay, mMonth, mYear;
    private Button mAddBday, mDisplayBdayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_main_screen);

        mNameField = (EditText) findViewById(R.id.bday_menu_nameField);

        mDay = (EditText) findViewById(R.id.bday_menu_day_field);
        mDay.setFilters(new InputFilter[]{new InputFilterMinMax(1,31) {
        }});
        mMonth = (EditText) findViewById(R.id.bday_menu_month_field);
        mMonth.setFilters(new InputFilter[]{new InputFilterMinMax(1,12) {
        }});
        mYear = (EditText) findViewById(R.id.bday_menu_year_field);
        mYear.setFilters(new InputFilter[]{new InputFilterMinMax(1,2021) {
        }});

        mAddBday = (Button) findViewById(R.id.bday_menu_add_bday_button);
        mDisplayBdayList= (Button) findViewById(R.id.bday_menu_display_bdays_button);
        mDisplayBdayList.setOnClickListener( (View v) -> {
            startActivity(new Intent(this, BirthdayListActivity.class));
        });
    }

}
