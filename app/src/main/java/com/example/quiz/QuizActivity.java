package com.example.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView tv_questions;
    private TextView question;
    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int totalTimeInMins = 1;

    private int seconds = 0;

    private ArrayList<Question> questions_list = new ArrayList<>();

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.topicName);

        tv_questions = findViewById(R.id.questions);
        question = findViewById(R.id.tv_question);


        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextBtn = findViewById(R.id.nextBtn);


        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopicName);

        QuestionsBank.getQuestions(getSelectedTopicName).observe(this, questions -> startQuiz(questions));

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option1.getText().toString();

                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questions_list.get(currentQuestionPosition).setAnswer(selectedOptionByUser);
                }

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option2.getText().toString();

                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questions_list.get(currentQuestionPosition).setAnswer(selectedOptionByUser);
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option3.getText().toString();

                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questions_list.get(currentQuestionPosition).setAnswer(selectedOptionByUser);
                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option4.getText().toString();

                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questions_list.get(currentQuestionPosition).setAnswer(selectedOptionByUser);
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this,
                            "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    changeNextQuestion();
                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    private void startQuiz(ArrayList<Question> questions) {
        questions_list = questions;

        startTimer(timer);

        tv_questions.setText((currentQuestionPosition + 1) + "/" + questions_list.size());
        question.setText(questions_list.get(0).getQuestion());
        option1.setText(questions_list.get(0).getOption1());
        option2.setText(questions_list.get(0).getOption2());
        option3.setText(questions_list.get(0).getOption3());
        option4.setText(questions_list.get(0).getOption4());
    }

    private void changeNextQuestion(){

        currentQuestionPosition++;

        if ((currentQuestionPosition+1) == questions_list.size()){
            nextBtn.setText("Submit Quiz");
        }

        if (currentQuestionPosition < questions_list.size()){

            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            tv_questions.setText((currentQuestionPosition + 1) + "/" + questions_list.size());
            question.setText(questions_list.get(currentQuestionPosition).getQuestion());
            option1.setText(questions_list.get(currentQuestionPosition).getOption1());
            option2.setText(questions_list.get(currentQuestionPosition).getOption2());
            option3.setText(questions_list.get(currentQuestionPosition).getOption3());
            option4.setText(questions_list.get(currentQuestionPosition).getOption4());

        }
        else{
            Intent intent = new Intent(QuizActivity.this, QuizResult.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getInCorrectAnswers());
            startActivity(intent);

            finish();
        }

    }

    private void startTimer(TextView timerTextView){

        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds == 0){
                    totalTimeInMins--;
                    seconds = 59;

                }
                else if (seconds == 0 && totalTimeInMins == 0){

                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this,"Time over", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuizResult.class);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("incorrect", getInCorrectAnswers());
                    startActivity(intent);

                    finish();

                }
                else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1){
                            finalMinutes = "0"+finalMinutes;
                        }

                        if (finalSeconds.length() == 1){
                            finalSeconds = "0"+finalSeconds;
                        }

                        timerTextView.setText(finalMinutes +":"+finalSeconds);
                    }
                });

            }
        },1000, 1000);

    }

    private int getCorrectAnswers(){

        int correctAnswers = 0;

        for (int i = 0; i < questions_list.size(); i++){

            final String getUserSelectedAnswer = questions_list.get(i).getAnswer();
            final String getCorrectAnswer = questions_list.get(i).getCorrectAnswer();

            if(getUserSelectedAnswer.equals(getCorrectAnswer)){
                correctAnswers++;
            }
        }

        return correctAnswers;

    }

    private int getInCorrectAnswers(){

        int correctAnswers = 0;

        for (int i = 0; i< questions_list.size(); i++){


            final String getUserSelectedAnswer = questions_list.get(i).getAnswer();
            final String getCorrectAnswer = questions_list.get(i).getCorrectAnswer();

            if(!getUserSelectedAnswer.equals(getCorrectAnswer)){
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    @Override
    public void onBackPressed() {

        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }

    private void revealAnswer(){

        final String correctAnswer = questions_list.get(currentQuestionPosition).getCorrectAnswer();

        if(option1.getText().toString().equals(correctAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if (option2.getText().toString().equals(correctAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if (option3.getText().toString().equals(correctAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if (option4.getText().toString().equals(correctAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
}