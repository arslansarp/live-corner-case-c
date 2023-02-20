package com.right.above.livecornercase.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.right.above.livecornercase.data.enums.AnimalClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "animalClass")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Mammal.class, name = "MAMMAL"),
        @JsonSubTypes.Type(value = Waterfowl.class, name = "WATERFOWL"),
        @JsonSubTypes.Type(value = Amphibian.class, name = "AMPHIBIAN")
})
public class Animal {
    private String name;
    private String id;
    private AnimalClass animalClass;
    private String type;

    public Animal(AnimalClass animalClass){
        this.animalClass = animalClass;
    }
}
