package com.example.myapplication;

import java.io.Serializable;

public class Questions implements Serializable {
    private int text;
    private boolean answer;

    public Questions(int text, boolean answer) {
        this.text = text;
        this.answer = answer;
    }

    public int getText() {
        return text;
    }

    public boolean isAnswer() {
        return answer;
    }
}
