package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button yesBtn;
    Button noBtn;
    int rndA;
    int rndB;
    int result;
    int rightAnswers = 0;
    int wrongAnswers = 0;
    TextView askTextView;
    TextView rightAnswersTextView;
    TextView wrongAnswersTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yesBtn = findViewById(R.id.yesBtn);
        yesBtn.setOnClickListener((view) -> {
            checkAnswer(rndA, rndB, result, true);
        });
        noBtn = findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(rndA, rndB, result, false);

            }
        });
        askTextView = findViewById(R.id.askTextView);
        rightAnswersTextView = findViewById(R.id.rightAnswersTextView);
        wrongAnswersTextView = findViewById(R.id.wrongAnswersTextView);
        question();
    }
    private void checkAnswer(int valA, int valB, int result, boolean answer){
        boolean isAnswer = !((valA+valB == result) ^ answer);
        if (isAnswer){
            // Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
            rightAnswers++;
            rightAnswersTextView.setText("Правильно - "+rightAnswers);
        } else {
            // Toast.makeText(MainActivity.this, "Неправильно!", Toast.LENGTH_SHORT).show();
            wrongAnswers++;
            wrongAnswersTextView.setText("Неправильно - "+wrongAnswers);
        }
        question();
    }
    private void question() {
        Random rnd = new Random();
        rndA = rnd.nextInt(10)+1;
        rnd = new Random();
        rndB = rnd.nextInt(10)+1;
        result = rnd.nextInt(3)+1;
        result = rndA + rndB + result -1;
        askTextView.setText(rndA+" + "+rndB+" = "+result);
    }
}