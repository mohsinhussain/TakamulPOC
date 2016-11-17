package com.tatweer.moh.takamulpoc.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.tatweer.moh.takamulpoc.R;

public class LoginActivity extends AppCompatActivity {

    Button skipButton;
    Button fbLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Login");

        skipButton = (Button) findViewById(R.id.skipButton);
        fbLoginButton = (Button) findViewById(R.id.fbLoginButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skipLogin();
            }
        });

        fbLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithFacebook();
            }
        });

    }

    public void loginWithFacebook(){
        Intent out = new Intent(this, LoginConfirmationActivity.class);
        startActivity(out);

        finish();
    }


    public void skipLogin(){
        Intent out = new Intent(this, MainActivity.class);
        startActivity(out);

        finish();
    }



}
