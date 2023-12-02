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

public class NonVegRecipeList extends AppCompatActivity {
    ArrayList<RecipeModel> arrayList;
    RecyclerAdapterForRecipe adapter ;
    ImageButton back_button;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_veg_recipe_list);
        arrayList = new ArrayList<>();
        back_button = findViewById(R.id.back_button_NonVegRecipeList);
        recyclerView = findViewById(R.id.recyclerView_NonVegRecipeList);

        int imgOne = R.drawable.non_butter_chicker;
        int imgTwo = R.drawable.non_fish_pakora;
        int imgThree = R.drawable.non_chicken_tikka_masala;
        int imgFore = R.drawable.non_fish_tikka_masala;

        RecipeModel one = new RecipeModel(imgOne,R.string.non_rec_butter_chicken,R.string.ingre_butter_chicken,R.string.instruction_butter_chicken);
        RecipeModel two = new RecipeModel(imgTwo,R.string.non_rec_fish_pakoda,R.string.ingre_fish_pakoda,R.string.instruction_fish_pakoda);
        RecipeModel three = new RecipeModel(imgFore,R.string.non_rec_fish_tikka,R.string.ingre_fish_tikka,R.string.instruction_fish_tikka);
        RecipeModel four = new RecipeModel(imgThree,R.string.non_rec_chicken_tikka,R.string.ingre_chicken_tikka,R.string.instruction_chicken_tikka);
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