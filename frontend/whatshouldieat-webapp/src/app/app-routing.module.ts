import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SuggestComponent } from './recommendation/suggest/suggest.component';
import { AuthComponent } from './auth/auth.component';
import { RecipesComponent } from './recommendation/recipes/recipes.component';
import { TakeoutComponent } from './recommendation/takeout/takeout.component';
import { FridgeComponent } from './recommendation/fridge/fridge.component';

const routes: Routes = [
  { path : 'suggest', component: SuggestComponent},
  { path : 'recipes', component: RecipesComponent},
  { path : 'takeout', component: TakeoutComponent},
  { path : 'fridge', component: FridgeComponent},
  { path : 'auth', component: AuthComponent},
  { path: '', redirectTo: '/auth', pathMatch: 'full'},
  { path: '**', redirectTo: '/auth', pathMatch: 'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
