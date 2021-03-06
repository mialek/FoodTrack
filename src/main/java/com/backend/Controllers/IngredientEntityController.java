package com.backend.Controllers;

import com.backend.Models.IngredientEntity;
import com.backend.Repositories.IngredientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientEntityController {

    @Autowired
    private IngredientEntityRepository ingredientRepository;

    @GetMapping("/api/ingredients")
    public Page<IngredientEntity> getIngredients(Pageable pageable)
    {
        return ingredientRepository.findAll(pageable);
    }

    @DeleteMapping("/api/ingredients/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable Long id)
    {
        ingredientRepository.deleteById(id);
        return new ResponseEntity("abcd", HttpStatus.ACCEPTED);
    }
}
