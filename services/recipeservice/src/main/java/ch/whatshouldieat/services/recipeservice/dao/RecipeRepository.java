package ch.whatshouldieat.services.recipeservice.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ch.whatshouldieat.services.recipeservice.model.Recipe;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, Long> {
        public List<Recipe> findByOwnerId(String ownerId);
   
}
