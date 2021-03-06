package com.backend.Dto;

import com.backend.Models.IngredientEntity;
import com.backend.Models.PhotoEntity;
import com.backend.Models.StepEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeAddDto {
    @NotBlank
    private String name;
    @NotNull
    private char ifexternal;
    private String description;
    private Set<IngredientEntity> ingredients = new HashSet<IngredientEntity>();
    private Set<StepEntity> steps = new HashSet<StepEntity>();
    private List<PhotoEntity> photos = new ArrayList<PhotoEntity>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getIfexternal() {
        return ifexternal;
    }

    public void setIfexternal(char ifexternal) {
        this.ifexternal = ifexternal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<StepEntity> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepEntity> steps) {
        this.steps = steps;
    }

    public List<PhotoEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoEntity> photos) {
        this.photos = photos;
    }

}
