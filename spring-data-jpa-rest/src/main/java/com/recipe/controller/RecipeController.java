package com.recipe.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.data.RecipeRepository;
import com.recipe.model.Recipe;
import com.recipe.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smanickavasagam
 *
 */
@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private RecipeRepository recipeData;

	@PostMapping(value = "/addNewRecipe")
	public ResponseEntity<Recipe> add(@RequestBody Recipe ing) {
		boolean ingCreated = false;
		if (ing != null)
			ingCreated = recipeService.add(ing);
		if (ingCreated)
			return new ResponseEntity<Recipe>(ing, HttpStatus.OK);
		else
			return new ResponseEntity<Recipe>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/getRecipeDetailsByName/{name}")
	public ResponseEntity<Recipe> getRecipeByName(@PathVariable String name) {
		Recipe ing = recipeService.getDetailsByName(name);
		if (ing == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ing);
	}

	@PatchMapping(value = "/updateRecipeDetails/{name}")
	public ResponseEntity<Recipe> updateRecipeByName(@PathVariable String name,
			@RequestBody Map<Object, Object> fields) {
		Recipe ing = recipeService.getDetailsByName(name);
		final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
		final Recipe ing1 = mapper.convertValue(fields, Recipe.class);
		if (fields != null) {
			for (Entry<Object, Object> entry : fields.entrySet()) {
				// use reflection to get field k on manager and set it to value k
				Field field;
				try {
					Field privateStringField = Recipe.class.getDeclaredField(String.valueOf(entry.getKey()));
					privateStringField.setAccessible(true);
					field = ReflectionUtils.findField(Recipe.class, privateStringField.getName());
					field.setAccessible(true);
					ReflectionUtils.setField(field, ing, privateStringField.get(ing1));
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		recipeData.save(ing);
		return new ResponseEntity<Recipe>(ing, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteRecipeDetailsByName/{name}")
	@ResponseBody
	public void deleteRecipeByName(@PathVariable String name) {
		recipeService.delete(name);
	}

	@GetMapping(value = "/viewRecipeDetails", headers = "Accept=application/json")
	@ResponseBody
	public List<Recipe> viewAllRecipeDetails() {
		List<Recipe> allRecipes = recipeService.view();
		return allRecipes;
	}
}