package com.nvmvzv.kosbakalim.kosbakalim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Statement;

import java.lang.String;


public class MainActivity extends AppCompatActivity {




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
        setContentView(R.layout.activity_main);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);






        zaman = 0;
        handle = new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {

                zaman++;

                if (zaman == 3){

                    handle.removeCallbacks(runnable);




                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent);




                }
                handle.postDelayed(runnable, 1000);

            }
        };
        runnable.run();



    }
}
