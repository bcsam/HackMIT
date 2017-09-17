package com.google.cloud.android.speech.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.cloud.android.speech.MainActivity;
import com.google.cloud.android.speech.R;

public class PickClassesActivity extends AppCompatActivity {
    ImageView ivBannerPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_classes);

        ivBannerPicture = (ImageView) findViewById(R.id.ivBanner);

        Glide.with(this)
                .load("http://www.bkmathur.com/images/maths.jpg")
                .into(ivBannerPicture);

        ivBannerPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PickClassesActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
