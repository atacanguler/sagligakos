package com.nvmvzv.kosbakalim.kosbakalim;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.media.MediaCas;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewDebug;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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
import android.widget.Toast;

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
import java.util.Random;
import java.util.StringTokenizer;


public class SecondActivity  extends AppCompatActivity {

    String singleLine = "";
    BufferedReader reader = null;
    Statement st;
    Connection con = null;

    Button btn_start;
    private static final int REQUEST_PERMISSIONS = 100;
    boolean boolean_permission;
    SharedPreferences mPref;
    SharedPreferences.Editor medit;
    Double latitude, longitude;
    Geocoder geocoder;

    String LATI = "";
    String LONG = "";

    GPSTracker gpss;
    GPSTracker gpstrackerr;
    GPSTracker gpstrackerr2;

    Handler handle = null;
    Runnable runnable = null;

    Handler handlex = null;
    Runnable runnablex = null;


    int zaman;
    int zamanx;

    String XxX = "";
    String YyY = "";
    String SessionKODU = "";

    double distance;
    float TOPLAMdistance;
    double TOPLAMkalori = 0.0;


    public static String SayacAktifDurumda = "0";

    public static String HarcananKalorii = "0";




    public void konumGuncelleme() {


        ////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////


        zamanx = 0;
        handlex = new Handler();
        runnablex = new Runnable() {


            @Override
            public void run() {


                zamanx++;


                handlex.removeCallbacks(runnablex);


                if (0 == 0) {


                    ////////////////////////////////////////////////////////////////////////////////


                    if (zamanx % 15 == 0) {
                        /////////////////////////////////////////////////////////////////////////////////////////////////


                        //  try {

                        // CALL GetText method to make post method call


                        gpstrackerr2 = new GPSTracker(SecondActivity.this);


                        if (gpstrackerr2.canGetLocation()) { // gps enabled} // return boolean true/false


                            gpstrackerr2.getLatitude(); // returns latitude
                            gpstrackerr2.getLongitude(); //

                            XxX = Double.toString(gpstrackerr2.latitude);
                            YyY = Double.toString(gpstrackerr2.longitude);


                            if (SayacAktifDurumda == "1") {


                                try {


                                    GetText(XxX, YyY, SessionKODU);

                                    zamanx = 0;

                                } catch (Exception ex) {

                                }

                                ////////////////////////////////////////////////////////////////////////////////////////////////


                                TextView myTextView = (TextView) findViewById(R.id.textXXXView);
                                String aaa = myTextView.getText().toString();

                                if(aaa.indexOf("@@") >= 0){

                                String[] parca = aaa.split("@@");

                                if (parca.length >= 1) {

                                    String bolum1 = parca[parca.length - 1].toString();
                                    String bolum2 = parca[parca.length - 2].toString();

                                    ////// bolum1

                                    String[] parcacik = bolum1.toString().split("-");
                                    String[] cik = parcacik[0].toString().split(":");
                                    String[] cik2 = parcacik[1].toString().split(":");


                                    /////// bolum2


                                    String[] Sparcacik2 = bolum2.toString().split("-");
                                    String[] Scik = Sparcacik2[0].toString().split(":");
                                    String[] Scik2 = Sparcacik2[1].toString().split(":");


                                    String son1X = cik[1].toString().replace(",",".").toString();
                                    String son1Y = cik2[1].toString().replace(",",".").toString();


                                    String son2X = Scik[1].toString().replace(",",".").toString();
                                    String son2Y = Scik2[1].toString().replace(",",".").toString();

                                    Float F1X = Float.parseFloat(son1X.toString());
                                    Float F1Y = Float.parseFloat(son1Y.toString());

                                    Float F2X = Float.parseFloat(son2X.toString());
                                    Float F2Y = Float.parseFloat(son2Y.toString());

                                    /////////////////////

                                    //Float F1X = Float.parseFloat("32.2563");
                                    //Float F1Y = Float.parseFloat("32.2569");

                                    //Float F2X = Float.parseFloat("32.2556");
                                    //Float F2Y = Float.parseFloat("32.2557");




                                    /////////

                                    // Approximate Equirectangular -- works if (lat1,lon1) ~ (lat2,lon2)
                                    int RR = 6371; // km
                                    double x = (F2Y - F1Y) * Math.cos((F1X + F2X) / 2);
                                    double y = (F2X - F1X);
                                    distance = Math.sqrt(x * x + y * y) * RR;

                                    TOPLAMdistance += Float.parseFloat(String.valueOf(distance));

                                    /////////////////////////////////////////////////////////////////////////

                                    if(TOPLAMdistance > 100){


                                        TOPLAMkalori = (TOPLAMdistance * 8) / 100;

                                    }


                                    /////////////////////////////////////////////////////////////////////////7

                                    TextView MytextKaloriXX = (TextView) findViewById(R.id.textViewC);
                                    MytextKaloriXX.setText(String.valueOf(TOPLAMkalori));



                                    TextView MytextViewX = (TextView) findViewById(R.id.textViewX);
                                    MytextViewX.setText(String.valueOf(TOPLAMdistance));


                                }
                                    /////////////////////////////////////////////////////////////////////////////////////////////////

                                }
                                    Toast.makeText(getApplicationContext(), "Koordinatlar Güncellendi", Toast.LENGTH_LONG).show();

                                }
                            }


//                            } catch (Exception ex) {

                            //                          }


                            //////////////////////////////////////////////////////////////////////////////////////////////////


                        }

                        ///////////////////////////////////////////////////////////7


                    }
                    handlex.postDelayed(runnablex, 1000);


                }
            }

            ;
            runnablex.run();


            ///////////////////////////////////////////////////////////7



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);





        try{


        konumGuncelleme();



        } catch (Exception ex) {

        }
///////////////////////////////////////////////////



        Button btnClickMeNextt = (Button) findViewById(R.id.buttonNextt);
        btnClickMeNextt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {

                    GetSayac("DUR");



                } catch (Exception ex) {

                }


                try {

                    // CALL GetText method to make post method call

                    gpstrackerr = new GPSTracker(SecondActivity.this);

                    if (gpstrackerr.canGetLocation()) { // gps enabled} // return boolean true/false

                        gpstrackerr.getLatitude(); // returns latitude
                        gpstrackerr.getLongitude(); //

                        String XxX = Double.toString(gpstrackerr.latitude);
                        String YyY = Double.toString(gpstrackerr.longitude);


                        GetTextClose(XxX, YyY, SessionKODU);

                        gpstrackerr.stopUsingGPS();

                        SayacAktifDurumda = "0";


                        TextView KalCek = (TextView) findViewById(R.id.textViewC);
                        String Kalorii = KalCek.getText().toString();


                        HarcananKalorii = Kalorii.toString();

                        Toast.makeText(getApplicationContext(), "Koordinat Gönderme Kapatıldı", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), VeriActivity.class);
                        startActivity(intent);


                    }

                } catch (Exception ex) {

                }

//////////////////////////////////////////////////////////////////////////////////


            }
        });





/////////////////////////////////////////////////

    Button btnClickMe2 = (Button) findViewById(R.id.buttonDurdur);
        btnClickMe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {

                    GetSayac("DUR");



                } catch (Exception ex) {

                }


                try {

                    // CALL GetText method to make post method call

                    gpstrackerr = new GPSTracker(SecondActivity.this);

                    if (gpstrackerr.canGetLocation()) { // gps enabled} // return boolean true/false

                        gpstrackerr.getLatitude(); // returns latitude
                        gpstrackerr.getLongitude(); //

                        String XxX = Double.toString(gpstrackerr.latitude);
                        String YyY = Double.toString(gpstrackerr.longitude);


                        GetTextClose(XxX, YyY, SessionKODU);

                        gpstrackerr.stopUsingGPS();

                        SayacAktifDurumda = "0";


                        Toast.makeText(getApplicationContext(), "Koordinat Gönderme Kapatıldı", Toast.LENGTH_LONG).show();


                    }

                } catch (Exception ex) {

                }


            }
        });


        //////////

        Button btnClickMeSifirla = (Button) findViewById(R.id.buttonSifirla);
        btnClickMeSifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    // CALL GetText method to make post method call

                    gpstrackerr = new GPSTracker(SecondActivity.this);
                    if (gpstrackerr.canGetLocation()) { // gps enabled} // return boolean true/false

                        gpstrackerr.getLatitude(); // returns latitude
                        gpstrackerr.getLongitude(); //

                        String XxX = Double.toString(gpstrackerr.latitude);
                        String YyY = Double.toString(gpstrackerr.longitude);


                        Random rand = new Random();
                        int n = rand.nextInt(9999999);


                        SessionKODU = Integer.toString(n);

                        //////////////////////////////////////////////////////////////////////

                        TextView DkView = (TextView) findViewById(R.id.textViewDakika);
                        DkView.setText("00");


                        TextView SaatView = (TextView) findViewById(R.id.textViewSaat);
                        SaatView.setText("00");

                        TextView SnView = (TextView) findViewById(R.id.textViewSaniye);
                        SnView.setText("00");


                        TextView mesafeView = (TextView) findViewById(R.id.textViewX);
                        mesafeView.setText("0");

                        ////////////////////////////////////////////////////////////////////////

                        GetTextClose(XxX, YyY, SessionKODU);


                        TextView myTextView = (TextView)findViewById(R.id.textXXXView);
                        myTextView.setText("");


                        gpstrackerr.stopUsingGPS();

                        Toast.makeText(getApplicationContext(), "Koordinat Gönderme Kapatıldı", Toast.LENGTH_LONG).show();


                    }
                } catch (Exception ex) {

                }


            }
        });


        Button btnClickMe = (Button) findViewById(R.id.buttonBaslat);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {

                    GetSayac("");



                } catch (Exception ex) {

                }




                try {

                    // CALL GetText method to make post method call


                    gpstrackerr2 = new GPSTracker(SecondActivity.this);


                    if (gpstrackerr2.canGetLocation()) { // gps enabled} // return boolean true/false


                        gpstrackerr2.getLatitude(); // returns latitude
                        gpstrackerr2.getLongitude(); //

                        XxX = Double.toString(gpstrackerr2.latitude);
                        YyY = Double.toString(gpstrackerr2.longitude);




                        Random rand = new Random();
                        int n = rand.nextInt(9999999);


                        SessionKODU = Integer.toString(n);


                        try {

                            GetText(XxX.toString(), YyY.toString(), SessionKODU.toString());

                        } catch (Exception ex) {

                        }




                        SayacAktifDurumda = "1";



                        Toast.makeText(getApplicationContext(), "Koordinatlar Kaydedildi", Toast.LENGTH_LONG).show();
                    }


                } catch (Exception ex) {

                }


            }
        });


    }


    String dakikaSON;
    String saniyeSON;

    int saniyee = 0;
    int dakikaa = 0;
    int saatt = 0;

    public  void  GetSayac(final String DURr) {

        ////////////////////////////////////////////////////////////



        if (DURr != "DUR") {


            zaman = 0;
            handle = new Handler();
            runnable = new Runnable() {

                @Override
                public void run() {

                    zaman++;
                    saniyee++;


                    if (saniyee > 59) {

                        dakikaa++;

                        if (Integer.toString(dakikaa).length() >= 1) {

                            dakikaSON = Integer.toString(dakikaa);

                        } else {

                            dakikaSON = "0" + Integer.toString(dakikaa);

                        }

                        TextView DkView = (TextView) findViewById(R.id.textViewDakika);
                        DkView.setText(dakikaSON.toString());

                        saniyee = 0;
                        zaman = 0;


                        if (dakikaa >= 59) {


                            TextView SaatView = (TextView) findViewById(R.id.textViewSaat);
                            SaatView.setText(Integer.toString(saatt));

                            saatt++;

                        }


                    }
                    handle.postDelayed(runnable, 1000);


                    if (Integer.toString(saniyee).length() >= 1) {

                        saniyeSON = Integer.toString(saniyee).toString();

                    } else {

                        saniyeSON = "0" + Integer.toString(saniyee).toString();

                    }


                    TextView SaniyeView = (TextView) findViewById(R.id.textViewSaniye);
                    SaniyeView.setText(saniyeSON.toString());


                }
            };
            runnable.run();


            ///////////////////////////////////////////////////////////7
        }else {


            handle.removeCallbacks(runnable);


        }

    }



    String XX = "";
    String YY = "";

    String X1 = "";
    String X2 = "";

    String Y1 = "";
    String Y2 = "";

    String data = "";

    public  void  GetText(String XXX, String YYY, String SessKODU)  throws UnsupportedEncodingException
    {
        // Get user

        // Create data variable for sent values to server


        if (XXX != null && YYY != null){


            try
            {


                if(XXX.equals("0.0") == false && YYY.equals("0.0") == false){

                StringTokenizer st = new StringTokenizer(XXX, ".");
                X1 = st.nextToken();
                X2 = st.nextToken();
                XX = X1.toString() + "." + X2.toString().substring(0,4);

                StringTokenizer st2 = new StringTokenizer(YYY, ".");
                Y1 = st2.nextToken();
                Y2 = st2.nextToken();
                YY = Y1.toString() + "." + Y2.toString().substring(0,4);


                data = URLEncoder.encode("KoordinatX", "UTF-8")
                        + "=" + URLEncoder.encode(XX.toString(), "UTF-8");

                data += "&" + URLEncoder.encode("KoordinatY", "UTF-8")
                        + "=" + URLEncoder.encode(YY.toString(), "UTF-8");

                data += "&" + URLEncoder.encode("SessionKODU", "UTF-8")
                        + "=" + URLEncoder.encode(SessKODU.toString(), "UTF-8");


                }
                else {

                    XX = "0,0";
                    YY = "0,0";

                }


                // Send data

                URL url = new URL("http://www.atcnglr.mobi/kosbakalim/index.php");



                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(60000);
                conn.setConnectTimeout(60000);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", String.valueOf(data.length()));
                conn.setDoInput(true);
                conn.setDoOutput(true);


                DataOutputStream out = new DataOutputStream(conn.getOutputStream());

                out.writeBytes(data);

                out.flush();

                out.close();
                // Defined URL  where to send data


                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;

                int sy = 0;

                //Read Server Response
                if ((line = reader.readLine()) != null)
                {

                    // Append server response in string
                    sb.append(line);

                    line = reader.readLine();

                    TextView mySonucTextView = (TextView)findViewById(R.id.textXXXView);
                    mySonucTextView.setText(line);

                    sy++;


                    if(sy >= 1){


                              MesafeOlc(SessKODU.toString());



                   }

                }

                /////////////////////////////////////////////////////////////////


                ///////////////////////////////////////////////////////////////////

            }
            catch(Exception ex)
            {

                ex.printStackTrace();

                TextView mySonucTextViewv = (TextView)findViewById(R.id.textXXXView);
                mySonucTextViewv.setText("Sistem Hatası Oluştu");

            }
            finally
            {

            }

        }else{

            TextView mySonucTextViewv = (TextView)findViewById(R.id.textXXXView);
            mySonucTextViewv.setText("Koordinat Hatası Oluştu");


        }

    }

    public  void  GetTextClose(String XXX, String YYY, String SessKOD)  throws  UnsupportedEncodingException
    {
        // Get user

        // Create data variable for sent values to server


        if (XXX != null && YYY != null){


            try
            {


                StringTokenizer st = new StringTokenizer(XXX, ".");
                String X1 = st.nextToken();
                String X2 = st.nextToken();
                String XX = X1.toString() + "," + X2.toString().substring(0,4);

                StringTokenizer st2 = new StringTokenizer(YYY, ".");
                String Y1 = st2.nextToken();
                String Y2 = st2.nextToken();
                String YY = Y1.toString() + "," + Y2.toString().substring(0,4);



                String data = URLEncoder.encode("KoordinatX", "UTF-8")
                        + "=" + URLEncoder.encode(XX.toString(), "UTF-8");

                data += "&" + URLEncoder.encode("KoordinatY", "UTF-8")
                        + "=" + URLEncoder.encode(YY.toString(), "UTF-8");

                data += "&" + URLEncoder.encode("SessionKODU", "UTF-8")
                        + "=" + URLEncoder.encode(SessionKODU.toString(), "UTF-8");


                // Send data

                URL url = new URL("http://www.atcnglr.mobi/kosbakalim/indexClose.php");



                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(60000);
                conn.setConnectTimeout(60000);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", String.valueOf(data.length()));
                conn.setDoInput(true);
                conn.setDoOutput(true);


                DataOutputStream out = new DataOutputStream(conn.getOutputStream());

                out.writeBytes(data);

                out.flush();

                out.close();
                // Defined URL  where to send data


                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;

                //Read Server Response
                while((line = reader.readLine()) != null)
                {
                    // Append server response in string
                    sb.append(line);

                    line = reader.readLine();

                //    TextView mySonucTextView = (TextView)findViewById(R.id.textXXXView);
                //    mySonucTextView.setText(line);


                }

                /////////////////////////////////////////////////////////////////


                ///////////////////////////////////////////////////////////////////

            }
            catch(Exception ex)
            {

                ex.printStackTrace();



            }
            finally
            {

            }

        }else{

//            TextView mySonucTextViewv = (TextView)findViewById(R.id.textXXXView);
//            mySonucTextViewv.setText("Koordinat Hatası Oluştu");


        }

    }

    BufferedReader readerx = null;

    public void MesafeOlc(String Sesss){


        try
        {



            String data = URLEncoder.encode("SessKOD", "UTF-8")
                    + "=" + URLEncoder.encode(SessionKODU.toString(), "UTF-8");



            // Send data

            URL url = new URL("http://www.atcnglr.mobi/kosbakalim/indexKoordinatTakip.php");



            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(60000);
            conn.setConnectTimeout(60000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(data.length()));
            conn.setDoInput(true);
            conn.setDoOutput(true);


            DataOutputStream out = new DataOutputStream(conn.getOutputStream());

            out.writeBytes(data);

            out.flush();

            out.close();

            // Defined URL  where to send data


            readerx = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sbx = new StringBuilder();
            String linex = null;

            //Read Server Response
            if((linex = readerx.readLine()) != null)
            {
                // Append server response in string
                sbx.append(linex);


                ////////////////////////////////////////////////////////////////////////

                TextView mTextViewv = (TextView)findViewById(R.id.textXXXView);
                mTextViewv.setText(linex.toString());


                //////////////////////////////////////////////////////////////////////////

            }

        }
        catch(Exception ex)
        {

            ex.printStackTrace();

            TextView mySonucTextViewv = (TextView)findViewById(R.id.textXXXView);
            mySonucTextViewv.setText("Veri Hatası oluştu.");

        }
        finally
        {

        }


    }


    public  void  CheckDurum()
    {
        // Get user

        // Create data variable for sent values to server

        try
        {



            String data = URLEncoder.encode("Checke", "UTF-8")
                    + "=" + URLEncoder.encode(SessionKODU.toString(), "UTF-8");



            // Send data

            URL url = new URL("http://www.atcnglr.mobi/kosbakalim/indexCheck.php");



            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(60000);
            conn.setConnectTimeout(60000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(data.length()));
            conn.setDoInput(true);
            conn.setDoOutput(true);


            DataOutputStream out = new DataOutputStream(conn.getOutputStream());

            out.writeBytes(data);

            out.flush();


            // Defined URL  where to send data


            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            //Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line);

                line = reader.readLine();
                line = line.replace(" ","");

                int aa = Integer.parseInt(line.toString());

                if (aa == 1){


                    TextView mySonucTextView = (TextView)findViewById(R.id.textXXXView);
                    mySonucTextView.setText("KONUM BİLDİRME AKTİF");


                    /////////////////

                    // CALL GetText method to make post method call

                    gpss = new GPSTracker(SecondActivity.this);
                    if(gpss.canGetLocation()) { // gps enabled} // return boolean true/false

                        gpss.getLatitude(); // returns latitude
                        gpss.getLongitude(); //

                        String XxX = Double.toString(gpss.latitude);
                        String YyY = Double.toString(gpss.longitude);



                        GetText(XxX, YyY, SessionKODU);

                    }
                }
                if(aa == 0){

                    TextView mySonucTextView = (TextView)findViewById(R.id.textXXXView);
                    mySonucTextView.setText("KONUM BİLDİRME PASİF");


                    ////////////////


                }

            }

            out.close();
        }
        catch(Exception ex)
        {

            ex.printStackTrace();

            TextView mySonucTextViewv = (TextView)findViewById(R.id.textXXXView);
            mySonucTextViewv.setText("Hata oluştu.");

        }
        finally
        {

        }


    }


}
