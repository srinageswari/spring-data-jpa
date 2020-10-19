package com.recipe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.recipe.data.RecipeRepository;
import com.recipe.model.Recipe;
import com.recipe.service.RecipeService;

/**
 * @author smanickavasagam
 *
 */
@Component
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeData;

	public boolean add(Recipe recipe) {
		if (recipe != null)
			findRecipe(recipe.getName());
		if (findRecipe(recipe.getName()) != null)
			return false;
		else
			recipeData.save(recipe);
		return true;
	}

	public void modify(String name, Recipe recipe) {
		Recipe rec = new Recipe();
		rec = findRecipe(name);
		if (rec != null) {
			recipeData.save(recipe);
		}
	}

	public List<Recipe> view() {
		List<Recipe> allingrecipies = recipeData.findAll();
		return allingrecipies;
	}

	public void delete(String name) {
		Recipe recipe = new Recipe();
		recipe = findRecipe(name);
		if (recipe != null)
			recipeData.delete(recipe);
	}

	public Recipe getDetailsByName(String name) {
		Recipe recipe = new Recipe();
		recipe = findRecipe(name);
		return recipe;
	}

	public Recipe findRecipe(String name) {
		List<Recipe> allRecipies = recipeData.findAll();
		Recipe recipe = null;
		for (Recipe rec : allRecipies) {
			if (rec.getName().equalsIgnoreCase(name)) {
				recipe = rec;
				break;
			}
		}
		return recipe;
	}
}
