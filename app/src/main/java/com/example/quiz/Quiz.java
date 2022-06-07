package com.example.quiz;

import java.util.ArrayList;

public class Quiz {

    private ArrayList<Question> questions;
    private long startTime;
    private long endTime;
    private int correctAnswers;
    private int inCorrectAnswers;

    public Quiz(){

    }

    public Quiz(ArrayList<Question> questions, long startTime, long endTime, int correctAnswers,
                int inCorrectAnswers) {
        this.questions = questions;
        this.startTime = -startTime;
        this.endTime = endTime;
        this.correctAnswers = correctAnswers;
        this.inCorrectAnswers = inCorrectAnswers;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getInCorrectAnswers() {
        return inCorrectAnswers;
    }

    public void setInCorrectAnswers(int inCorrectAnswers) {
        this.inCorrectAnswers = inCorrectAnswers;
    }
}
