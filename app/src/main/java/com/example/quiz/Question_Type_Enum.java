package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Question_Type_Enum {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            Java,
            Php,
            Html,
            Android,
            Sql
    })
    @interface Question_Type {
    }

    String Java = "java";
    String Php = "php";
    String Html = "html";
    String Android = "android";
    String Sql = "sql";

    /**
     * Called to notify the listener of the type of the question.
     *
     * @param Question_Type
     */
    void onQuestion_Type(@NonNull @Question_Type String Question_Type);
}
