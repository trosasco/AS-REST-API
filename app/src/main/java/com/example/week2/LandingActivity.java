package com.example.week2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        //Set title
        //Display welcome message with username

        //Display all users posts
    }

    public static Intent intentFactory(Context context) {
        return new Intent(context, LandingActivity.class);
    }
}
