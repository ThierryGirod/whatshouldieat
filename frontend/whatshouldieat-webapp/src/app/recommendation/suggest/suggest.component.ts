import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { Recipe } from 'src/app/shared/recipe.model';
import { RecipeService } from 'src/app/shared/recipe.service';

@Component({
  selector: 'app-suggest',
  templateUrl: './suggest.component.html',
  styleUrls: ['./suggest.component.css']
})
export class SuggestComponent implements OnInit, OnDestroy {

  userName = "";
  recipeSelected = false;
  recipeChangedSub: Subscription;
  suggestedRecipes: Recipe[];
  recipeSuggestion: Recipe;
  currentSuggestionString: string;
  
  constructor(private recipeService: RecipeService, private authService: AuthService){}

  ngOnInit(): void {
      this.recipeChangedSub = this.recipeService.recipesChanged.subscribe(
        recipes => {
           this.suggestedRecipes = this.recipeService.getRecipes()
           this.suggestRandom();
        }
      );


    this.authService.authenticationSubject.subscribe((user)=> {
      console.log("suggest user")
      console.log(user);
      this.userName = user.attributes.name;
    });    
      
  }

  suggestRandom(){
    
  
    this.recipeSelected = false;
    const randomIndex = Math.floor(Math.random() * this.suggestedRecipes.length);
    
    if(this.suggestedRecipes.length > 0){
      const randomElement = this.suggestedRecipes[randomIndex];
      this.currentSuggestionString = randomElement.name;
      this.recipeSuggestion = randomElement;
      //renove item so it doesn't come up a second time
      this.suggestedRecipes.splice(randomIndex, 1);
      console.log("copy "+this.suggestedRecipes.length);
      console.log(this.suggestedRecipes);
    }else{
      this.currentSuggestionString = "denn weissi au nüm witer.. bstell dr doch eifach öpis!";
    }

  }

  showDetails(){
    this.recipeSelected = true;
  }

  ngOnDestroy(): void {
     this.recipeChangedSub.unsubscribe();
  }

  test(){
    this.recipeService.fetchRecipes().subscribe();
  }
}
