package com.tatweer.moh.takamulpoc.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tatweer.moh.takamulpoc.R;

public class DetailActivity extends AppCompatActivity {

    public TextView title, count, category, funded, backers, daysToGo, alreadyFunded;
    public ImageView thumbnail, like, share;
    public ContentLoadingProgressBar progressBar;
    public View mRootView;
    public Button investButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getIntent().getExtras().getString("title"));


        title = (TextView) findViewById(R.id.title);
        category = (TextView) findViewById(R.id.category);
        count = (TextView) findViewById(R.id.count);
        funded = (TextView) findViewById(R.id.funded);
        backers = (TextView) findViewById(R.id.backers);
        alreadyFunded = (TextView)findViewById(R.id.alreadyFunded);
        daysToGo = (TextView) findViewById(R.id.daysToGo);
        thumbnail = (ImageView)findViewById(R.id.thumbnail);
        like = (ImageView) findViewById(R.id.likeImageView);
        share = (ImageView) findViewById(R.id.shareImageView);
        progressBar = (ContentLoadingProgressBar) findViewById(R.id.progress);

        investButton = (Button) findViewById(R.id.investButton);

        investButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailActivity.this, InvestActivity.class);
                i.putExtras(getIntent());
                startActivity(i);
            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        title.setText(getIntent().getExtras().getString("title"));
        count.setText(getIntent().getExtras().getString("detail"));
        backers.setText(Integer.toString(getIntent().getExtras().getInt("backers")));
        funded.setText(Integer.toString(getIntent().getExtras().getInt("progress")));
        daysToGo.setText(Integer.toString(getIntent().getExtras().getInt("daysToGo")));
        category.setText(getIntent().getExtras().getString("category"));
        progressBar.setMax(100);
        progressBar.setProgress(getIntent().getExtras().getInt("progress"));
        progressBar.setActivated(true);
        progressBar.show();
        // loading invention cover using Glide library
        Glide.with(DetailActivity.this).load(getIntent().getExtras().getInt("image")).into(thumbnail);
    }

}
