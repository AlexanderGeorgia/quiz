package com.example.quiz;

import android.app.Application;

public class QuizApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        QuestionsBank.addDefaultQuestions();
    }
}
