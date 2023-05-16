import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthComponent } from './auth/auth.component';
import { RecipesComponent } from './recommendation/recipes/recipes.component';
import { SuggestComponent } from './recommendation/suggest/suggest.component';
import { FridgeComponent } from './recommendation/fridge/fridge.component';
import { TakeoutComponent } from './recommendation/takeout/takeout.component';
import { RecipeItemComponent } from './recommendation/recipes/recipe-item/recipe-item.component';
import { FilterPipe } from './shared/filter.pipe';
import { FormsModule } from '@angular/forms';
import { LoadingSpinnerComponent } from './shared/loading-spinner/loading-spinner.component';
import { AuthInterceptorService } from './auth/auth-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AuthComponent,
    RecipesComponent,
    SuggestComponent,
    FridgeComponent,
    TakeoutComponent,
    RecipeItemComponent,
    FilterPipe,
    LoadingSpinnerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [
    {
      provide:
      HTTP_INTERCEPTORS, 
      useClass: AuthInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
