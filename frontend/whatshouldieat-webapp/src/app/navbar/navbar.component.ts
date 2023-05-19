import { Component, OnDestroy, OnInit } from '@angular/core';
import { RecipeService } from '../shared/recipe.service';
import { AuthService } from '../auth/auth.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy{

  isAuthenticated: boolean;
  authSub: Subscription;

  constructor(private recipeService: RecipeService, private authService: AuthService, private router: Router){
      this.isAuthenticated = false;
  }

  ngOnInit(): void {
    this.authService.isAuthenticated()
      .then((success: boolean) => {
        console.log("is auth"+ success)
        this.isAuthenticated = success;
      }).catch((ex)=>{
        console.log("error with isAuth:"+ ex)
      });
   
    this.authService.authenticationSubject.subscribe((user)=> { 
        if(user != null){
          this.isAuthenticated = true;
          this.fetchData(user);
        }
    });
  }

  fetchData(user:any){
    console.log("user info for fetch data:")
    console.log(user)
    
    this.recipeService.fetchRecipes(user.username).subscribe();
  }

  logout(){
    console.log("logout")
    this.authService.signOut().then(()=> {
      this.isAuthenticated = false;
      this.router.navigate(["/auth"])
    });
  }

  ngOnDestroy(): void {
    this.authSub.unsubscribe();
  }

  

}
