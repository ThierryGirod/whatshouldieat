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
  authServiceSub: Subscription;
  ownerId: string;


  constructor(private recipeService: RecipeService, private authService: AuthService){}

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

    this.authServiceSub = this.authService.authenticationSubject.subscribe((user)=> {
          console.log("suggest user")
          console.log(user);
          this.ownerId = user.username;
        });    

  }
  
  addNewRecipe(){
    //TODO 
    this.recipes.push(new Recipe(null,"",this.ownerId,"","","",""));
  }

  ngOnDestroy(): void {
      this.recipeServiceSub.unsubscribe();
      this.authServiceSub.unsubscribe();
  }

}
