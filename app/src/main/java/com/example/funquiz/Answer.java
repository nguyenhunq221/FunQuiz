package com.example.funquiz;

public class Answer {
    public Answer(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    private String content;
    private boolean isCorrect;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
