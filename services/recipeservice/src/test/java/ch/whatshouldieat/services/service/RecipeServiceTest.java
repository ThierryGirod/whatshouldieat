package ch.whatshouldieat.services.service;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import ch.whatshouldieat.services.recipeservice.dao.RecipeRepository;
import ch.whatshouldieat.services.recipeservice.model.Recipe;
import ch.whatshouldieat.services.recipeservice.service.RecipeService;

@Disabled
@SpringBootTest
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class RecipeServiceTest {
/*
    @TestConfiguration
    static class RecipeServiceImplTestContextConfiguration {
 
        @Bean
        public RecipeService recipeService() {
            return new RecipeService();
        }
    }
  */ 
  
  @Autowired MongoTemplate mongoTemplate;

    @Autowired
    private RecipeService recipeService;

    @MockBean
    private RecipeRepository recipeRepository;

 /*   @Test
    @Disabled
    public void saveRecipeTest(){

        RecipeService recipeService = new RecipeService(recipeRepository);
        Recipe recipe = new Recipe("Test");
        recipeService.saveRecipe(recipe);
        assert(true);

    }
    */
}
