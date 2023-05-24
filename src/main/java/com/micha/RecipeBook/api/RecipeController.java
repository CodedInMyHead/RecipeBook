package com.micha.RecipeBook.api;

import com.micha.RecipeBook.common.RecipeType;
import com.micha.RecipeBook.database.entity.Recipe;
import com.micha.RecipeBook.database.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.micha.RecipeBook.database.util.UTIL.API_ROOT;

@RestController
@RequestMapping(value = API_ROOT + "/recipe")
public class RecipeController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        try {
            return ResponseEntity.status(200).body(repository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(200).body(List.of());
        }
    }

    @GetMapping("type/{type}")
    public ResponseEntity<List<Recipe>> getRecipesByType(@PathVariable String recipeType) {
        final RecipeType value;
        try {
            value = RecipeType.valueOf(recipeType);
        } catch (Exception e) {
            return ResponseEntity.status(400).header("error", "Type not found. Please").build();
        }
        try {
            return ResponseEntity.status(200).body(repository.findAll().stream().filter(recipe -> recipe.getRecipeType() == value).collect(Collectors.toList()));
        } catch (Exception e) {
            return ResponseEntity.status(200).body(List.of());
        }

    }

    @PutMapping("")
    public void createRecipe(@RequestBody Recipe recipe) {
       repository.save(recipe);
    }

}
