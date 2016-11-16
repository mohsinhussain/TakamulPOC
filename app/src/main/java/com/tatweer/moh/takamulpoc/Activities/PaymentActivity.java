package com.tatweer.moh.takamulpoc.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tatweer.moh.takamulpoc.R;

public class PaymentActivity extends AppCompatActivity {
    ImageView titleImageView;
    TextView title, amountTextView;
    Button investButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Payment");

        titleImageView = (ImageView) findViewById(R.id.titleImageView);
        title =  (TextView) findViewById(R.id.title);
        amountTextView =  (TextView) findViewById(R.id.amountTextView);
        investButton = (Button) findViewById(R.id.investButton);

        amountTextView.setText(getIntent().getExtras().getString("amount")+" AED");

        investButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this,
                        "Congratulations! You successfully are an investor of this project now.", Toast.LENGTH_LONG).show();
                Intent startMain = new Intent(PaymentActivity.this, MainActivity.class);
//                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startMain);

                finish();

            }
        });

        title.setText(getIntent().getExtras().getString("title"));
        Glide.with(PaymentActivity.this).load(getIntent().getExtras().getInt("image")).into(titleImageView);
    }

}
