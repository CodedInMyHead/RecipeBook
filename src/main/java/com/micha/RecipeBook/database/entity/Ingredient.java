package com.micha.RecipeBook.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(schema = "public", name = "Ingredient")
public class Ingredient {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String description;
}
