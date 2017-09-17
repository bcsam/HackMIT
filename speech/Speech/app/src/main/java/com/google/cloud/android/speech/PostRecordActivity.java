package com.google.cloud.android.speech;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by brentsamuels on 9/16/17.
 */

public class PostRecordActivity extends AppCompatActivity {

    String transcript;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_record);
        transcript = getIntent().getStringExtra("transcript");

        //AnalyzerClient client = new AnalyzerClient();
        //client.getScores(transcript);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        //ViewPagerAdapter adapter = new ViewPagerAdapter()
    }
}
