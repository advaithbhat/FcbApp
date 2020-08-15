package com.example.fcbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent mainintent=new Intent(MainActivity.this,Main2Activity.class);
               startActivity(mainintent);
               finish();
           }
       },1000);

    }
}
