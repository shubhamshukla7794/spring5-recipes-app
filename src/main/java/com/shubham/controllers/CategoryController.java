package com.shubham.controllers;

import com.shubham.services.CategoryService;
import com.shubham.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public CategoryController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("category/{id}/show")
    public String showRecipesByCategory(@PathVariable String id, Model model){
        model.addAttribute("recipes", recipeService.findRecipesByCategoryId(Long.valueOf(id)));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("currentCategory", categoryService.findById(Long.valueOf(id)));
        return "recipe/recipecategory";
    }

}
