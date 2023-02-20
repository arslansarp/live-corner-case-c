package com.right.above.livecornercase.core.api;


import com.right.above.livecornercase.data.dto.AnimalDto;

import java.util.List;


public interface AnimalService {
    boolean storeAnimal(AnimalDto animalDto);
    List<AnimalDto> getAnimals();
}
