package com.chromsicle.jscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Answer extends AppCompatActivity {

    int clueAmount;
    int score;
    boolean doubleRound;

    public static final String EXTRA_SCORE = "com.chromsicle.application.jscore.EXTRA_SCORE";
    public static final String EXTRA_ROUND = "com.chromsicle.application.jscore.EXTRA_ROUND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        //get the clue amount, score, and round from MainActivity
        Intent intent = getIntent();
        clueAmount = intent.getIntExtra(MainActivity.EXTRA_CLUE, 0);
        score = intent.getIntExtra(MainActivity.EXTRA_SCORE, 0);
        doubleRound = intent.getBooleanExtra(MainActivity.EXTRA_ROUND, false);

        //set the $ TextView to be the clue amount that was selected
        TextView clueAmountTextView = findViewById(R.id.clueAmount);
        clueAmountTextView.setText("$" + clueAmount);

        //get the back, correct, incorrect, and pass buttons
        Button backButton = findViewById(R.id.backButton);
        Button correctButton = findViewById(R.id.correctButton);
        Button incorrectButton = findViewById(R.id.incorrectButton);
        Button passButton = findViewById(R.id.passButton);

    }

    //when back button pressed, go to MainActivity with the current game state and score
    public void backButtonClicked(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //when correct button pressed, add clueAmount to the score then send back to MainActivity
    public void correctButtonClicked(View v) {
        score += clueAmount;
        openMainActivity();
    }

    //when incorrect button pressed, deduct clueAmount to the score then send back to MainActivity
    public void incorrectButtonClicked (View v) {
        score -= clueAmount;
        openMainActivity();
    }

    //when passed button pressed, send back to MainActivity
    public void passButtonClicked(View v) {
        openMainActivity();
    }

    public void openMainActivity() {
        Intent intent = new Intent();
        //Intent intent = new Intent(this, MainActivity.class);
        //open MainActivity with the score and round
        intent.putExtra(EXTRA_SCORE, score);
        intent.putExtra(EXTRA_ROUND, doubleRound);
        setResult(RESULT_OK, intent);
        finish();
    }
}
