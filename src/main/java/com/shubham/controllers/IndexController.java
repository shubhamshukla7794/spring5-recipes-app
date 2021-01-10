package com.shubham.controllers;

import com.shubham.domain.Category;
import com.shubham.domain.UnitOfMeasure;
import com.shubham.repositories.CategoryRepository;
import com.shubham.repositories.UnitOfMeasureRepository;
import com.shubham.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
