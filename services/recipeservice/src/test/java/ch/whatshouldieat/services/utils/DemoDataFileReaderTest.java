package ch.whatshouldieat.services.utils;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ch.whatshouldieat.services.recipeservice.model.Recipe;
import ch.whatshouldieat.services.recipeservice.utils.DemoDataFileReader;

public class DemoDataFileReaderTest {

    @Test
    public void readLinesTest(){
  
        String filepath = "src/test/resources/demodata.txt";
        List<Recipe> demoDataList = DemoDataFileReader.readLines(filepath);
        
        assertEquals(demoDataList.size(), 2);
       
        Recipe recipe1 = demoDataList.get(0);
        assertEquals(recipe1.getName(), "Test Item");
        assertEquals(recipe1.getOwnerId(), "100");
        assertEquals(recipe1.getIngredients(), "Milch Brot");
        assertEquals(recipe1.getCookingInstructions(), "Alles vermischen");

        Recipe recipe2 = demoDataList.get(1);
        assertEquals(recipe2.getName(),"Test Item 2");
        assertEquals(recipe1.getOwnerId(), "100");
        assertEquals(recipe2.getIngredients(),"Milch Brot Butter");
        assertEquals(recipe2.getCookingInstructions(),"Alles in einen Topf werfen");      
    }

}
