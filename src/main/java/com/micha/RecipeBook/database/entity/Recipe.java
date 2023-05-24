package com.micha.RecipeBook.database.entity;

import com.micha.RecipeBook.common.RecipePayload;
import com.micha.RecipeBook.common.RecipeType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(length=50, nullable=false, unique=true)
    private String name;

    @Column(length=200, nullable=false)
    private String description;

    @Column(nullable = false)
    @ManyToMany
    private ArrayList<Step> steps;

    @Column(nullable = false)
    @ManyToMany
    private ArrayList<Ingredient> ingredients;

    @Column
    @Enumerated(EnumType.STRING)
    private RecipeType recipeType;

    public static Recipe of(RecipePayload recipePayload) {
        final Recipe recipe = new Recipe();
        recipe.steps = recipePayload.getSteps();
        recipe.recipeType = recipePayload.getRecipeType();
        recipe.ingredients = recipePayload.getIngredients();
        recipe.name = recipePayload.getName();
        recipe.description = recipePayload.getDescription();
        return recipe;
    }
}
