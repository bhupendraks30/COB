package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sweet_title,veg_title,nonVeg_title;
    Button vegRecipe,nonRecipe,sweetRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sweet_title = findViewById(R.id.sweet_MainActivity);
        veg_title = findViewById(R.id.veg_MainActivity);
        nonVeg_title = findViewById(R.id.non_veg_MainActivity);
        sweetRecipe = findViewById(R.id.recipe_sweet_MainActivity);
        vegRecipe = findViewById(R.id.veg_recipe_MainActivity);
        nonRecipe = findViewById(R.id.non_veg_recipe_MainActivity);

        vegRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),VegRecipeList.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        nonRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),NonVegRecipeList.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        sweetRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SweetRecipeList.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });





    }
}