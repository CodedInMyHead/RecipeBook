package com.micha.RecipeBook.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "public", name = "Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;
}
