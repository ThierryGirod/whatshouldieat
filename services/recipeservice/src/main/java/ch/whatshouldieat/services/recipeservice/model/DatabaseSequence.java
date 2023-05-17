package ch.whatshouldieat.services.recipeservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private int seq;

}
