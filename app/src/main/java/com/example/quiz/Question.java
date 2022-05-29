package com.example.quiz;

public class Question {
    private String question_type;
    private String question, option1, option2, option3, option4, correctAnswer, answer;
    private String question_key;

    public Question() {}

    public Question(String question, String option1, String option2, String option3,
                    String option4, String answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public Question(String question, String option1, String option2, String option3, String option4, String correctAnswer, String question_key) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.question_key = question_key;
    }

    public Question(String question_type, String question, String option1,
                    String option2, String option3, String option4,
                    String correctAnswer, String question_key) {
        this.question_type = question_type;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.question_key = question_key;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion_key() {
        return question_key;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public void setQuestion_key(String question_key) {
        this.question_key = question_key;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
