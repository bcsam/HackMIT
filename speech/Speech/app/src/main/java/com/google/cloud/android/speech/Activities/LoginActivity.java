package com.google.cloud.android.speech.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.cloud.android.speech.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void launchIntent(View view) {
        Intent i = new Intent(this, PickClassesActivity.class);
        this.startActivity(i);
        Toast.makeText(this, "Welcome to Ekko", Toast.LENGTH_SHORT).show();
    }
}
