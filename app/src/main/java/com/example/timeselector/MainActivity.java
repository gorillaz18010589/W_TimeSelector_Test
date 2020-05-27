package com.example.timeselector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bruce.pickerview.popwindow.DatePickerPopWin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ConstraintLayout conStartTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        conStartTime = findViewById(R.id.cons_layoutA);
        conStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initStarSpinner();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cons_layoutA:
            Log.v("hank","conStartTime");
            initStarSpinner();
            break;
        }
    }

    private void initStarSpinner() {
        DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder(MainActivity.this, new DatePickerPopWin.OnDatePickedListener() {
            @Override
            public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                Toast.makeText(MainActivity.this, dateDesc, Toast.LENGTH_SHORT).show();
            }
        }).textConfirm("CONFIRM") //text of confirm button
                .textCancel("CANCEL") //text of cancel button
                .btnTextSize(16) // button text size
                .viewTextSize(25) // pick view text size
                .colorCancel(Color.parseColor("#999999")) //color of cancel button
                .colorConfirm(Color.parseColor("#009900"))//color of confirm button
                .minYear(1990) //min year in loop
                .maxYear(2550) // max year in loop
                .showDayMonthYear(true) // shows like dd mm yyyy (default is false)
                .dateChose("2013-11-11") // date chose when init popwindow
                .build();

        pickerPopWin.showPopWin(this);
        Log.v("hank","initStarSpinner");
    }

    public void btn_show(View view) {
    }
}
