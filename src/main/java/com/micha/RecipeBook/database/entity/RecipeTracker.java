package com.micha.RecipeBook.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class RecipeTracker {

    @Id
    private String name;

    @Column
    private ArrayList<Long> madeWhen;
}
