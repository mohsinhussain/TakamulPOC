package com.tatweer.moh.takamulpoc.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tatweer.moh.takamulpoc.R;

public class InvestActivity extends AppCompatActivity {

    ImageView titleImageView;
    TextView title;
    LinearLayout investValue;
    RadioButton radioButton, radioButton1, radioButton2, radioButton3;
    EditText investAmountEditText;
    Button investButton;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Invest");

        titleImageView = (ImageView) findViewById(R.id.titleImageView);
        title =  (TextView) findViewById(R.id.title);
        investAmountEditText = (EditText) findViewById(R.id.investAmountEditText);
        investValue  = (LinearLayout) findViewById(R.id.investValue);
        radioButton =  (RadioButton) findViewById(R.id.radioButton);
        radioButton1 =  (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 =  (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 =  (RadioButton) findViewById(R.id.radioButton3);
        investButton = (Button) findViewById(R.id.investButton);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton1.setSelected(false);
                radioButton2.setSelected(false);
                radioButton3.setSelected(false);
                investValue.setVisibility(View.VISIBLE);
                investAmountEditText.setText("100");
                Toast.makeText(InvestActivity.this, "Radio Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                investValue.setVisibility(View.VISIBLE);
                investAmountEditText.setText("500");
                Toast.makeText(InvestActivity.this, "Radio 1 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton1.setChecked(false);
                radioButton.setChecked(false);
                radioButton3.setChecked(false);
                investValue.setVisibility(View.VISIBLE);
                Toast.makeText(InvestActivity.this, "Radio 2 Clicked", Toast.LENGTH_SHORT).show();
                investAmountEditText.setText("1000");
            }
        });


        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton.setChecked(false);
                investValue.setVisibility(View.VISIBLE);
                Toast.makeText(InvestActivity.this, "Radio 3 Clicked", Toast.LENGTH_SHORT).show();
                investAmountEditText.setText("15000");
            }
        });


        title.setText(getIntent().getExtras().getString("title"));
        Glide.with(InvestActivity.this).load(getIntent().getExtras().getInt("image")).into(titleImageView);

        investButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InvestActivity.this, PaymentActivity.class);
                i.putExtras(getIntent());
                i.putExtra("amount", investAmountEditText.getText().toString());
                startActivity(i);
            }
        });

    }

}
