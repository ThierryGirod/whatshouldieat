import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SuggestComponent } from './recommendation/suggest/suggest.component';
import { AuthComponent } from './auth/auth.component';
import { RecipesComponent } from './recommendation/recipes/recipes.component';
import { TakeoutComponent } from './recommendation/takeout/takeout.component';
import { FridgeComponent } from './recommendation/fridge/fridge.component';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [
  { path : 'suggest', component: SuggestComponent, canActivate: [AuthGuard]},
  { path : 'recipes', component: RecipesComponent, canActivate: [AuthGuard]},
  { path : 'takeout', component: TakeoutComponent, canActivate: [AuthGuard]},
  { path : 'fridge', component: FridgeComponent, canActivate: [AuthGuard]},
  { path : 'auth', component: AuthComponent},
  { path: '', redirectTo: '/suggest', pathMatch: 'full'},
  { path: '**', redirectTo: '/suggest', pathMatch: 'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
