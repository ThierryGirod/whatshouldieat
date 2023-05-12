package ch.whatshouldieat.services.recipeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import ch.whatshouldieat.services.recipeservice.controller.RecipeController;
import ch.whatshouldieat.services.recipeservice.dao.RecipeRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = RecipeRepository.class)
public class RecipeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeserviceApplication.class, args);
	}

}
