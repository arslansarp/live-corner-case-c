package com.right.above.livecornercase.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.right.above.livecornercase.data.enums.AnimalClass;

public class Mammal extends Animal {
    @JsonCreator
    public Mammal(){
        super(AnimalClass.MAMMAL);
    }
}
