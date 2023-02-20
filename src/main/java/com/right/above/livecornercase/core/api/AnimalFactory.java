package com.right.above.livecornercase.core.api;

import com.right.above.livecornercase.data.Animal;
import com.right.above.livecornercase.data.enums.AnimalClass;

public interface AnimalFactory {
    Animal createAnimal(AnimalClass animalClass);
}
