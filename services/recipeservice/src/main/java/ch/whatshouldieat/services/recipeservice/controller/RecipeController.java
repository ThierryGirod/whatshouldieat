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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.whatshouldieat.services.recipeservice.model.Recipe;
import ch.whatshouldieat.services.recipeservice.service.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    
    private final RecipeService service;
  //  private final String CORS_IP_ALLOW = "http://ac04efe572a774d43ae8144e0b735fc5-2046315918.eu-central-1.elb.amazonaws.com:80";

    @Autowired
    public RecipeController(RecipeService recipeService){
        this.service = recipeService;
    }

    @CrossOrigin
    @GetMapping("")
    public List<Recipe> returnRecipesByOwnerId(@RequestParam("ownerId") Optional<String> ownerId){
        if(ownerId.isPresent()){
            return service.findRecipeByOwnerId(ownerId.get());
        }
        
        return service.getAllRecipes();
    }

    @CrossOrigin
    @GetMapping("/{recipeId}")
    public Recipe returnRecipeById(@PathVariable("recipeId") Long recipeId){
         Optional<Recipe> opt = service.findRecipeById(recipeId);
         if(!opt.isEmpty()){
             System.out.println(opt.get());
           return (Recipe)opt.get();
         }
         return null;    // todo optional??
    }

    @CrossOrigin
    @PostMapping("")
    public Recipe addRecipe(@RequestBody Recipe newRecipe) {
        return service.saveRecipe(newRecipe);
    }

    @CrossOrigin
    @PutMapping("/{recipeId}")
    public Recipe updateRecipe(@RequestBody Recipe updateRecipe, @PathVariable Long recipeId){
        return service.updateRecipe(recipeId, updateRecipe);
    }

    @CrossOrigin
    @DeleteMapping("/{recipeId}")
    public void deleteRecipe(@PathVariable Long recipeId){
        service.deleteRecipe(recipeId);
    }

    @GetMapping("/test")
    public Recipe test(){
        return new Recipe("Test"); 
    }

}
