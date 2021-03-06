package com.tatweer.moh.takamulpoc.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.tatweer.moh.takamulpoc.R;

public class SplashActivityGulfTraffic extends AppCompatActivity implements Animation.AnimationListener {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;
    ImageView title, strip1, strip2, strip3;
    Animation titleAnimation, stripAnimation, stripAnimation3;
    boolean finish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_gulftraffic);

        // load the animation
        titleAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.left_to_right);
        stripAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.strip_anim);
        stripAnimation3 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.top_to_bottom_strip3);
        titleAnimation.setAnimationListener(this);
        stripAnimation.setAnimationListener(this);
        stripAnimation3.setAnimationListener(this);

        title = (ImageView) findViewById(R.id.mainTitle);
        strip1 = (ImageView) findViewById(R.id.strip1);
        strip2 = (ImageView) findViewById(R.id.strip2);
        strip3 = (ImageView) findViewById(R.id.strip3);
        // start the animation
        title.startAnimation(stripAnimation);
        strip1.startAnimation(titleAnimation);
        strip2.startAnimation(titleAnimation);
        strip3.startAnimation(titleAnimation);

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

        SharedPreferences preferences = getSharedPreferences("GulfTrafficPref", MODE_PRIVATE);
        if (preferences.contains("AccessToken")) {
//            Globals.getGlobal().AccessToken = preferences.getString("AccessToken", null);
//            Globals.getGlobal().userName = preferences.getString("userName", null);
//            //reset retro
//            Globals.ResetRetrofit();
            Intent out = new Intent(this, MainActivity.class);
            startActivity(out);

            finish();
        } else {
            Intent out = new Intent(this, LoginActivity.class);
            startActivity(out);
            finish();
        }
//        Intent out = new Intent(this, MainActivity.class);
//        startActivity(out);
//
//        finish();
    }

    @Override
    public void onAnimationStart(Animation animation) {



    }

    @Override
    public void onAnimationEnd(Animation animation) {

//        if (animation == titleAnimation) {
//            strip3.startAnimation(stripAnimation3);
//
//        }
//
//        if (animation == stripAnimation3) {
//            strip1.startAnimation(stripAnimation);
//            strip2.startAnimation(stripAnimation);
//        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
