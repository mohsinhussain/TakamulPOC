package com.tatweer.moh.takamulpoc.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.tatweer.moh.takamulpoc.R;

public class LoginConfirmationActivity extends AppCompatActivity {

    Button visitorButton, exhibitorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Login with Facebook");
        visitorButton = (Button) findViewById(R.id.visitorButton);
        exhibitorButton = (Button) findViewById(R.id.exhibitorButton);

        visitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        exhibitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });


    }

    public void loginUser()
    {
        SharedPreferences preferences = getSharedPreferences("GulfTrafficPref",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("AccessToken", "mohsin");
//        editor.putString("userName", userName);
        editor.commit();

        Intent out = new Intent(this, MainActivity.class);
        startActivity(out);

        finish();
    }

}
