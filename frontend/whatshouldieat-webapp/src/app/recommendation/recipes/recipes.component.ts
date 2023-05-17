import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { Recipe } from 'src/app/shared/recipe.model';
import { RecipeService } from 'src/app/shared/recipe.service';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit, OnDestroy {


  recipes: Recipe[];
  searchText: string = "";
  recipeServiceSub: Subscription;

  constructor(private recipeService: RecipeService){}

  ngOnInit(): void {
    this.recipes = this.recipeService.getRecipes();
    console.log(this.recipes);
    this.recipeServiceSub = this.recipeService.recipesChanged
        .subscribe(
          (recipes : Recipe[]) => {
            console.log("recipes changed!!!");
            this.recipes = recipes;
          } 
        );

  }
  
  addNewRecipe(){
    //TODO this.recipes.push(new Recipe(0,"","","","","",""));
  }

  ngOnDestroy(): void {
      this.recipeServiceSub.unsubscribe();
  }

}
