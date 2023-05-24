package com.micha.RecipeBook.api;

import com.micha.RecipeBook.database.entity.Ingredient;
import com.micha.RecipeBook.database.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.micha.RecipeBook.database.util.UTIL.API_ROOT;

@RestController
@RequestMapping(value = API_ROOT + "/ingredient")
public class IngredientController {

    @Autowired
    IngredientRepository repository;

    @PostMapping()
    public ResponseEntity<String> createIngredient(@RequestBody final Ingredient ingredient) {
        try {
            repository.save(ingredient);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Something went wrong saving given object. Make sure that it contains valid values.");
        }
    }

    @PutMapping
    public ResponseEntity<String> replaceIngredient(@RequestBody final Ingredient ingredient) {
        try {
            if(repository.findById(ingredient.getId()).isPresent()) {
                repository.deleteById(ingredient.getId());
            }
            repository.save(ingredient);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Value couldn't be deleted successfully");
        }
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteIngredient(final Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Value couldn't be deleted successfully");
        }
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        try {
            return ResponseEntity.status(200).body(repository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredients(@PathVariable Long id) {
        try {
            Optional<Ingredient> ingredient = repository.findById(id);
            if (ingredient.isPresent()) {
                return ResponseEntity.status(200).body(ingredient.get());
            }
            return ResponseEntity.status(400).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

}
