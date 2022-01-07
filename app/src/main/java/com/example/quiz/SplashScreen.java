package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, EntryActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);

    }
}