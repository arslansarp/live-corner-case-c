package com.right.above.livecornercase.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.right.above.livecornercase.data.enums.AnimalClass;

public class Amphibian extends Animal {
    @JsonCreator
    public Amphibian() {
        super(AnimalClass.AMPHIBIAN);
    }
}
