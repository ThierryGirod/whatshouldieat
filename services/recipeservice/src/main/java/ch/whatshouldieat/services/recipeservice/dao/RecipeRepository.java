package ch.whatshouldieat.services.recipeservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ch.whatshouldieat.services.recipeservice.model.Recipe;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, Long> {
}
