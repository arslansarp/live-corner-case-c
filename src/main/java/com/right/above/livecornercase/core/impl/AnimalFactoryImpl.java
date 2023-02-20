package com.right.above.livecornercase.core.impl;

import com.right.above.livecornercase.core.api.AnimalFactory;
import com.right.above.livecornercase.data.Amphibian;
import com.right.above.livecornercase.data.Animal;
import com.right.above.livecornercase.data.Mammal;
import com.right.above.livecornercase.data.Waterfowl;
import com.right.above.livecornercase.data.enums.AnimalClass;
import org.springframework.stereotype.Component;

@Component
public class AnimalFactoryImpl implements AnimalFactory {
    @Override
    public Animal createAnimal(AnimalClass animalClass) {
        switch (animalClass){
            case MAMMAL -> {
                return new Mammal();
            }
            case AMPHIBIAN -> {
                return new Amphibian();
            }
            case WATERFOWL -> {
                return new Waterfowl();
            }
        }
        return null;
    }
}
