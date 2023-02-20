package com.right.above.livecornercase.endpoint.impl;

import com.right.above.livecornercase.core.api.AnimalService;
import com.right.above.livecornercase.data.dto.AnimalDto;
import com.right.above.livecornercase.endpoint.api.AnimalController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalControllerImpl implements AnimalController {
    private final AnimalService animalService;

    public AnimalControllerImpl(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Override
    public ResponseEntity<?> getAnimals() {
        return ResponseEntity.ok(animalService.getAnimals());
    }

    @Override
    public ResponseEntity<?> storeAnimal(AnimalDto animalDto) {
        return animalService.storeAnimal(animalDto) ? ResponseEntity.status(HttpStatus.ACCEPTED).body("animal stored") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid storage");
    }
}
