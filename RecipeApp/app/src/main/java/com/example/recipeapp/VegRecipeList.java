package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recipeapp.adroidUtil.RecipeModel;
import com.example.recipeapp.recyclerAdapter.RecyclerAdapterForRecipe;

import java.util.ArrayList;

public class VegRecipeList extends AppCompatActivity {

    ArrayList<RecipeModel> arrayList = new ArrayList<>();
    RecyclerView recyclerView;

    RecyclerAdapterForRecipe adapter ;
    ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_recipe_list);
        recyclerView = findViewById(R.id.recyclerView_veg_recipe_list);
        back_button = findViewById(R.id.back_button_VegRecipeList);

        int alooGobi = R.drawable.veg_aloo_gobi;
        int dalMakhani = R.drawable.veg_dal_makhani;
        int matterPaneer = R.drawable.veg_matter_paneer;
        int paneerButter = R.drawable.veg_paneer_butter_masala;

        RecipeModel one = new RecipeModel(alooGobi,R.string.veg_rec_aloo_gobi,R.string.ingre_aloo_gobi,R.string.instruction_aloo_gobi);
        RecipeModel two = new RecipeModel(dalMakhani,R.string.veg_rec_dal_makhani,R.string.ingre_dal_makhani,R.string.instruction_dal_makhani);
        RecipeModel three = new RecipeModel(matterPaneer,R.string.veg_rec_matar_paneer,R.string.ingre_matar_paneer,R.string.instruction_matar_paneer);
        RecipeModel four = new RecipeModel(paneerButter,R.string.veg_rec_paneer_butter_masala,R.string.ingre_paneer_butter_masala,R.string.instruction_butter_masala);
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