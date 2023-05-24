package com.micha.RecipeBook.common;

import com.micha.RecipeBook.database.entity.Ingredient;
import com.micha.RecipeBook.database.entity.Step;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RecipePayload {

    private String name;
    private String description;
    private ArrayList<Step> steps;
    private ArrayList<Ingredient> ingredients;
    private RecipeType recipeType;
}
