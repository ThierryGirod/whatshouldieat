import { Component, OnDestroy, OnInit } from '@angular/core';
import { RecipeService } from '../shared/recipe.service';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy{

  isAuthenticated = false;
  constructor(private recipeService: RecipeService, private authService: AuthService){}

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData(){
    this.recipeService.fetchRecipes().subscribe();
  }

  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }

  

}
