package com.nitant.bingogame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class howToActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);

    textView = (TextView)findViewById(R.id.textView);

    textView.setText("\n \n \n 1.Click on PLAY button to enter the game. \n \n \n 2.Click on 'SHUFFLE' button to get random numbers between 1 to 25 on bingo card. \n \n \n 3. Once done selecting random numbers Click on the 'START' button to play. \n \n \n 4. If all the numbers are cancelled row wise,column wise and diagonally click on 'SHOUT' button to shout BINGOOO...");

    }
}
