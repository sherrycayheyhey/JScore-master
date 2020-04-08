package com.chromsicle.jscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScore(int money){
        TextView scoreView = findViewById(R.id.winnings);
        scoreView.setText("$" + money);
    }

    public void addPoints(View v) {
        v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
        v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        switch(v.getId()) {
            case R.id.twoHundred:
                if(doubleVaule) {
                    score += 400;
                }
                else {
                    score += 200;
                }
                displayScore(score);
                break;
            case R.id.fourHundred:
                if(doubleVaule) {
                    score += 800;
                }
                else {
                    score += 400;
                }
                displayScore(score);
                break;
            case R.id.sixHundred:
                if(doubleVaule) {
                    score += 1200;
                }
                else {
                    score += 600;
                }
                displayScore(score);
                break;
            case R.id.eightHundred:
                if(doubleVaule) {
                    score += 1600;
                }
                else {
                    score += 800;
                }
                displayScore(score);
                break;
            case R.id.oneThousand:
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

    public void doubleRound (View view) {
        view.playSoundEffect(android.view.SoundEffectConstants.CLICK);
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);

        doubleVaule = true;

        Button firstButton = findViewById(R.id.twoHundred);
        firstButton.setText("$400");

        Button secondButton = findViewById(R.id.fourHundred);
        secondButton.setText("$800");

        Button thirdButton = findViewById(R.id.sixHundred);
        thirdButton.setText("$1200");

        Button fourthButton = findViewById(R.id.eightHundred);
        fourthButton.setText("$1600");

        Button fifthButton = findViewById(R.id.oneThousand);
        fifthButton.setText("$2000");

        Button negFirstButton = findViewById(R.id.negFirst);
        negFirstButton.setText("-$400");

        Button negSecondButton = findViewById(R.id.negSecond);
        negSecondButton.setText("-$800");

        Button negThirdButton = findViewById(R.id.negThird);
        negThirdButton.setText("-$1200");

        Button negFourthButton = findViewById(R.id.negFourth);
        negFourthButton.setText("-$1600");

        Button negFifthButton = findViewById(R.id.negFifth);
        negFifthButton.setText("-$2000");
    }

}
