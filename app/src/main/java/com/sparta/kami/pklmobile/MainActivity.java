package com.sparta.kami.pklmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class MainActivity extends Activity {

    private final int splashScreen = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent main = new Intent(MainActivity.this,Login.class);
                MainActivity.this.startActivity(main);
                MainActivity.this.finish();
            }
        },splashScreen);
    }
}
