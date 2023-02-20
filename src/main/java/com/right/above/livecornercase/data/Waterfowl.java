package com.right.above.livecornercase.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.right.above.livecornercase.data.enums.AnimalClass;

public class Waterfowl extends Animal {
    @JsonCreator
    public Waterfowl(){
        super(AnimalClass.WATERFOWL);
    }
}

