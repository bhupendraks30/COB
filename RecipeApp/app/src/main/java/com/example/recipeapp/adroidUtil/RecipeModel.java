package com.example.recipeapp.adroidUtil;

import android.widget.ImageView;

import java.util.SplittableRandom;

public class RecipeModel {
    int image;
    int title;
    int ingredients;
    int instruction;

    public RecipeModel() {
    }

    public RecipeModel(int image, int title, int ingredients, int instruction) {
        this.image = image;
        this.title = title;
        this.ingredients = ingredients;
        this.instruction = instruction;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIngredients() {
        return ingredients;
    }

    public void setIngredients(int ingredients) {
        this.ingredients = ingredients;
    }

    public int getInstruction() {
        return instruction;
    }

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }
}
