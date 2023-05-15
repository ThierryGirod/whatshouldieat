package ch.whatshouldieat.services.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import ch.whatshouldieat.services.recipeservice.controller.RecipeController;
import ch.whatshouldieat.services.recipeservice.model.Recipe;
import ch.whatshouldieat.services.recipeservice.service.RecipeService;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RecipeControllerTest {

    @Autowired
    RecipeService recipeService;

    @Autowired
    TestRestTemplate template;

    public RecipeControllerTest(){
   //     this.template = new TestRestTemplate();
    }

    @Test
    public void returnTest(){

        RecipeController controller = new RecipeController(recipeService);
        Recipe result = controller.test();
        assertEquals("Test", result.getName());
    }

    /*

    @Test
    public void returnTestRest(){
       
        ResponseEntity<Recipe> entity = this.template.getForEntity("http://localhost:8080/test", Recipe.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
  
    }
      */

    
}
