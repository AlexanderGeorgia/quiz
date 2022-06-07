package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    Animation anim_fade;

    ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splash = findViewById(R.id.splash);

        anim_fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);

        splash.startAnimation(anim_fade);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if (firebaseUser == null){
                    i = new Intent(SplashScreen.this, EntryActivity.class);
                } else {
                    i = new Intent(SplashScreen.this, MainActivity.class);
                }
                startActivity(i);
                finish();

            }
        }, 3000);

    }
}