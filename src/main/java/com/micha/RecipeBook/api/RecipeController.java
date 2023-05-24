package com.micha.RecipeBook.api;

import com.micha.RecipeBook.common.RecipePayload;
import com.micha.RecipeBook.common.RecipeType;
import com.micha.RecipeBook.database.entity.Recipe;
import com.micha.RecipeBook.database.repository.RecipeRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.micha.RecipeBook.database.util.UTIL.API_ROOT;

@RestController(value = API_ROOT + "/recipe")
public class RecipeController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("")
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    @GetMapping("type/{type}")
    public ResponseEntity<List<Recipe>> getRecipesByType(@PathVariable String recipeType) {
        final RecipeType value;
        try {
            value = RecipeType.valueOf(recipeType);
        } catch (Exception e) {
            return ResponseEntity.status(400).header("error", "Type not found. Please").build();
        }
        return ResponseEntity.status(200).body(repository.findAll().stream().filter(recipe -> recipe.getRecipeType() == value).collect(Collectors.toList()));
    }

    @PutMapping("")
    public void createRecipe(@RequestBody RecipePayload payload) {
       Recipe recipe = Recipe.of(payload);
       repository.save(recipe);
    }

}
