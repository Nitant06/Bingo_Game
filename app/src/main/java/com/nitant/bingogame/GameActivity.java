package com.nitant.bingogame;

import android.Manifest;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;


public class GameActivity extends AppCompatActivity{


    Button generate,start,shout;

    final Button buttons[] = new Button[25];

    TextView textValue1,textValue2,textValue3,textValue4,textValue5;

    TextView textC1,textC2,textC3,textC4,textC5,textD2,textD1;



    //Bluetooth code


    static int r1,r2,r3,r4,r5;

    static int c1,c2,c3,c4,c5;

    static int d1,d2;

    static int winner;







    public void Restart(View view){

        generate.setEnabled(false);

        Intent i = new Intent(GameActivity.this,MainActivity.class);

        startActivity(i);



        r1=0;
        r2=0;
        r3=0;
        r4=0;
        r5=0;

        c1=0;
        c2=0;
        c3=0;
        c4=0;
        c5=0;

        winner=0;

        d1=0;
        d2=0;


        textValue1.setText("");
        textValue2.setText("");
        textValue3.setText("");
        textValue4.setText("");
        textValue5.setText("");



        textC1.setText("");
        textC2.setText("");
        textC3.setText("");
        textC4.setText("");
        textC5.setText("");

    }




    public  void Result(int winner) {

    }

    //Rows Logic

    //r1 logic b1,b2,b3,b4,b5=r1
    public void getValue1(int r1){

        if(r1==5){

            textValue1 = (TextView) findViewById(R.id.B_row);
            textValue1.setText("B");
        }


    }



    public void getValue2(int r2){


        if(r2==5){

            textValue2 = (TextView) findViewById(R.id.I_row);
            textValue2.setText("I");
        }

    }



    public void getValue3(int r3){


        if(r3==5){

            textValue3 = (TextView) findViewById(R.id.N_row);
            textValue3.setText("N");
        }

    }


    public  void getValue4(int r4){


        if(r4==5){

            textValue4 = (TextView) findViewById(R.id.G_row);
            textValue4.setText("G");
        }

    }


    public void getValue5(int r5){


        if(r5==5) {

            textValue5 = (TextView) findViewById(R.id.O_row);
            textValue5.setText("O");

        }
    }


    //Columns Logic


    // c1 logic b1,b6,b11,b21 = c1
    public void getC1(int c1){


        if(c1==5){

            textC1 = (TextView)findViewById(R.id.B_column);
            textC1.setText("B");
        }

    }


    //c2 logic b2,b7,b12,b17,b22 = c2
    public void getC2(int c2){


        if(c2==5){

            textC2 = (TextView)findViewById(R.id.I_column);
            textC2.setText("I");
        }

    }


    //c3 logic b3,b8,b13,b18,b23 = c3
    public void getC3(int c3){


        if(c3==5){

            textC3 = (TextView)findViewById(R.id.N_column);
            textC3.setText("N");
        }


    }

    //c4 logic b4,b9,b14,b19,b24 = c4
    public void getC4(int c4){


        if(c4==5){

            textC4 = (TextView)findViewById(R.id.G_column);
            textC4.setText("G");
        }

    }

    //c5 logic b5,b10,b15,b20,b25 = c5

    public void getC5(int c5){


        if(c5==5){

            textC5 = (TextView)findViewById(R.id.O_column);
            textC5.setText("O");
        }

    }

    //Diagonal D1 logic b1,b7,b13,b19,b25 = d1
    public void getD1(int d1){

        if(d1==5){

            textD2 = (TextView)findViewById(R.id.D2Text);
            textD2.setText("\u2198");
        }

    }

    //Diagonal D2 logic b5,b9,b13,b17,b21 = d2
    public void getD2(int d2){


        if(d2==5){

            textD1 = (TextView)findViewById(R.id.D1Text);
            textD1.setText("\u2197");
        }

    }


    public void callGenerate(){

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(generate.isPressed()) {

                    buttons[0].setEnabled(true);
                    buttons[1].setEnabled(true);
                    buttons[2].setEnabled(true);
                    buttons[3].setEnabled(true);
                    buttons[4].setEnabled(true);
                    buttons[5].setEnabled(true);
                    buttons[6].setEnabled(true);
                    buttons[7].setEnabled(true);
                    buttons[8].setEnabled(true);
                    buttons[9].setEnabled(true);
                    buttons[10].setEnabled(true);
                    buttons[11].setEnabled(true);
                    buttons[12].setEnabled(true);
                    buttons[13].setEnabled(true);
                    buttons[14].setEnabled(true);
                    buttons[15].setEnabled(true);
                    buttons[16].setEnabled(true);
                    buttons[17].setEnabled(true);
                    buttons[18].setEnabled(true);
                    buttons[19].setEnabled(true);
                    buttons[20].setEnabled(true);
                    buttons[21].setEnabled(true);
                    buttons[22].setEnabled(true);
                    buttons[23].setEnabled(true);
                    buttons[24].setEnabled(true);

                }


                int x;
                int n = 0;
                int i, j;
                int counter = 24;

                int[][] bingo;
                bingo = new int[5][5];

                Integer[] arr = new Integer[25];

                for (x = 0; x < arr.length; x++) {

                    arr[x] = n + 1;
                    n++;

                }

                Collections.shuffle(Arrays.asList(arr));


                do {
                    x = 0;

                    for (i = 0; i < 5; i++) {

                        for (j = 0; j < 5; j++) {


                            bingo[i][j] = arr[x];
                            x++;

                        }

                    }
                } while (x < 25);
                try {
                    while (counter < 25) {

                        for (i = 0; i < 5; i++) {

                            for (j = 0; j < 5; j++) {


                                buttons[counter].setText(Integer.toString(bingo[i][j]));


                                counter--;

                            }


                        }

                    }
                } catch (Exception e) {

                    System.out.println(e);
                }


            }




        });






            buttons[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    r1++;
                    c1++;
                    d1++;

                    winner++;
                    Result(winner);

                    getValue1(r1);
                    getC1(c1);
                    getD1(d1);

                    buttons[0].setEnabled(false);
                    buttons[0].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[0].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r1++;
                    c2++;

                    winner++;
                    Result(winner);

                    getValue1(r1);
                    getC2(c2);

                    buttons[1].setEnabled(false);
                    buttons[1].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[1].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r1++;
                    c3++;

                    winner++;
                    Result(winner);

                    getValue1(r1);
                    getC3(c3);

                    buttons[2].setEnabled(false);
                    buttons[2].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[2].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r1++;
                    c4++;

                    winner++;
                    Result(winner);

                    getValue1(r1);
                    getC4(c4);

                    buttons[3].setEnabled(false);
                    buttons[3].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[3].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r1++;
                    c5++;
                    d2++;

                    winner++;
                    Result(winner);

                    getValue1(r1);
                    getC5(c5);
                    getD2(d2);

                    buttons[4].setEnabled(false);
                    buttons[4].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[4].setBackgroundColor(Color.WHITE);

                }
            });

            buttons[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r2++;
                    c1++;

                    winner++;
                    Result(winner);

                    getValue2(r2);
                    getC1(c1);

                    buttons[5].setEnabled(false);
                    buttons[5].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[5].setBackgroundColor(Color.WHITE);

                }
            });


            buttons[6].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r2++;
                    c2++;
                    d1++;

                    winner++;
                    Result(winner);

                    getValue2(r2);
                    getC2(c2);
                    getD1(d1);

                    buttons[6].setEnabled(false);
                    buttons[6].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[6].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r2++;
                    c3++;

                    winner++;
                    Result(winner);

                    getValue2(r2);
                    getC3(c3);

                    buttons[7].setEnabled(false);
                    buttons[7].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[7].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[8].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r2++;
                    c4++;
                    d2++;


                    winner++;
                    Result(winner);

                    getValue2(r2);
                    getC4(c4);
                    getD2(d2);

                    buttons[8].setEnabled(false);
                    buttons[8].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[8].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[9].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r2++;
                    c5++;

                    winner++;
                    Result(winner);

                    getValue2(r2);
                    getC5(c5);

                    buttons[9].setEnabled(false);
                    buttons[9].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[9].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[10].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r3++;
                    c1++;

                    winner++;
                    Result(winner);

                    getValue3(r3);
                    getC1(c1);

                    buttons[10].setEnabled(false);
                    buttons[10].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[10].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[11].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r3++;
                    c2++;

                    winner++;
                    Result(winner);

                    getValue3(r3);
                    getC2(c2);

                    buttons[11].setEnabled(false);
                    buttons[11].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[11].setBackgroundColor(Color.WHITE);
                }
            });

            buttons[12].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r3++;
                    c3++;
                    d1++;
                    d2++;

                    winner++;
                    Result(winner);

                    getValue3(r3);
                    getC3(c3);
                    getD1(d1);
                    getD2(d2);

                    buttons[12].setEnabled(false);
                    buttons[12].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[12].setBackgroundColor(Color.WHITE);
                }
            });

            buttons[13].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r3++;
                    c4++;

                    winner++;
                    Result(winner);

                    getValue3(r3);
                    getC4(c4);

                    buttons[13].setEnabled(false);
                    buttons[13].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[13].setBackgroundColor(Color.WHITE);
                }
            });

            buttons[14].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r3++;
                    c5++;

                    winner++;
                    Result(winner);

                    getValue3(r3);
                    getC5(c5);

                    buttons[14].setEnabled(false);
                    buttons[14].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[14].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[15].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r4++;
                    c1++;

                    winner++;
                    Result(winner);

                    getValue4(r4);
                    getC1(c1);

                    buttons[15].setEnabled(false);
                    buttons[15].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[15].setBackgroundColor(Color.WHITE);
                }
            });

            buttons[16].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r4++;
                    c2++;
                    d2++;

                    winner++;
                    Result(winner);

                    getValue4(r4);
                    getC2(c2);
                    getD2(d2);

                    buttons[16].setEnabled(false);
                    buttons[16].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[16].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[17].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r4++;
                    c3++;

                    winner++;
                    Result(winner);

                    getValue4(r4);
                    getC3(c3);

                    buttons[17].setEnabled(false);
                    buttons[17].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[17].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[18].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r4++;
                    c4++;
                    d1++;

                    winner++;
                    Result(winner);

                    getValue4(r4);
                    getC4(c4);
                    getD1(d1);

                    buttons[18].setEnabled(false);
                    buttons[18].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[18].setBackgroundColor(Color.WHITE);
                }
            });

            buttons[19].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r4++;
                    c5++;

                    winner++;
                    Result(winner);

                    getValue4(r4);
                    getC5(c5);

                    buttons[19].setEnabled(false);
                    buttons[19].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[19].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[20].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r5++;
                    c1++;
                    d2++;

                    winner++;
                    Result(winner);

                    getValue5(r5);
                    getC1(c1);
                    getD2(d2);

                    buttons[20].setEnabled(false);
                    buttons[20].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[20].setBackgroundColor(Color.WHITE);
                }
            });


            buttons[21].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r5++;
                    c2++;

                    winner++;
                    Result(winner);

                    getValue5(r5);
                    getC2(c2);

                    buttons[21].setEnabled(false);
                    buttons[21].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[21].setBackgroundColor(Color.WHITE);
                }
            });

            buttons[22].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r5++;
                    c3++;

                    winner++;
                    Result(winner);

                    getValue5(r5);
                    getC3(c3);

                    buttons[22].setEnabled(false);
                    buttons[22].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[22].setBackgroundColor(Color.WHITE);
                }
            });

            buttons[23].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r5++;
                    c4++;

                    winner++;
                    Result(winner);

                    getValue5(r5);
                    getC4(c4);

                    buttons[23].setEnabled(false);
                    buttons[23].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[23].setBackgroundColor(Color.WHITE);
                }
            });

            buttons[24].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    r5++;
                    c5++;
                    d1++;

                    winner++;
                    Result(winner);

                    getValue5(r5);
                    getC5(c5);
                    getD1(d1);

                    buttons[24].setEnabled(false);
                    buttons[24].setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttons[24].setBackgroundColor(Color.WHITE);
                }
            });








    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this,"Sorry you cannot go back once entered.Press restart.",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        generate = (Button) findViewById(R.id.generatebtn);
        start = (Button) findViewById(R.id.Startbtn);
        shout =(Button)findViewById(R.id.BingoSound);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.sample);

        shout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.start();
            }
        });


        buttons[0] = (Button) findViewById(R.id.b1);
        buttons[1] = (Button) findViewById(R.id.b2);
        buttons[2] = (Button) findViewById(R.id.b3);
        buttons[3] = (Button) findViewById(R.id.b4);
        buttons[4] = (Button) findViewById(R.id.b5);
        buttons[5] = (Button) findViewById(R.id.b6);
        buttons[6] = (Button) findViewById(R.id.b7);
        buttons[7] = (Button) findViewById(R.id.b8);
        buttons[8] = (Button) findViewById(R.id.b9);
        buttons[9] = (Button) findViewById(R.id.b10);
        buttons[10] = (Button) findViewById(R.id.b11);
        buttons[11] = (Button) findViewById(R.id.b12);
        buttons[12] = (Button) findViewById(R.id.b13);
        buttons[13] = (Button) findViewById(R.id.b14);
        buttons[14] = (Button) findViewById(R.id.b15);
        buttons[15] = (Button) findViewById(R.id.b16);
        buttons[16] = (Button) findViewById(R.id.b17);
        buttons[17] = (Button) findViewById(R.id.b18);
        buttons[18] = (Button) findViewById(R.id.b19);
        buttons[19] = (Button) findViewById(R.id.b20);
        buttons[20] = (Button) findViewById(R.id.b21);
        buttons[21] = (Button) findViewById(R.id.b22);
        buttons[22] = (Button) findViewById(R.id.b23);
        buttons[23] = (Button) findViewById(R.id.b24);
        buttons[24] = (Button) findViewById(R.id.b25);


        buttons[0].setEnabled(false);
        buttons[1].setEnabled(false);
        buttons[2].setEnabled(false);
        buttons[3].setEnabled(false);
        buttons[4].setEnabled(false);
        buttons[5].setEnabled(false);
        buttons[6].setEnabled(false);
        buttons[7].setEnabled(false);
        buttons[8].setEnabled(false);
        buttons[9].setEnabled(false);
        buttons[10].setEnabled(false);
        buttons[11].setEnabled(false);
        buttons[12].setEnabled(false);
        buttons[13].setEnabled(false);
        buttons[14].setEnabled(false);
        buttons[15].setEnabled(false);
        buttons[16].setEnabled(false);
        buttons[17].setEnabled(false);
        buttons[18].setEnabled(false);
        buttons[19].setEnabled(false);
        buttons[20].setEnabled(false);
        buttons[21].setEnabled(false);
        buttons[22].setEnabled(false);
        buttons[23].setEnabled(false);
        buttons[24].setEnabled(false);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                generate.setEnabled(false);
            }
        });



        callGenerate();





    }







}





