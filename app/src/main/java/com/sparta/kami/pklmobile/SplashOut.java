package com.sparta.kami.pklmobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SplashOut extends AppCompatActivity {

    private final int splashScreen = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_out);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                finish();
                System.exit(0);
            }
        },splashScreen);
    }

}
