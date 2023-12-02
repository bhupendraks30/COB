package com.example.recipeapp;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 try{
                     sleep(2000);
                     startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                     finish();
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }

             }
         },1000);
    }
}