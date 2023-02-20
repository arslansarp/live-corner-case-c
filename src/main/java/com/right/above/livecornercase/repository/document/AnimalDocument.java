package com.right.above.livecornercase.repository.document;

import com.right.above.livecornercase.data.enums.AnimalClass;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "animals")
@Data
public class AnimalDocument {
    @Id
    private String id;
    private String name;
    private AnimalClass animalClass;
    private String type;
    private String storage;
}
