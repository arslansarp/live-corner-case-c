package com.right.above.livecornercase.endpoint.api;

import com.right.above.livecornercase.data.dto.AnimalDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/animals")
@CrossOrigin("*")
public interface AnimalController {
    @GetMapping
    ResponseEntity<?> getAnimals();

    @PostMapping
    ResponseEntity storeAnimal(@RequestBody AnimalDto animalDto);
}
