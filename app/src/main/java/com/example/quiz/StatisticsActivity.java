package com.example.quiz;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatisticsActivity extends AppCompatActivity {

    DatabaseReference userRef;

    TextView correctAnswers;
    TextView incorrectAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        userRef = FirebaseDatabase.getInstance().getReference("Users")
                .child(mAuth.getCurrentUser().getUid());

        correctAnswers = findViewById(R.id.correctAnswers);
        incorrectAnswers = findViewById(R.id.incorrectAnswers);

        getCorrectAnswers();
        getIncorrectAnswers();
    }

    private void getIncorrectAnswers() {
        userRef.child("incorrectAnswers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int getIncorrectAnswers = snapshot.getValue(int.class);
                    incorrectAnswers.setText("Incorrect Answers for all time : " + getIncorrectAnswers);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getCorrectAnswers() {
        userRef.child("correctAnswers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int getCorrectAnswers = snapshot.getValue(int.class);
                    correctAnswers.setText("Correct Answers for all time : " + getCorrectAnswers);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}