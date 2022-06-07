package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateQuestionActivity extends AppCompatActivity {
    EditText et_quest_text, et_quest_answer1, et_quest_answer2, et_quest_answer3,
            et_quest_answer4, et_correct_answer_num;
    FloatingActionButton fab;
    DatabaseReference qustRef;
    Spinner spinner;
    String[] question_types = {QuestionType.JAVA.toString(), QuestionType.PHP.toString(),
            QuestionType.HTML.toString(), QuestionType.ANDROID.toString()};
    ArrayAdapter<String> spinner_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);

        alexInit();

        spinner_adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, question_types);

        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinner_adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qustRef = FirebaseDatabase.getInstance().getReference("Questions").push();

                int correct_answer_num = Integer.parseInt(et_correct_answer_num.getText().toString());
                String correct_answer = "";

                switch (correct_answer_num) {
                    case 1:
                        correct_answer = et_quest_answer1.getText().toString();
                        break;
                    case 2:
                        correct_answer = et_quest_answer2.getText().toString();
                        break;
                    case 3:
                        correct_answer = et_quest_answer3.getText().toString();
                        break;
                    case 4:
                        correct_answer = et_quest_answer4.getText().toString();
                        break;
                }

                Question q = new Question(String.valueOf(spinner.getSelectedItem()),
                        et_quest_text.getText().toString(),
                        et_quest_answer1.getText().toString(),
                        et_quest_answer2.getText().toString(),
                        et_quest_answer3.getText().toString(),
                        et_quest_answer4.getText().toString(),
                        correct_answer,
                        qustRef.getKey());

                qustRef.setValue(q);

                startActivity(new Intent(CreateQuestionActivity.this, MainActivity.class));
            }
        });

    }

    private void alexInit() {
        et_quest_text = findViewById(R.id.et_add_qst_text);
        et_quest_answer1 = findViewById(R.id.et_add_qst_answr1);
        et_quest_answer2 = findViewById(R.id.et_add_qst_answr2);
        et_quest_answer3 = findViewById(R.id.et_add_qst_answr3);
        et_quest_answer4 = findViewById(R.id.et_add_qst_answr4);
        et_correct_answer_num = findViewById(R.id.et_add_qst_correct_num);
        spinner =  findViewById(R.id.spinner_add_question_type);
        fab = findViewById(R.id.fab);
    }
}