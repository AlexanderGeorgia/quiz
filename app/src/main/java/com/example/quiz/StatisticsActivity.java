package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    DatabaseReference userRef;

    TextView correctAnswers;
    TextView incorrectAnswers;

    RecyclerView rv_quizzes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        userRef = FirebaseDatabase.getInstance().getReference("Users")
                .child(mAuth.getCurrentUser().getUid());

        correctAnswers = findViewById(R.id.correctAnswers);
        incorrectAnswers = findViewById(R.id.incorrectAnswers);

        MaterialButton btn_log_out = findViewById(R.id.btn_log_out);
        btn_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(
                        StatisticsActivity.this,
                        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build());

                googleSignInClient.signOut()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                startActivity(new Intent(StatisticsActivity.this, LoginScreen.class));
                                finish();
                            }
                        });
            }
        });

        getAllCorrectAnswers();
        getAllIncorrectAnswers();

        rv_quizzes = findViewById(R.id.rv_quizzes);

        Query quizzesRef = FirebaseDatabase.getInstance().getReference("Quizzes")
                .child(mAuth.getCurrentUser().getUid()).orderByChild("startTime").limitToFirst(10);

        quizzesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Quiz> quizArrayList = new ArrayList<>();
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Quiz quiz = dataSnapshot.getValue(Quiz.class);
                        quizArrayList.add(quiz);
                    }
                }

                QuizAdapter quizAdapter = new QuizAdapter(quizArrayList, StatisticsActivity.this);
                rv_quizzes.setAdapter(quizAdapter);
                rv_quizzes.setLayoutManager(new LinearLayoutManager(StatisticsActivity.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void getAllIncorrectAnswers() {
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

    private void getAllCorrectAnswers() {
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