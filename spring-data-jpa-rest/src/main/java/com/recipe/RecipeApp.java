/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.recipe.controller.RecipeController;

@SpringBootApplication()
@ComponentScan({"com.recipe.repository"})
@ComponentScan({"com.recipe.service"})
@ComponentScan(basePackageClasses = RecipeController.class)
@EntityScan("com.recipe.model")
@EnableJpaRepositories("com.recipe.data")

public class RecipeApp {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApp.class, args);
	}
}
