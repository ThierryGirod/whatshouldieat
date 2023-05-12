package ch.whatshouldieat.services.recipeservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.whatshouldieat.services.recipeservice.model.Recipe;
import ch.whatshouldieat.services.recipeservice.service.RecipeService;

@RestController
public class RecipeController {
    
    private final RecipeService service;
  //  private final String CORS_IP_ALLOW = "http://ac04efe572a774d43ae8144e0b735fc5-2046315918.eu-central-1.elb.amazonaws.com:80";

    @Autowired
    public RecipeController(RecipeService recipeService){
        this.service = recipeService;
    }

    @CrossOrigin
    @GetMapping("/recipe")
    public List<Recipe> returnRecipes(){
        return service.getAllRecipes();
    }

    @CrossOrigin
    @GetMapping("/fooditem/{id}")
    public Recipe returnRecipeById(@PathVariable("id") Long id){
         Optional<Recipe> opt = service.findRecipeById(id);
         if(!opt.isEmpty()){
             System.out.println(opt.get());
           return (Recipe)opt.get();
         }
         return null;    
    }

    @CrossOrigin
    @PostMapping("/fooditem")
    public Recipe addRecipe(@RequestBody Recipe newRecipe) {
        return service.saveRecipe(newRecipe);
    }

    @CrossOrigin
    @PutMapping("/fooditem/{id}")
    public Recipe updateRecipe(@RequestBody Recipe updateRecipe, @PathVariable Long id){
        return service.updateRecipe(id, updateRecipe);
    }

    @CrossOrigin
    @DeleteMapping("/fooditem/{id}")
    public void deleteRecipe(@PathVariable Long id){
        service.deleteRecipe(id);
    }

    @GetMapping("/test")
    public Recipe test(){
        return new Recipe("Test"); 
    }

}
