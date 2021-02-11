package com.shubham.controllers;

import com.shubham.services.CategoryService;
import com.shubham.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public IndexController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping({"","/","/index","/home"})
    public String getIndexPage(Model model){

        log.debug("Getting Index Page");

        model.addAttribute("recipes", recipeService.getRecipes());
        model.addAttribute("categories", categoryService.findAll());

        return "index";
    }

}
