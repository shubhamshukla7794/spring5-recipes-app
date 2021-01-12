package com.shubham.controllers;

import com.shubham.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Mock
    IndexController controller;

    @Before
    public void setUp() throws Exception {
        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        String viewName = controller.getIndexPage(model);
        assertEquals("index",viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}