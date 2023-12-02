package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.recipeapp.adroidUtil.RecipeModel;
import com.example.recipeapp.recyclerAdapter.RecyclerAdapterForRecipe;

import java.util.ArrayList;

public class SweetRecipeList extends AppCompatActivity {

    ArrayList<RecipeModel> arrayList;
    RecyclerAdapterForRecipe adapter ;
    ImageButton back_button;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_recipe_list);
        arrayList = new ArrayList<>();
        back_button = findViewById(R.id.back_button_SweetRecipeList);
        recyclerView = findViewById(R.id.recyclerView_SweetRecipelist);

        int imgOne = R.drawable.sweet_coconut_laddu;
        int imgTwo = R.drawable.sweet_kalakand;
        int imgThree = R.drawable.sweet_eggless_banana_cake;
        int imgFore = R.drawable.sweet_rose_milk;

        RecipeModel one = new RecipeModel(imgOne,R.string.sweets_coconut_laddu,R.string.ingre_coconut_laddu,R.string.instruction_coconut_laddu);
        RecipeModel two = new RecipeModel(imgTwo,R.string.sweets_kalakand,R.string.ingre_kalakand,R.string.instruction_kalakand);
        RecipeModel three = new RecipeModel(imgThree,R.string.sweets_banana_cake,R.string.ingre_banana_cake,R.string.instruction_banana_cake);
        RecipeModel four = new RecipeModel(imgFore,R.string.sweets_rose_milk,R.string.ingre_rose_milk,R.string.instruction_rose_milk);
        arrayList.add(one);
        arrayList.add(two);
        arrayList.add(three);
        arrayList.add(four);
        adapter = new RecyclerAdapterForRecipe(getApplicationContext(),arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}