package com.google.cloud.android.speech.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.cloud.android.speech.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView ivProfilePicture = (ImageView) findViewById(R.id.ivProfilePicture);
        Glide.with(this)
                .load("https://scontent.xx.fbcdn.net/v/t1.0-1/p200x200/17201093_1299062806852781_4533647239193588184_n.jpg?oh=d5a76e316a3ef0fd3c4bfec641706409&oe=5A23FCC9")
                .into(ivProfilePicture);
    }

    public void launchIntent(View view) {
        Intent i = new Intent(this, PickClassesActivity.class);
        this.startActivity(i);
        Toast.makeText(this, "Welcome to Ekko", Toast.LENGTH_SHORT).show();
    }
}
