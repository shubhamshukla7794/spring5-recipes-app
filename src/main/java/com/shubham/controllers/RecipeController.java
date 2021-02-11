package com.shubham.controllers;

import com.shubham.commands.CategoryCommand;
import com.shubham.commands.RecipeCommand;
import com.shubham.domain.Category;
import com.shubham.services.CategoryService;
import com.shubham.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class RecipeController {

    private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";
    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        model.addAttribute("newLineChar", '\n');
        model.addAttribute("categories", categoryService.findAll());

        return "recipe/show";
    }

    @GetMapping("/recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("selectedCats", null);
        model.addAttribute("isSelectedCats", false);
        return RECIPE_RECIPEFORM_URL;
    }

    @GetMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){

        List<Long> selectedCategories =  categoryService.getSelectedCategoriesId(Long.valueOf(id));
        boolean isSelectedCats;
        if (!selectedCategories.isEmpty()){
            isSelectedCats = true;
        }else {
            isSelectedCats = false;
        }

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("selectedCats", selectedCategories);
        model.addAttribute("isSelectedCats", isSelectedCats);
        return RECIPE_RECIPEFORM_URL;
    }


//    @RequestMapping(name = "recipe", method = RequestMethod.POST) -   Old Method but still working
    @PostMapping("recipe")
    public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand recipeCommand,
                               BindingResult bindingResult,
                               @RequestParam(value = "cats", required = false) int[] cats){

        log.debug("The msg : " + bindingResult.toString());

        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });
            return RECIPE_RECIPEFORM_URL;
        }

        if (cats != null){
            CategoryCommand categoryCommand;
            for (int id : cats) {
                Category cat1 = categoryService.findById((long) id);
                if (cat1 != null){
                    categoryCommand = new CategoryCommand();
                    categoryCommand.setId((long) id);
                    recipeCommand.addCategory(categoryCommand);
                }
            }
        }

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);

        if (savedCommand.getIngredients().isEmpty() || (savedCommand.getIngredients().isEmpty() && savedCommand.getImage()==null))
        {
            return "redirect:/recipe/" + savedCommand.getId() +"/update";
        }

        return "redirect:/recipe/" + savedCommand.getId() +"/show";
    }

    @GetMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
