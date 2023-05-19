import { Injectable } from '@angular/core';
import { Recipe } from './recipe.model';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, Subject, catchError, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  recipesChanged = new Subject<Recipe[]>();
  private recipes: Recipe[] = [];
  //private foodServiceApiUrl = "http://a7431d5059fd546d0996beadebb96a07-704702806.eu-central-1.elb.amazonaws.com:8080/fooditem";
  private foodServiceApiUrl = "http://localhost:8080/recipe";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

  constructor(private http: HttpClient) { }

  setRecipes(recipes: Recipe[]){
    this.recipes = recipes;
    this.pushUpdate();
  }

  getRecipes(){
    console.log("get Recipes");
    console.log(this.recipes);
    return this.recipes.slice();
  }   

  getRecipe(index: number): Recipe{
      return this.recipes[index];
  }

  pushUpdate(){
    this.recipesChanged.next(this.recipes.slice());
  }

  fetchRecipes(userId: string){
    const userIdParam = userId ? { params: new HttpParams().set('ownerId', userId) } : {};

    return this.http.get<Recipe[]>(this.foodServiceApiUrl,userIdParam)
      .pipe(
        tap(recipes => {
          this.setRecipes(recipes);
        }),
        catchError(this.handleError)
      );
  }

  saveRecipe(recipe: Recipe): Observable<Recipe>{
    console.log("service saved item; "+ recipe.name)
    if(recipe.id != null){
      //update
      const url = `${this.foodServiceApiUrl}/${recipe.id}`; 
      return this.http.put<Recipe>(url , recipe, this.httpOptions)
              .pipe(
                tap(() =>   this.pushUpdate()), //TODO correct?
                catchError(this.handleError)
              );
    }else{
      //create new
        return this.http.post<Recipe>(this.foodServiceApiUrl, recipe, this.httpOptions)
          .pipe(
            catchError(this.handleError)
          );
    }
  }

  deleteRecipe(recipe: Recipe): Observable<unknown>{

      const url = `${this.foodServiceApiUrl}/${recipe.id}`; 
      return this.http.delete(url, this.httpOptions)
              .pipe(
                tap(() =>   this.pushUpdate()), //TODO correct?
                catchError(this.handleError)
              );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }



}
