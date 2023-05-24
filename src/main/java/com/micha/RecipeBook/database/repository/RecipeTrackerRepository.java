package com.micha.RecipeBook.database.repository;

import com.micha.RecipeBook.database.entity.RecipeTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeTrackerRepository  extends JpaRepository<RecipeTracker, Long> {
}