package com.example.quiz;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.ArrayList;

public class QuestionsBank {
    DatabaseReference questionRef;

    private static ArrayList<QuestionsList> javaQuestions() {


        final ArrayList<QuestionsList> questionsLists = new ArrayList<>();

        //create object of QuestionList class and pass a question along with option and answer
        final QuestionsList question1 = new QuestionsList("qwerty","1","2",
                "3", "4","1","");
        final QuestionsList question2 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question3 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question4 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question5 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question6 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question7 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question8 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question9 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question10 = new QuestionsList("qwerty","1","2", "3", "4","1","");


        // add all questions to ArrayList<QuestionList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;


    }

    public void addQuestionToDatabase(String email){
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        User user = new User(email, uid, "");

        userRef = FirebaseDatabase.getInstance().getReference("Users").push();
        user.setKey( userRef.getKey());

        userRef.setValue(user);
    }

    private static ArrayList<QuestionsList> phpQuestions() {

        final ArrayList<QuestionsList> questionsLists = new ArrayList<>();

        //create object of QuestionList class and pass a question along with option and answer
        final QuestionsList question1 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question2 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question3 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question4 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question5 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question6 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question7 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question8 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question9 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question10 = new QuestionsList("qwerty","1","2", "3", "4","1","");



        // add all questions to ArrayList<QuestionList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;
    }

    private static ArrayList<QuestionsList> htmlQuestions() {

        final ArrayList<QuestionsList> questionsLists = new ArrayList<>();

        //create object of QuestionList class and pass a question along with option and answer
        final QuestionsList question1 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question2 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question3 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question4 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question5 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question6 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question7 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question8 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question9 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question10 = new QuestionsList("qwerty","1","2", "3", "4","1","");



        // add all questions to ArrayList<QuestionList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;
    }

    private static ArrayList<QuestionsList> androidQuestions() {

        final ArrayList<QuestionsList> questionsLists = new ArrayList<>();

        //create object of QuestionList class and pass a question along with option and answer
        final QuestionsList question1 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question2 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question3 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question4 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question5 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question6 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question7 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question8 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question9 = new QuestionsList("qwerty","1","2", "3", "4","1","");
        final QuestionsList question10 = new QuestionsList("qwerty","1","2", "3", "4","1","");



        // add all questions to ArrayList<QuestionList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;
    }

    public static ArrayList<QuestionsList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "java":
                return javaQuestions();
            case "php":
                return phpQuestions();
            case "html":
                return htmlQuestions();
            case "android":
                return androidQuestions();
            default:
                return null;
        }
    }
}
