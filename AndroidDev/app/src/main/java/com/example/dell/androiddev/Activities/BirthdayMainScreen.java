package com.example.dell.androiddev.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dell.androiddev.R;

public class BirthdayMainScreen extends AppCompatActivity {

    private EditText mNameField, mDay, mMonth, mYear;
    private Button mAddBday, mDisplayBdayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_main_screen);

        mNameField = (EditText) findViewById(R.id.bday_menu_nameField);

        mDay = (EditText) findViewById(R.id.bday_menu_day_field);
        mMonth = (EditText) findViewById(R.id.bday_menu_month_field);
        mYear = (EditText) findViewById(R.id.bday_menu_year_field);

        mAddBday = (Button) findViewById(R.id.bday_menu_add_bday_button);
        mDisplayBdayList= (Button) findViewById(R.id.bday_menu_display_bdays_button);
    }

}
