package ch.whatshouldieat.services.recipeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.whatshouldieat.services.recipeservice.dao.RecipeRepository;
import ch.whatshouldieat.services.recipeservice.model.Recipe;


@Service @Transactional
public class RecipeService {

    private final RecipeRepository repository;
    private List<Recipe> fullRecipesList;
    
   @Autowired
   public RecipeService(RecipeRepository recipeRepository){
       this.repository = recipeRepository;
       //TODO Technical Debt: find a better initalization strategy 
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
        // TODO Technical Debt: remove this from code and externalize population of default values (e.g. to file based approach)
        repository.saveAll(List.of(
            new Recipe("Spaghetti"),
            new Recipe("Spaghetti","100"),
            new Recipe("Avo", "100"),
            new Recipe("Avocado Toast"),
            new Recipe("Spaghetti Carbonara"),
            new Recipe("Avocado Toast"),
            new Recipe("Flammenkuchen"),
            new Recipe("Pizza"),
            new Recipe("Risotto"),
            new Recipe("Gmüesplätzli"),
            new Recipe("Fishsticks"),
            new Recipe("Rice Bowl"),
            new Recipe("Signature Dish"),
            new Recipe("Gmüesssuppe"),
            new Recipe("Pita"),
            new Recipe("Tacos"),
            new Recipe("Lachs"),
            new Recipe("Auflauf"),
            new Recipe("Thai curry"),
            new Recipe("Indisch"),
            new Recipe("Wirz Pasta"),
            new Recipe("Sandwitch Toast"),
            new Recipe("Käse und Brot"),
            new Recipe("Spaghetti mit Soja und Poulet"),
            new Recipe("Lauch Härdöpfel"),
            new Recipe("Fisch mit Salzhärdöpfel"),
            new Recipe("Linse mit Fladebrot"),
            new Recipe("Omelette"),
            new Recipe("Lemonata"),
            new Recipe("Hörnli mit ghacktem"),
            new Recipe("Cordon Bleue"),
            new Recipe("Lasagne"),
            new Recipe("Teigware mit Pesto"),
            new Recipe("Teigware mit Bolognese"),
            new Recipe("Steak"),
            new Recipe("Riis mit Gmüess"),
            new Recipe("Gfüllti Peperroni"),
            new Recipe("Salade riche"),
            new Recipe("Lachsbrötli"),
            new Recipe("Gnocci Auflauf"),
            new Recipe("Tortellini"),
            new Recipe("Wasser und Brot"),
            new Recipe("Härdöpfelstock"),
            new Recipe("Takeout"),
            new Recipe("mir egal, säg du ¯\\_(ツ)_/¯"),
            new Recipe("Schinkengipfeli"),
            new Recipe("Schawarma"),
            new Recipe("Schnitzelbrot"),
            new Recipe("Ganzes Poulet"),
            new Recipe("Panang Curry"),
            new Recipe("Gmüessgipfeli"),
            new Recipe("Gnocci mit Spinatsauce"),
            new Recipe("Wraps"),
            new Recipe("Pide"),
            new Recipe("Gmüesswähe"),
            new Recipe("Linsensuppe"),
            new Recipe("Piccata"),
            new Recipe("Lauchgratin"),
            new Recipe("Pasta mit Thon-Tomatensauce"),
            new Recipe("Chilli con carne"),
            new Recipe("Shakschukkka")
           )

        ).forEach(System.out::println); 
    }
}
