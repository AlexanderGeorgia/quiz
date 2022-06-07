package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QuizResult extends AppCompatActivity {

    DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        userRef = FirebaseDatabase.getInstance().getReference("Users")
                .child(mAuth.getCurrentUser().getUid());

        final AppCompatButton startNewBtn = findViewById(R.id.startNewQuizBtn);
        final AppCompatButton seeResultsBtn = findViewById(R.id.seeResultsBtn);
        final TextView correctAnswer = findViewById(R.id.correctAnswers);
        final TextView incorrectAnswers = findViewById(R.id.incorrectAnswers);

        final int getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        final int getIncorrectAnswers = getIntent().getIntExtra("incorrect", 0);

        uploadCorrectAnswers(getCorrectAnswers);
        uploadIncorrectAnswers(getIncorrectAnswers);

        correctAnswer.setText(String.valueOf(getCorrectAnswers));
        incorrectAnswers.setText(String.valueOf(getIncorrectAnswers));

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent ( QuizResult.this, MainActivity.class));
                finish();
            }
        });

        seeResultsBtn.setOnClickListener(view -> startActivity(new Intent(QuizResult.this, StatisticsActivity.class)));

    }

    private void uploadIncorrectAnswers(int getIncorrectAnswers) {

        userRef.child("incorrectAnswers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int incorrectAnswers = 0;
                if (snapshot.exists()){
                    incorrectAnswers = snapshot.getValue(int.class);
                }

                userRef.child("incorrectAnswers").setValue(getIncorrectAnswers + incorrectAnswers)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void uploadCorrectAnswers(int getCorrectAnswers) {

        userRef.child("correctAnswers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int correctAnswers = 0;
                if (snapshot.exists()){
                    correctAnswers = snapshot.getValue(int.class);
                }

                userRef.child("correctAnswers").setValue(getCorrectAnswers + correctAnswers)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResult.this, MainActivity.class));
        finish();
    }
}