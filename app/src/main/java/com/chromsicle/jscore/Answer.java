package com.chromsicle.jscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Answer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent intent = getIntent();
        int number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

        TextView clueAmountTextView = findViewById(R.id.clueAmount);
        clueAmountTextView.setText("$" + number);

        Button backButton = findViewById(R.id.backButton);

    }

    public void backButtonClicked(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
