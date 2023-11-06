package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultTextView = findViewById(R.id.resultTextView);
        Questions[] questions = (Questions[]) getIntent().getSerializableExtra("questions");
        boolean[] userAnswers = getIntent().getBooleanArrayExtra("userAnswers");
        StringBuilder resultUserAnswer = new StringBuilder();
        for (int i = 0; i < userAnswers.length; i++) {
            boolean userAnswer = userAnswers[i];
            if(userAnswer){
                resultUserAnswer.append(getString(questions[i].getText())+" - Правильно!\n");
            } else {
                resultUserAnswer.append(getString(questions[i].getText())+" - Неправильно!\n");
            }
            
        }
        resultTextView.setText(resultUserAnswer);
    }
}