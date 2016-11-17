package com.tatweer.moh.takamulpoc.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.tatweer.moh.takamulpoc.R;

public class SplashActivityTakammul extends AppCompatActivity implements Animation.AnimationListener {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;
    Animation titleAnimation, verticalFlipAnimation;
    boolean finish = false;
    ImageView lampGray, lampColored, logoImageView, logoStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_takammul);

        // load the animation
        titleAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.left_to_right);
        verticalFlipAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.vertical_flip);

        titleAnimation.setAnimationListener(this);
        verticalFlipAnimation.setAnimationListener(this);

        lampGray = (ImageView) findViewById(R.id.lampGray);
        lampColored = (ImageView) findViewById(R.id.lampColored);
        logoImageView = (ImageView) findViewById(R.id.logo);
        logoStrip = (ImageView) findViewById(R.id.logoStrip);



        lampColored.startAnimation(titleAnimation);
        logoImageView.startAnimation(titleAnimation);
        logoStrip.startAnimation(titleAnimation);


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

    @Override
    public void onAnimationStart(Animation animation) {



    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (animation == titleAnimation) {
            logoStrip.startAnimation(verticalFlipAnimation);

        }
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
