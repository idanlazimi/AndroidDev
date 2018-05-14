package com.example.dell.androiddev.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dell.androiddev.R;

import Entities.BdayItem;
import Model.BdayDB;
import Model.InputFilterMinMax;

public class BirthdayMainScreen extends AppCompatActivity {

    private EditText mNameField, mDay, mMonth, mYear;
    private Button mAddBday, mDisplayBdayList;
    private Spinner mSpinner;

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
        mAddBday.setOnClickListener( (View v) -> {

            //BdayItem bdayItem = new BdayItem();

            if(mNameField.getText() == null || mDay.getText() == null || mMonth.getText() == null || mYear.getText() == null ){
                Toast.makeText(this, "Invalid parmater/s", Toast.LENGTH_LONG).show();
                return;
            }

            int imageResource = R.mipmap.boy;
            if (mSpinner.getSelectedItem().toString() == "Mrs."){
                imageResource = R.mipmap.girl;
            }


            BdayItem bdayItem = new BdayItem(
                    mNameField.getText().toString(),
                    Integer.parseInt(mDay.getText().toString()),
                    Integer.parseInt(mMonth.getText().toString()),
                    Integer.parseInt(mYear.getText().toString()),
                    7,
                    imageResource
                    );


            BdayDB.getInstance(this).addBdayItem(bdayItem);
            Toast.makeText(this, "Added To List", Toast.LENGTH_LONG).show();
            mNameField.setText("");
            mDay.setText("");
            mMonth.setText("");
            mYear.setText("");
        });
        mDisplayBdayList= (Button) findViewById(R.id.bday_menu_display_bdays_button);
        mDisplayBdayList.setOnClickListener( (View v) -> {
            startActivity(new Intent(this, BirthdayListActivity.class));
        });
        mSpinner = (Spinner) findViewById(R.id.main_bday_activity_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mr_mrs_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);
    }

}
