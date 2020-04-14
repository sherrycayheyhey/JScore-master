package com.chromsicle.jscore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static int score = 0;
    public static boolean doubleVaule = false;
    int correct200;
    int incorrect200;
    int correct400;
    int incorrect400;
    int correct600;
    int incorrect600;
    int correct800;
    int incorrect800;
    int correct1000;
    int incorrect1000;
    int correctDouble400;
    int incorrectDouble400;

    int round;

    int clueAmount;


    //constant for the passed int, best practice is to use package name so interacting with other apps doesn't lead to issues
    public static final String EXTRA_NUMBER = "com.chromsicle.application,jscore.EXTRA_NUMBER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the starting round
        round = 1;

        Button clue1 = findViewById(R.id.clue1);
        Button clue2 = findViewById(R.id.clue2);
        Button clue3 = findViewById(R.id.clue3);
        Button clue4 = findViewById(R.id.clue4);
        Button clue5 = findViewById(R.id.clue5);

        //clicks sent to the onClick method
        clue1.setOnClickListener(this);
        clue2.setOnClickListener(this);
        clue3.setOnClickListener(this);
        clue4.setOnClickListener(this);
        clue5.setOnClickListener(this);
    }

    public void displayScore(int money){
        TextView scoreView = findViewById(R.id.winnings);
        scoreView.setText("$" + money);
    }


    public void addPoints(View v) {
        v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
        v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        switch(v.getId()) {
            case R.id.clue1:
                if(doubleVaule) {
                    score += 400;
                }
                else {
                    score += 200;
                }
                displayScore(score);
                break;
            case R.id.clue2:
                if(doubleVaule) {
                    score += 800;
                }
                else {
                    score += 400;
                }
                displayScore(score);
                break;
            case R.id.clue3:
                if(doubleVaule) {
                    score += 1200;
                }
                else {
                    score += 600;
                }
                displayScore(score);
                break;
            case R.id.clue4:
                if(doubleVaule) {
                    score += 1600;
                }
                else {
                    score += 800;
                }
                displayScore(score);
                break;
            case R.id.clue5:
                if(doubleVaule) {
                    score += 2000;
                }
                else {
                    score += 1000;
                }
                displayScore(score);
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
    }

    /*
    public void deductPoints(View v) {
        v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
        v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        switch(v.getId()) {
            case R.id.negFirst:
                if(doubleVaule) {
                    score -= 400;
                }
                else {
                    score -= 200;
                }
                displayScore(score);
                break;
            case R.id.negSecond:
                if(doubleVaule) {
                    score -= 800;
                }
                else {
                    score -= 400;
                }
                displayScore(score);
                break;
            case R.id.negThird:
                if(doubleVaule) {
                    score -= 1200;
                }
                else {
                    score -= 600;
                }
                displayScore(score);
                break;
            case R.id.negFourth:
                if(doubleVaule) {
                    score -= 1600;
                }
                else {
                    score -= 800;
                }
                displayScore(score);
                break;
            case R.id.negFifth:
                if(doubleVaule) {
                    score -= 2000;
                }
                else {
                    score -= 1000;
                }
                displayScore(score);
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
    }

     */

    public void doubleRound (View view) {
        view.playSoundEffect(android.view.SoundEffectConstants.CLICK);
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);

        doubleVaule = true;

        /*firstButton = findViewById(R.id.clue1);
        firstButton.setText("$400");

        secondButton = findViewById(R.id.clue2);
        secondButton.setText("$800");

        thirdButton = findViewById(R.id.clue3);
        thirdButton.setText("$1200");

        fourthButton = findViewById(R.id.clue4);
        fourthButton.setText("$1600");

        fifthButton = findViewById(R.id.clue5);
        fifthButton.setText("$2000");
*/
        /*Button negFirstButton = findViewById(R.id.negFirst);
        negFirstButton.setText("-$400");

        Button negSecondButton = findViewById(R.id.negSecond);
        negSecondButton.setText("-$800");

        Button negThirdButton = findViewById(R.id.negThird);
        negThirdButton.setText("-$1200");

        Button negFourthButton = findViewById(R.id.negFourth);
        negFourthButton.setText("-$1600");

        Button negFifthButton = findViewById(R.id.negFifth);
        negFifthButton.setText("-$2000");*/
    }

    @Override
    public void onClick(View view) {
        //which button was clicked?
        switch (view.getId()) {
            case R.id.clue1:
                //what I want to happen (send the $ to the next activity and open it so that the amount will be added or subtracted form the total)
                if(round == 1) {
                    clueAmount = 200;
                } else if (round == 2) {
                    clueAmount = 400;
                }
                //convert the amount to a string
                //String clueAmountString = String.valueOf(clueAmount);
                openAnswerActivity();
                break;
            case R.id.clue2:
                if(round == 1) {
                    clueAmount = 400;
                } else if (round == 2) {
                    clueAmount = 800;
                }
                openAnswerActivity();
                break;
            case R.id.clue3:
                if(round == 1) {
                    clueAmount = 600;
                } else if (round == 2) {
                    clueAmount = 1200;
                }
                openAnswerActivity();
                break;
            case R.id.clue4:
                if(round == 1) {
                    clueAmount = 800;
                } else if (round == 2) {
                    clueAmount = 1600;
                }
                openAnswerActivity();
                break;
            case R.id.clue5:
                if(round == 1) {
                    clueAmount = 1000;
                } else if (round == 2) {
                    clueAmount = 2000;
                }
                openAnswerActivity();
                break;
        }

    }

    public void openAnswerActivity() {
        Intent intent = new Intent(this, Answer.class);
        intent.putExtra(EXTRA_NUMBER, clueAmount);
        startActivity(intent);
    }
}
