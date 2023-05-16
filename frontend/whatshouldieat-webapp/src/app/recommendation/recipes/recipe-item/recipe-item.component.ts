import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Recipe } from 'src/app/shared/recipe.model';
import { RecipeService } from 'src/app/shared/recipe.service';

@Component({
  selector: 'app-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.css']
})
export class RecipeItemComponent {

  @Input() recipe: Recipe;
  @ViewChild("modalEditDialog",{static:true}) content:ElementRef;

  ACTION_SAVE: string = "SAVE";
  ACTION_DELETE: string = "DELETE";

  constructor(
    private modalService: NgbModal,
    private recipeService : RecipeService
    ) {}
  
  open(content: any){
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      console.log("res: "+ result)
      switch(result){
        case this.ACTION_SAVE:
          console.log("save - not implemented yet");
         /*   this.recipeService
            .save(this.recipe)
            .subscribe()); */
          break;
        case this.ACTION_DELETE:
          console.log("delete - not implemented yet");
        /*  this.recipeService
          .delete(this.recipe)
          .subscribe(); */
          break;
        case "abort":
        break;
      }
    }, (reason) => {
      console.log(" reason "+reason)
    });
  } 

}
