package com.micha.RecipeBook.common;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Step {

    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String description;
}
