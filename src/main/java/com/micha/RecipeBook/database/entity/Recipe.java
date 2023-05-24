package com.micha.RecipeBook.database.entity;

import com.micha.RecipeBook.common.RecipeType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
@Table(schema = "public", name = "Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(length=50, nullable=false, unique=true)
    private String name;

    @Column(length=200, nullable=false)
    private String description;

    @Column(nullable = false)
    private ArrayList<Integer> steps;

    @Column(nullable = false)
    private ArrayList<Integer> ingredients;

    @Column
    @Enumerated(EnumType.STRING)
    private RecipeType recipeType;
}
