package com.micha.RecipeBook.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ingredient {

    @Id
    private String name;

    @Column
    private String description;
}
