package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipeapp.adroidUtil.AndroidUtil;
import com.example.recipeapp.adroidUtil.RecipeModel;

public class IngredientsView_Activity extends AppCompatActivity {
    ImageView foodImage;
    TextView foodName,instructions;
    ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients_view);
        foodImage = findViewById(R.id.foodImage_IngredientsViewActivity);
        foodName = findViewById(R.id.foodName_IngredientViewActivity);
        instructions = findViewById(R.id.textView_IngredientsViewActivity);
        backButton = findViewById(R.id.back_button_IngredientViewActivity);

        RecipeModel recipeModel =AndroidUtil.getIntentData(getIntent());

        foodImage.setImageResource(recipeModel.getImage());
        foodName.setText(recipeModel.getTitle());
        instructions.setText(recipeModel.getIngredients());
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}