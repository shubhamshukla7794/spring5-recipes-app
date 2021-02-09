package com.shubham.services;

import com.shubham.converters.RecipeCommandToRecipe;
import com.shubham.converters.RecipeToRecipeCommand;
import com.shubham.domain.Category;
import com.shubham.domain.Recipe;
import com.shubham.exceptions.NotFoundException;
import com.shubham.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void getRecipeById() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null Recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdNotFound() throws Exception {
        Optional<Recipe> recipeOptional = Optional.empty();

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);
    }

    @Test
    public void deleteById() {
        //given
        Long idToDelete = 2L;
        //when
        recipeService.deleteById(idToDelete);
        //then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void getRecipesByCategoryId() {
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

        //given
        when(recipeRepository.findRecipesByCategoryId(anyLong())).thenReturn(recipeSet);

        //then
        Set<Recipe> foundRecipes = recipeRepository.findRecipesByCategoryId(2L);
        verify(recipeRepository, times(1)).findRecipesByCategoryId(anyLong());
        assertEquals(2, foundRecipes.size());
    }
}