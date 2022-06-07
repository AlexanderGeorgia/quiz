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
        Question questionJava1 = new Question("java", "public static void main(String[] args) { int sum = 0; for (int i = 1; i <= 3; sum += i++) ; System.out.println(sum); {", "compile error", "3", "6", "5", "6", "questionJava1");
        Question questionJava2 = new Question("java", "public static void main(String[] args) {  String test = \"Hello\"; String test2 = \"Hello\"; System.out.println(test==test2); }", "null", "false", "true", "Hello", "true", "questionJava2");
        Question questionJava3 = new Question("java", "public static void main(String[] args) {   int[] array = new int[3];  System.out.println(array[2]); }", "0", "2", "1", "null", "0", "questionJava3");
        Question questionJava4 = new Question("java", "What access modifier must be used to make the variable visible everywhere?", "public", "private", "protected", "default(package visible)", "public", "questionJava4");
        Question questionJava5 = new Question("java", "public static void main(String[] args) {  int a = 5; System.out.println(a + 2); }", "unhandled exception", "52", "7", "5+2", "7", "questionJava5");
        Question questionJava6 = new Question("java", "public static void main(String[] args) { int[] array = new int[]{11, 5, -4, 8, 4, 7}; for (int i = 0; i < array.length; i += 2) {  System.out.print(i+\" \"); } }", "error", "0 2 4", "11 -4 4", "11", "0 2 4", "questionJava6");
        Question questionJava7 = new Question("java", "public static void main(String[] args) {  String s = \"Hello\";  System.out.println(s + 5 + 4);  }", "Hello 54 ", "Hello 9", "Hello54", "Hello 5 4", "Hello54", "questionJava7");
        Question questionJava8 = new Question("java", "How do you insert COMMENTS in Java code?", "// comment", "/* comment", "# comment", "non of the above", "// comment", "questionJava8");
        Question questionJava9 = new Question("java", " Which data type is used to create a variable that should store text?", " String ", "myString", "string", "Txt", "dgfdg", "questionJava9");
        Question questionJava10 = new Question("java", "How do you create a variable with the numeric value 5?", "x = 5", "float x = 5", "int x = 5", "num x = 5", "dgfdg", "questionJava10");

        Question questionPhp1 = new Question("php", "What does PHP stand for?", "Personal Hypertext Processor", "Private Home Page", "PHP: Hypertext Processor", "dgffg", "PHP: Hypertext Processor", "questionPhp1");
        Question questionPhp2 = new Question("php", "All variables in PHP start with which symbol?", "!", "$", "#", "&", "$", "questionPhp2");
        Question questionPhp3 = new Question("php", "What is the correct way to end a PHP statement?", ";", ":", ".", "</php>", ";", "questionPhp3");
        Question questionPhp4 = new Question("php", "The PHP syntax is most similar to:", "VBScript", "JavaScript", "Perl and c", "none of the above", "Perl and c", "questionPhp4");
        Question questionPhp5 = new Question("php", "What is the correct way to create a function in PHP?", "create myFunction()", "function myFunction()", "new myFunction()", "newFunction myFunction()", "function myFunction()", "questionPhp5");
        Question questionPhp6 = new Question("php", "PHP allows you to send emails directly from a script", "true", "false", "sometimes", "only with special version", "true", "questionPhp6");
        Question questionPhp7 = new Question("php", "What is the correct way to add 1 to the $count variable?", "count++;", "$count++;", "$count=+1;", "++count", "$count++;", "questionPhp7");
        Question questionPhp8 = new Question("php", "PHP can be run on Microsoft Windows IIS(Internet Information Server):", "true", "false", "sometimes", "only if to pay", "true", "questionPhp8");
        Question questionPhp9 = new Question("php", "How do you create a cookie in PHP?", "setcookie()", "makecookie()", "createcookie", "putcookie()", "setcookie()", "questionPhp9");
        Question questionPhp10 = new Question("php", "Which operator is used to check if two values are equal and of same data type?", "=", "==", "===", "!=", "===", "questionPhp10");

        Question questionAndroid1 = new Question("android", "sorry i had", "no ", "time", "to finish", "really", "really", "questionAndroid1");
        Question questionAndroid2 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid2");
        Question questionAndroid3 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid3");
        Question questionAndroid4 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid4");
        Question questionAndroid5 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid5");
        Question questionAndroid6 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid6");
        Question questionAndroid7 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid7");
        Question questionAndroid8 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid8");
        Question questionAndroid9 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid9");
        Question questionAndroid10 = new Question("android", "sorry i had", "no", "time", "to finish", "really", "really", "questionAndroid10");

        Question questionHtml1 = new Question("html", "What does HTML stand for?", "Hyperlinks and Text Markup Language", "Hyper Text Markup Language", "Home Tool Markup Language", "none of the above", "Hyper Text Markup Language", "questionHtml1");
        Question questionHtml2 = new Question("html", "Who is making the Web standards?", "Mozilla", "The World Wide Web Consortium", "Microsoft", "Google", "The World Wide Web Consortium", "questionHtml2");
        Question questionHtml3 = new Question("html", "Choose the correct HTML element for the largest heading:", "<h6>", "<head>", "<heading>", "<h1>", "<h1>", "questionHtml3");
        Question questionHtml4 = new Question("html", "What is the correct HTML element for inserting a line break?", "<br>", "<ib>", "<break>", "none of the above", "<br>", "questionHtml4");
        Question questionHtml5 = new Question("html", "Choose the correct HTML element to define important text", "<i>", "<important>", "<b>", "<strong>", "<strong>", "questionHtml5");
        Question questionHtml6 = new Question("html", "Choose the correct HTML element to define emphasized text", "<em>", "<i>", "<italic>", "none of above", "<em>", "questionHtml6");
        Question questionHtml7 = new Question("html", "Which character is used to indicate an end tag?", "^", "/", "*", "<", "/", "questionHtml7");
        Question questionHtml8 = new Question("html", "How can you make a numbered list?", "<list>", "<ol>", "<ul>", "<dl>", "<ol>", "questionHtml8");
        Question questionHtml9 = new Question("html", "Which HTML element defines the title of a document?", "<head>", "<title>", "<meta>", "none of the above", "<title>", "questionHtml9");
        Question questionHtml10 = new Question("html", "Which HTML attribute specifies an alternate text for an image, if the image cannot be displayed?", "src", "alt", "title", "longdesc", "alt", "questionHtml10");

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
