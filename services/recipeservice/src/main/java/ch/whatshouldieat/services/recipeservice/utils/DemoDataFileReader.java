package ch.whatshouldieat.services.recipeservice.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import ch.whatshouldieat.services.recipeservice.model.Recipe;


public class DemoDataFileReader {

   
    public static List<Recipe> readLines(String filePath){
    
        List<Recipe> demoDataRecipes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {  
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> parts = Arrays.asList(line.split(";"));
                demoDataRecipes.add(new Recipe(parts.get(0), parts.get(1), parts.get(2), parts.get(3)));    
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return demoDataRecipes;
    } 
}
