package com.shubham.repositories;

import com.shubham.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

//    List<Recipe> findByCategories(Set<Category> categories);
//    SELECT * FROM RECIPE where ID =(select distinct RECIPE_ID from RECIPE_CATEGORY where CATEGORY_ID=3)
}
