package com.micha.RecipeBook.database.repository;

import com.micha.RecipeBook.database.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
