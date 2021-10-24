package com.nomi.pucitcgpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private int SPLASH_TIME = 3000;//which is equal to 1.5 sec
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        setTitle("main activity");

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(mySuperIntent);
                finish();
            }
        }, SPLASH_TIME);
    }

}