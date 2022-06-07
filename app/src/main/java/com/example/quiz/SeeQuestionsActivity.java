package com.example.quiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SeeQuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_questions);

        RecyclerView rv_questions = findViewById(R.id.rv_questions);

        ArrayList<Question> questionArrayList = getIntent().getParcelableArrayListExtra("questions");

        QuestionAdapter questionAdapter = new QuestionAdapter(questionArrayList);
        rv_questions.setAdapter(questionAdapter);
        rv_questions.setLayoutManager(new LinearLayoutManager(this));
    }
}