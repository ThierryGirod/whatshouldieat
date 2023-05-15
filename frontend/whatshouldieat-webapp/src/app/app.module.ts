import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthComponent } from './auth/auth.component';
import { RecipesComponent } from './recommendation/recipes/recipes.component';
import { SuggestComponent } from './recommendation/suggest/suggest.component';
import { FridgeComponent } from './recommendation/fridge/fridge.component';
import { TakeoutComponent } from './recommendation/takeout/takeout.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AuthComponent,
    RecipesComponent,
    SuggestComponent,
    FridgeComponent,
    TakeoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
