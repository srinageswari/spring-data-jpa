package com.recipe.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.model.Recipe;

/**
 * @author smanickavasagam
 *
 */

public interface RecipeRepository extends JpaRepository<Recipe
			, Long> {

}