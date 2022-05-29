package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionsBank {

    private static final DatabaseReference questionsRef = FirebaseDatabase.getInstance().getReference("Questions");


    public static void addDefaultQuestions(){
        Question questionJava1 = new Question("java", "hello", "why", "hhaa", "kkoo", "zzaa", "zzaa", "questionJava1");
        Question questionJava2 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava2");
        Question questionJava3 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava3");
        Question questionJava4 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava4");
        Question questionJava5 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava5");
        Question questionJava6 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava6");
        Question questionJava7 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava7");
        Question questionJava8 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava8");
        Question questionJava9 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava9");
        Question questionJava10 = new Question("java", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionJava10");

        Question questionPhp1 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp1");
        Question questionPhp2 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp2");
        Question questionPhp3 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp3");
        Question questionPhp4 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp4");
        Question questionPhp5 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp5");
        Question questionPhp6 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp6");
        Question questionPhp7 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp7");
        Question questionPhp8 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp8");
        Question questionPhp9 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp9");
        Question questionPhp10 = new Question("php", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionPhp10");

        Question questionAndroid1 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid1");
        Question questionAndroid2 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid2");
        Question questionAndroid3 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid3");
        Question questionAndroid4 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid4");
        Question questionAndroid5 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid5");
        Question questionAndroid6 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid6");
        Question questionAndroid7 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid7");
        Question questionAndroid8 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid8");
        Question questionAndroid9 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid9");
        Question questionAndroid10 = new Question("android", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionAndroid10");

        Question questionHtml1 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml1");
        Question questionHtml2 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml2");
        Question questionHtml3 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml3");
        Question questionHtml4 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml4");
        Question questionHtml5 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml5");
        Question questionHtml6 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml6");
        Question questionHtml7 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml7");
        Question questionHtml8 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml8");
        Question questionHtml9 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml9");
        Question questionHtml10 = new Question("html", "fgfdg", "fdgd", "dgfgd", "dgfg", "dgffg", "dgfdg", "questionHtml10");

        questionsRef.child(questionJava1.getQuestion_key()).setValue(questionJava1);
        questionsRef.child(questionJava2.getQuestion_key()).setValue(questionJava2);
        questionsRef.child(questionJava3.getQuestion_key()).setValue(questionJava3);
        questionsRef.child(questionJava4.getQuestion_key()).setValue(questionJava4);
        questionsRef.child(questionJava5.getQuestion_key()).setValue(questionJava5);
        questionsRef.child(questionJava6.getQuestion_key()).setValue(questionJava6);
        questionsRef.child(questionJava7.getQuestion_key()).setValue(questionJava7);
        questionsRef.child(questionJava8.getQuestion_key()).setValue(questionJava8);
        questionsRef.child(questionJava9.getQuestion_key()).setValue(questionJava9);
        questionsRef.child(questionJava10.getQuestion_key()).setValue(questionJava10);

        questionsRef.child(questionPhp1.getQuestion_key()).setValue(questionPhp1);
        questionsRef.child(questionPhp2.getQuestion_key()).setValue(questionPhp2);
        questionsRef.child(questionPhp3.getQuestion_key()).setValue(questionPhp3);
        questionsRef.child(questionPhp4.getQuestion_key()).setValue(questionPhp4);
        questionsRef.child(questionPhp5.getQuestion_key()).setValue(questionPhp5);
        questionsRef.child(questionPhp6.getQuestion_key()).setValue(questionPhp6);
        questionsRef.child(questionPhp7.getQuestion_key()).setValue(questionPhp7);
        questionsRef.child(questionPhp8.getQuestion_key()).setValue(questionPhp8);
        questionsRef.child(questionPhp9.getQuestion_key()).setValue(questionPhp9);
        questionsRef.child(questionPhp10.getQuestion_key()).setValue(questionPhp10);

        questionsRef.child(questionAndroid1.getQuestion_key()).setValue(questionAndroid1);
        questionsRef.child(questionAndroid2.getQuestion_key()).setValue(questionAndroid2);
        questionsRef.child(questionAndroid3.getQuestion_key()).setValue(questionAndroid3);
        questionsRef.child(questionAndroid4.getQuestion_key()).setValue(questionAndroid4);
        questionsRef.child(questionAndroid5.getQuestion_key()).setValue(questionAndroid5);
        questionsRef.child(questionAndroid6.getQuestion_key()).setValue(questionAndroid6);
        questionsRef.child(questionAndroid7.getQuestion_key()).setValue(questionAndroid7);
        questionsRef.child(questionAndroid8.getQuestion_key()).setValue(questionAndroid8);
        questionsRef.child(questionAndroid9.getQuestion_key()).setValue(questionAndroid9);
        questionsRef.child(questionAndroid10.getQuestion_key()).setValue(questionAndroid10);

        questionsRef.child(questionHtml1.getQuestion_key()).setValue(questionHtml1);
        questionsRef.child(questionHtml2.getQuestion_key()).setValue(questionHtml2);
        questionsRef.child(questionHtml3.getQuestion_key()).setValue(questionHtml3);
        questionsRef.child(questionHtml4.getQuestion_key()).setValue(questionHtml4);
        questionsRef.child(questionHtml5.getQuestion_key()).setValue(questionHtml5);
        questionsRef.child(questionHtml6.getQuestion_key()).setValue(questionHtml6);
        questionsRef.child(questionHtml7.getQuestion_key()).setValue(questionHtml7);
        questionsRef.child(questionHtml8.getQuestion_key()).setValue(questionHtml8);
        questionsRef.child(questionHtml9.getQuestion_key()).setValue(questionHtml9);
        questionsRef.child(questionHtml10.getQuestion_key()).setValue(questionHtml10);

    }

    @NonNull
    public static LiveData<ArrayList<Question>> getQuestions(@NonNull String selectedTopicName) {

        MutableLiveData<ArrayList<Question>> questionsList = new MutableLiveData<>();

        questionsRef.orderByChild("question_type").equalTo(selectedTopicName)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            ArrayList<Question> questions = new ArrayList<>();
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                Question q = dataSnapshot.getValue(Question.class);
                                questions.add(q);
                            }

                            Collections.shuffle(questions);

                            ArrayList<Question> finalQuestions = new ArrayList<>();

                            for (int i = 0; i < 10 && i < questions.size(); i++) {
                                finalQuestions.add(questions.get(i));
                            }

                            questionsList.setValue(finalQuestions);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
        });

        return questionsList;
    }
}
