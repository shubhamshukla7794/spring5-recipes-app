package com.shubham.controllers;

import com.shubham.domain.Category;
import com.shubham.domain.Recipe;
import com.shubham.services.CategoryService;
import com.shubham.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    CategoryService categoryService;

    CategoryController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new CategoryController(recipeService, categoryService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new ControllerExceptionHandler())
                .build();
    }

    @Test
    void getRecipesByCategoryId() throws Exception {

        //given
        Category cat1 = new Category();
        Category cat2 = new Category();
        Category cat3 = new Category();

        cat1.setId(1L);
        cat2.setId(2L);
        cat3.setId(3L);

        Set<Category> categories1 = new HashSet<>();
        Set<Category> categories2 = new HashSet<>();
        Set<Category> categories3 = new HashSet<>();

        categories1.add(cat1);
        categories1.add(cat2);

        categories2.add(cat3);
        categories2.add(cat2);

        categories3.add(cat1);

        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setCategories(categories1);
        Recipe recipe2 = new Recipe();
        recipe2.setId(1L);
        recipe2.setCategories(categories2);
        Recipe recipe3 = new Recipe();
        recipe3.setId(1L);
        recipe3.setCategories(categories3);
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe1);
        recipeSet.add(recipe2);


        //when
        when(recipeService.findRecipesByCategoryId(anyLong())).thenReturn(recipeSet);

        //then
        mockMvc.perform(get("/category/2/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("recipes"))
                .andExpect(model().attributeExists("categories"));

    }
}