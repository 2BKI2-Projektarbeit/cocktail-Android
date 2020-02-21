package com.example.cocktail_android.objects;

import android.graphics.Bitmap;

import com.example.cocktail_android.redis.controllers.CocktailController;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class Cocktail {
    private UUID cocktailId;
    private String name;
    private String description;
    private Bitmap image;
    private HashMap<Ingredient, Integer> ingredients;
    private Date createdAt;

    public Cocktail(UUID cocktailId, String name, String description, HashMap<Ingredient, Integer> ingredients, Date createdAt) {
        this.cocktailId = cocktailId;
        this.name = name;
        this.description = description;
        this.image = CocktailController.getBitmapFromURL(cocktailId);
        this.ingredients = ingredients;
        this.createdAt = createdAt;
    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Bitmap getImage() {
        return image;
    }

    public HashMap<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
