package com.chromsicle.jscore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



//left off by trying to figure out how to get the score and double status back from the second activity
//https://www.youtube.com/watch?v=AD5qt7xoUU8 might help
//is this something that needs to be done with shared preferences instead?
//why can't I send data back and forth the way I send it to Answers in the first place?


/**
 * right now the program uses the onclick in the xml but this should be changed to use setOnClickListener
 * like in the miwok app
 * also, learn how those todo things work (freaky, everything turned yellow after writing todo)
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public int score;
    public boolean doubleValue = false;

    Button clue1;
    Button clue2;
    Button clue3;
    Button clue4;
    Button clue5;

    int clueAmount;


    //constant for the passed ints, best practice is to use package name so interacting with other apps doesn't lead to issues
    public static final String EXTRA_CLUE = "com.chromsicle.application.jscore.EXTRA_CLUE";
    public static final String EXTRA_SCORE = "com.chromsicle.application.jscore.EXTRA_SCORE";
    //this doesn't seem like the right way to deal with this since it'll never change in the Answer activity so research a better way
    public static final String EXTRA_ROUND = "com.chromsicle.application.jscore.EXTRA_ROUND";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the buttons
        clue1 = findViewById(R.id.clue1);
        clue2 = findViewById(R.id.clue2);
        clue3 = findViewById(R.id.clue3);
        clue4 = findViewById(R.id.clue4);
        clue5 = findViewById(R.id.clue5);

        //clicks sent to the onClick method
        clue1.setOnClickListener(this);
        clue2.setOnClickListener(this);
        clue3.setOnClickListener(this);
        clue4.setOnClickListener(this);
        clue5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //which button was clicked?
        switch (view.getId()) {
            case R.id.clue1:
                //set the chosen clue amount
                if(doubleValue) {
                    clueAmount = 400;
                } else {
                    clueAmount = 200;
                }
                openAnswerActivity();
                break;
            case R.id.clue2:
                if(doubleValue) {
                    clueAmount = 800;
                } else {
                    clueAmount = 400;
                }
                openAnswerActivity();
                break;
            case R.id.clue3:
                if(doubleValue) {
                    clueAmount = 1200;
                } else {
                    clueAmount = 600;
                }
                openAnswerActivity();
                break;
            case R.id.clue4:
                if(doubleValue) {
                    clueAmount = 1600;
                } else {
                    clueAmount = 800;
                }
                openAnswerActivity();
                break;
            case R.id.clue5:
                if(doubleValue) {
                    clueAmount = 2000;
                } else {
                    clueAmount = 1000;
                }
                openAnswerActivity();
                break;
        }

    }

    public void openAnswerActivity() {
        Intent intent = new Intent(this, Answer.class);
        //open the Answer activity with the selected clueAmount and current score
        //should these and the ones coming from the Answer activity be passed as a bundle?
        intent.putExtra(EXTRA_CLUE, clueAmount);
        intent.putExtra(EXTRA_SCORE, score);
        intent.putExtra(EXTRA_ROUND, doubleValue);
        startActivityForResult(intent, 1);
    }

    public void doubleRound(View view) {
        //set round to 2, update clue TextViews
        doubleValue = true;

        clue1.setText("$400");
        clue2.setText("$800");
        clue3.setText("$1200");
        clue4.setText("$1600");
        clue5.setText("$2000");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("EXTRA_SCORE", 0);
                TextView scoreTextView = findViewById(R.id.winnings);
                scoreTextView.setText("$" + result);
            }
        }
    }
}
