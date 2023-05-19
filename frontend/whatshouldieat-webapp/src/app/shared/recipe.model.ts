export class Recipe{

    constructor(public id: number,
         public name: string,
         public ownerId: string,
         public ingredients: string, 
         public cookingInstructions: string, 
         public imageUrl: string, 
         public additionalInformation: string){}

}