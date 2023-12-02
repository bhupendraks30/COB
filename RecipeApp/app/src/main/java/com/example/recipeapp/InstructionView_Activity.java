package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipeapp.adroidUtil.AndroidUtil;
import com.example.recipeapp.adroidUtil.RecipeModel;

public class InstructionView_Activity extends AppCompatActivity {
    ImageView foodImage;
    TextView foodName,instructions;
    ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_view);
        foodImage = findViewById(R.id.foodImage_InstructionView_Activity);
        foodName = findViewById(R.id.foodName_InstructionView_Activity);
        instructions = findViewById(R.id.textView_InstructionView_Activity);
        backButton = findViewById(R.id.back_button_InstructionView_Activity);

        RecipeModel recipeModel = AndroidUtil.getIntentData(getIntent());

        foodImage.setImageResource(recipeModel.getImage());
        foodName.setText(recipeModel.getTitle());
        instructions.setText(recipeModel.getInstruction());
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}