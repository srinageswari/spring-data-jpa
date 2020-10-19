package com.recipe.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.recipe.model.Recipe;

/**
 * @author smanickavasagam
 *
 */
@Component
public interface RecipeService {
	public boolean add(Recipe recipe);
	public void modify(String name, Recipe recipe);
	public Recipe getDetailsByName(String name);
	public List<Recipe> view();
	public void delete(String name);
}