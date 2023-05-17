package ch.whatshouldieat.services.recipeservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.whatshouldieat.services.recipeservice.dao.RecipeRepository;
import ch.whatshouldieat.services.recipeservice.model.Recipe;
import ch.whatshouldieat.services.recipeservice.utils.DemoDataFileReader;


@Service @Transactional
public class RecipeService {

    private static final Logger logger = LoggerFactory.getLogger(RecipeService.class);

    private String demoDataFilePath;

    private final RecipeRepository repository;
    private List<Recipe> fullRecipesList;
    
   @Autowired
   public RecipeService(RecipeRepository recipeRepository, @Value("${demodata.recipe.filepath}") String filepath){
       this.repository = recipeRepository;
       this.demoDataFilePath = filepath;
       initalizeDatabaseWithDemoValues();
   } 

    public Optional<Recipe> findRecipeById(Long id){
        return repository.findById(id);
    }

    public List<Recipe> findRecipeByOwnerId(String ownerId){
        return repository.findByOwnerId(ownerId);
    }

    public Recipe saveRecipe(Recipe recipe){
        return repository.save(recipe);
    }

    public List<Recipe> getAllRecipes(){
        if(fullRecipesList == null || fullRecipesList.isEmpty()){
            return repository.findAll();
        }
        return fullRecipesList;
    }

    public Recipe updateRecipe(Long id, Recipe newRecipe){
        return repository.findById(id)
        .map(recipe -> {
            recipe.setName(newRecipe.getName());
            recipe.setCookingInstructions(newRecipe.getCookingInstructions());
            recipe.setIngredients(newRecipe.getIngredients());
            recipe.setImageUrl(newRecipe.getImageUrl());
            recipe.setAdditionalInformation(newRecipe.getAdditionalInformation());
          return repository.save(recipe);
        })
        .orElseGet(() -> {
              newRecipe.setId(id);
          return repository.save(newRecipe);
        });
    }

    public void deleteRecipe(Long id){
        repository.deleteById(id);
    }

    public Long countRecipes(){
        return repository.count();
    }

    public void initalizeDatabaseWithDemoValues(){
        if(this.countRecipes() == 0){
            logger.info("DB is empty. Will initalize with demo values");
            repository.saveAll(DemoDataFileReader.readLines(demoDataFilePath));
        }
    }
}
