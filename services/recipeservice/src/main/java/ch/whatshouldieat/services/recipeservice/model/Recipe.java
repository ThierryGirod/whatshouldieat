package ch.whatshouldieat.services.recipeservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Document(collection = "recipes")
public class Recipe {

    @Transient
    public static final String SEQUENCE_NAME = "recipe_sequence";

    @Id
    @Getter
    @Setter
    private long id;
    
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String ownerId;

    @Getter
    @Setter
    private String ingredients = "n/a";

    @Getter
    @Setter
    private String cookingInstructions = "n/a";

    @Getter
    @Setter
    private String imageUrl = "";

    @Getter
    @Setter
    private String additionalInformation = "";

    public Recipe(){};

    public Recipe(String name){
        this.name = name;
    }

    public Recipe(String name, String ingredients, String cookingInstructions){
        this.name = name;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
    }

    public String toString(){
        return this.id + " " + this.name;
    }
}
