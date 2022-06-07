package com.example.quiz;

import androidx.annotation.NonNull;

import java.util.Locale;

public enum QuestionType {
    JAVA,
    PHP,
    HTML,
    ANDROID;

    @NonNull
    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
