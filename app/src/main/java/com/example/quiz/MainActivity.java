package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.startService);
        Button stop = findViewById(R.id.stopService);

        start.setOnClickListener(view -> startService(new Intent(MainActivity.this, MyService.class)));


        stop.setOnClickListener(view -> stopService(new Intent(MainActivity.this, MyService.class)));


        final LinearLayout java = findViewById(R.id.javaLayout);
        final LinearLayout php = findViewById(R.id.phpLayout);
        final LinearLayout html = findViewById(R.id.htmlLayout);
        final LinearLayout android = findViewById(R.id.androidLayout);

        final Button startBtn = findViewById(R.id.startQuizbtn);
        final Button createQuestionbtn = findViewById(R.id.createQuestionbtn);

        createQuestionbtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CreateQuestionActivity.class)));

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicName = "java";

                java.setBackgroundResource(R.drawable.round_back_white_stroke10);

                php.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);


            }
        });

        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicName = "php";

                php.setBackgroundResource(R.drawable.round_back_white_stroke10);

                java.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);

            }
        });

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicName = "html";

                html.setBackgroundResource(R.drawable.round_back_white_stroke10);

                php.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
                android.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicName = "android";

                android.setBackgroundResource(R.drawable.round_back_white_stroke10);

                php.setBackgroundResource(R.drawable.round_back_white10);
                html.setBackgroundResource(R.drawable.round_back_white10);
                java.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedTopicName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please select the Topic", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }
            }
        });

    }

}