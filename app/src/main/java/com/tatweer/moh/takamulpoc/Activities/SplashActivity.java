package com.tatweer.moh.takamulpoc.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.tatweer.moh.takamulpoc.R;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                openMainActivity();
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void openMainActivity()
    {
        Intent out = new Intent(this, MainActivity.class);
        startActivity(out);

        finish();
    }
}
