package com.example.stopwatchapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Chronometer stopWatch;
    private Boolean isOn = false;
    private long stopOffset;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.dark_sapphire));

        stopWatch = findViewById(R.id.chronometer);
    }

    public void startChronometer(View view) {
        if(!isOn){
            stopWatch.setBase(SystemClock.elapsedRealtime() - stopOffset);
            stopWatch.start();
            isOn = true;
        }
    }

    public void holdChronometer(View view) {
        if(isOn){
            stopWatch.stop();
            stopOffset = SystemClock.elapsedRealtime() - stopWatch.getBase();
            isOn = false;
        }
    }

    public void stopChronometer(View view) {
        if(isOn){
            stopWatch.stop();
            stopOffset = SystemClock.elapsedRealtime() - stopWatch.getBase();
            isOn = false;
        }
        stopWatch.setBase(SystemClock.elapsedRealtime());
        stopOffset = 0;
    }
}