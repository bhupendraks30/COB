package com.example.coffee_shop_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton h_capachino, h_expresso, h_americano, h_hot, h_cold, h_cafe;
    boolean capachino, expresso, americano, hot, cold, cafe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h_americano =findViewById(R.id.heart_americano);
        h_capachino = findViewById(R.id.heart_capachino);
        h_cold =findViewById(R.id.heart_cold_coffee);
        h_hot =findViewById(R.id.heart_hot_coffee);
        h_expresso = findViewById(R.id.heart_expresso);
        h_cafe = findViewById(R.id.heart_cafe_latte);


        capachino=true;
        expresso=true;
        americano=true;
        hot=true;
        cold=true;
        cafe=true;

    }

    public void click_1(View view) {
        if(capachino){
            h_capachino.setImageResource(R.drawable.favorite_filled);
            capachino=false;
        }else{
            h_capachino.setImageResource(R.drawable.favorite_border);
            capachino=true;
        }
    }

    public void click_2(View view) {
        if(cold){
            h_cold.setImageResource(R.drawable.favorite_filled);
            cold=false;
        }else{
            h_cold.setImageResource(R.drawable.favorite_border);
            cold=true;
        }
    }

    public void click_3(View view) {
        if(expresso){
            h_expresso.setImageResource(R.drawable.favorite_filled);
            expresso=false;
        }else{
            h_expresso.setImageResource(R.drawable.favorite_border);
            expresso=true;
        }
    }

    public void click_4(View view) {
        if(cafe){
            h_cafe.setImageResource(R.drawable.favorite_filled);
            cafe=false;
        }else{
            h_cafe.setImageResource(R.drawable.favorite_border);
            cafe=true;
        }
    }

    public void click_5(View view) {
        if(americano){
            h_americano.setImageResource(R.drawable.favorite_filled);
            americano=false;
        }else{
            h_americano.setImageResource(R.drawable.favorite_border);
            americano=true;
        }
    }

    public void click_6(View view) {
        if(hot){
            h_hot.setImageResource(R.drawable.favorite_filled);
            hot=false;
        }else {
            h_hot.setImageResource(R.drawable.favorite_border);
            hot = true;
        }
    }

    public void capuchino_coffee(View view) {
        int id = 0;
        Intent i = new Intent(this,Detail.class);
        i.putExtra("id",id);
        startActivity(i);
    }

    public void cold_coffee_m(View view) {
        int id = 1;
        Intent i = new Intent(this,Detail.class);
        i.putExtra("id",id);
        startActivity(i);
    }

    public void espresso_Coffee(View view) {
        int id = 2;
        Intent i = new Intent(this,Detail.class);
        i.putExtra("id",id);
        startActivity(i);
    }

    public void cafe_latte_coffee(View view) {
        int id = 3;
        Intent i = new Intent(this,Detail.class);
        i.putExtra("id",id);
        startActivity(i);
    }

    public void americano_coffee(View view) {
        int id = 4;
        Intent i = new Intent(this,Detail.class);
        i.putExtra("id",id);
        startActivity(i);
    }

    public void hot_coffee_m(View view) {
        int id = 5;
        Intent i = new Intent(this,Detail.class);
        i.putExtra("id",id);
        startActivity(i);
    }
}