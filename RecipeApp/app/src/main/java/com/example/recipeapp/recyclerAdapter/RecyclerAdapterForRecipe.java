package com.example.recipeapp.recyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.IngredientsView_Activity;
import com.example.recipeapp.InstructionView_Activity;
import com.example.recipeapp.R;
import com.example.recipeapp.adroidUtil.AndroidUtil;
import com.example.recipeapp.adroidUtil.RecipeModel;

import java.util.ArrayList;

public class RecyclerAdapterForRecipe extends RecyclerView.Adapter<RecyclerAdapterForRecipe.RecyclerViewHolder> {
    Context context;
    ArrayList<RecipeModel> arrayList;

    public RecyclerAdapterForRecipe(Context context, ArrayList<RecipeModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipe_view_layout_row,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        RecipeModel recipeModel = arrayList.get(position);
        holder.title.setText(recipeModel.getTitle());
        holder.foodImage.setImageResource(recipeModel.getImage());

        holder.instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InstructionView_Activity.class);
                AndroidUtil.passIntentData(intent,recipeModel);
                context.startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        holder.ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IngredientsView_Activity.class);
                AndroidUtil.passIntentData(intent,recipeModel);
                context.startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView title,ingredients;
        ImageView foodImage;
        Button instruction;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_RecipeViewRow);
            foodImage = itemView.findViewById(R.id.foodImage_RecipeViewRow);
            ingredients = itemView.findViewById(R.id.ingredients_RecipeViewRow);
            instruction = itemView.findViewById(R.id.instruction_RecipeViewRow);
        }
    }
}


