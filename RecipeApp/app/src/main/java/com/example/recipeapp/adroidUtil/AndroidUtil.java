package com.example.recipeapp.adroidUtil;

import android.content.Context;
import android.content.Intent;

public class AndroidUtil {
    public static void passIntentData(Intent intent,RecipeModel recipeModel){
        intent.putExtra("foodName",recipeModel.getTitle());
        intent.putExtra("instructions",recipeModel.getInstruction());
        intent.putExtra("ingredients",recipeModel.getIngredients());
        intent.putExtra("foodImage",recipeModel.getImage());
    }
    public static RecipeModel getIntentData(Intent intent){
        RecipeModel recipeModel = new RecipeModel();
        recipeModel.setImage(intent.getIntExtra("foodImage",0));
        recipeModel.setTitle(intent.getIntExtra("foodName",0));
        recipeModel.setIngredients(intent.getIntExtra("ingredients",0));
        recipeModel.setInstruction(intent.getIntExtra("instructions",0));
        return recipeModel;
    }

}
