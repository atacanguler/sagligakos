package com.nvmvzv.kosbakalim.kosbakalim;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.BufferedReader;

public class VeriActivity  extends AppCompatActivity {



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
        setContentView(R.layout.activity_veri);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        final String HarKalori = SecondActivity.HarcananKalorii.toString();

        TextView ttxtKalori = (TextView) findViewById(R.id.textViewX);
        ttxtKalori.setText(SecondActivity.HarcananKalorii.toString());




        Button btnClickMeNextt = (Button) findViewById(R.id.buttonAktar);
        btnClickMeNextt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {

                    //////////////////////////////////////////////////////////////////////////////////




                } catch (Exception ex) {

                }


                EditText EttxtKilo = (EditText) findViewById(R.id.editViewY);
                String KKilo = EttxtKilo.getText().toString();


                EditText EttxtYas = (EditText) findViewById(R.id.editViewZZ);
                String EYas = EttxtYas.getText().toString();


                EditText EttxtBoy = (EditText) findViewById(R.id.editViewYY);
                String KBoy = EttxtBoy.getText().toString();

                RadioGroup rG= (RadioGroup) findViewById(R.id.radioSex);
                int selectedId = rG.getCheckedRadioButtonId();
                RadioButton rB= (RadioButton) findViewById(selectedId);

                String Cinsiyet = rB.getText().toString();

                ////////////////////////
                //Cinsiyet;
               // KKilo;
               // KBoy;
               // HarKalori;


                Double ALmanGerekenKalori = 0.0;

                if(Cinsiyet.equals("Kadın") == true) {

                    ALmanGerekenKalori = 665 + ( 9.6 * Double.parseDouble(KKilo.toString()) ) + ( 1.7 * Double.parseDouble(KBoy.toString()) ) - ( 4.7 * Double.parseDouble(EYas.toString()) );


                }

                if(Cinsiyet.equals("Erkek") == true) {

                    ALmanGerekenKalori = 66 + ( 9.6 * Double.parseDouble(KKilo.toString()) ) + ( 1.7 * Double.parseDouble(KBoy.toString()) ) - ( 4.7 *  Double.parseDouble(EYas.toString()) );


                }

                Double TOPLAMkalori = Double.parseDouble(ALmanGerekenKalori.toString()) + Double.parseDouble(HarKalori.toString());



                TextView txtSonuc = (TextView) findViewById(R.id.textViewSonuc);
                txtSonuc.setText(TOPLAMkalori.toString());

            }
        });





    }

}