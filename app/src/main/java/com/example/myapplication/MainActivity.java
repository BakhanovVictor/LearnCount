package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button yesBtn;
    Button noBtn;
    Questions[] questions = {
            new Questions(R.string.question1, true),
            new Questions(R.string.question2, true),
            new Questions(R.string.question3, false),
            new Questions(R.string.question4, false),
            new Questions(R.string.question5, true)
    };
    boolean[] userAnswers = new boolean[5];
    int questionIndex = 0;
    TextView askTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yesBtn = findViewById(R.id.yesBtn);
        yesBtn.setOnClickListener((view) -> {
            checkAnswer(questions[questionIndex].isAnswer());
        });
        noBtn = findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(!questions[questionIndex].isAnswer());

            }
        });
        askTextView = findViewById(R.id.askTextView);
        askTextView.setText(questions[questionIndex].getText());
    }
    private void checkAnswer(boolean isAnswer){
        userAnswers[questionIndex] = isAnswer;
        if (isAnswer){
            Toast.makeText(MainActivity.this, "Правильно!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Неправильно!", Toast.LENGTH_SHORT).show();
        }
        if((questionIndex+1) == questions.length) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("questions", questions);
            intent.putExtra("userAnswers", userAnswers);
            startActivity(intent);
            questionIndex = 0;
        } else {
            questionIndex++;
        };
        askTextView.setText(questions[questionIndex].getText());
    }
}