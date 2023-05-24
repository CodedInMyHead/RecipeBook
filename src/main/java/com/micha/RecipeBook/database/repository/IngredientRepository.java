package com.micha.RecipeBook.database.repository;

import com.micha.RecipeBook.database.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
