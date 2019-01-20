package com.nvmvzv.kosbakalim.kosbakalim;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;

public class SonActivity  extends AppCompatActivity {




    TextView txt;
    Handler handle = null;
    Runnable runnable = null;
    int zaman;


    String line;
    boolean netvar = true;
    BufferedReader reader;

    Boolean baglantivarmi = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

}