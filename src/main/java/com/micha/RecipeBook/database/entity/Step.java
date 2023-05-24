package com.micha.RecipeBook.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Step {

    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String description;
}
