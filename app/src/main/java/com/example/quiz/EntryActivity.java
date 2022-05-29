package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EntryActivity extends AppCompatActivity {


    Button btnExLogin, btnExRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);


        btnExLogin = findViewById(R.id.extraLogin);
        btnExRegister = findViewById(R.id.extraRegister);

        btnExLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EntryActivity.this, LoginScreen.class));
            }
        });

        btnExRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EntryActivity.this, RegisterActivity.class));
            }
        });

    }
}