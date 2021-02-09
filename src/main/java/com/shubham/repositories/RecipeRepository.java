package com.shubham.repositories;

import com.shubham.domain.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    public final static String FIND_BY_CATEGORY_ID = "SELECT distinct * FROM RECIPE " +
            "where ID in(select distinct RECIPE_ID " +
                        "from RECIPE_CATEGORY " +
                        "where CATEGORY_ID=:id)";

    @Query(value = FIND_BY_CATEGORY_ID, nativeQuery = true)
    @Transactional(readOnly = true)
    Set<Recipe> findRecipesByCategoryId(@Param("id") Long id);
}
