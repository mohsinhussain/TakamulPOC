package com.tatweer.moh.takamulpoc.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.tatweer.moh.takamulpoc.R;

public class LoginActivity extends AppCompatActivity {

    Button skipButton;
    Button fbLoginButton, signUpButton, emailLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Login");

        skipButton = (Button) findViewById(R.id.skipButton);
        fbLoginButton = (Button) findViewById(R.id.fbLoginButton);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        emailLoginButton = (Button) findViewById(R.id.emailLoginButton);
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

        emailLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, LoginDetailActivity.class));
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show dialog
                // custom dialog
                final Dialog dialog = new Dialog(LoginActivity.this);
                dialog.setContentView(R.layout.dialog_signup);


                Button visitorButton = (Button) dialog.findViewById(R.id.visitorButton);
                Button exhibitorButton = (Button) dialog.findViewById(R.id.exhibitorButton);
                // if button is clicked, close the custom dialog

                exhibitorButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(LoginActivity.this, RegisterVisitor.class).putExtra("exhibitor", false));
                        dialog.dismiss();
                    }
                });

                visitorButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(LoginActivity.this, RegisterVisitor.class).putExtra("visitor", true));
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }

    public void loginWithFacebook(){
        Intent out = new Intent(this, LoginConfirmationActivity.class);
        startActivity(out);

//        finish();
    }


    public void skipLogin(){
        Intent out = new Intent(this, MainActivity.class);
        startActivity(out);

//        finish();
    }



}
