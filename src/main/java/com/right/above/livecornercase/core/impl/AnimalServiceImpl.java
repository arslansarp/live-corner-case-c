package com.right.above.livecornercase.core.impl;

import com.right.above.livecornercase.core.api.AnimalFactory;
import com.right.above.livecornercase.core.api.AnimalService;
import com.right.above.livecornercase.data.Animal;
import com.right.above.livecornercase.data.dto.AnimalDto;
import com.right.above.livecornercase.repository.document.AnimalDocument;
import com.right.above.livecornercase.repository.repository.AnimalRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalFactory animalFactory;
    private final Logger logger = LogManager.getLogger(AnimalServiceImpl.class);

    public AnimalServiceImpl(AnimalRepository animalRepository, AnimalFactory animalFactory) {
        this.animalRepository = animalRepository;
        this.animalFactory = animalFactory;
    }

    @Override
    public boolean storeAnimal(AnimalDto animalDto) {
        {
            if (checkIfAnimalTypeSuitable(animalDto)) {
                AnimalDocument animalDocument = new AnimalDocument();
                animalDocument.setType(animalDto.getAnimal().getType());
                animalDocument.setName(animalDto.getAnimal().getName());
                animalDocument.setAnimalClass(animalDto.getAnimal().getAnimalClass());
                animalDocument.setStorage(animalDto.getStorage());
                animalRepository.save(animalDocument);
                logger.info("Animal stored successfully");
                return true;
            }
        }
        logger.error("Wrong storage");
        return false;
    }

    @Override
    public List<AnimalDto> getAnimals() {
        List<AnimalDocument> animalDocuments = animalRepository.findAll();
        return animalDocuments.stream().map(this::convertDocumentToAnimalDTO).toList();
    }

    private AnimalDto convertDocumentToAnimalDTO(AnimalDocument animalDocument) {
        AnimalDto animalDto = new AnimalDto();
        Animal animal = animalFactory.createAnimal(animalDocument.getAnimalClass());
        animal.setName(animalDocument.getName());
        animal.setType(animalDocument.getType());
        animal.setId(animalDocument.getId());
        animalDto.setStorage(animalDocument.getStorage());
        animalDto.setAnimal(animal);
        return animalDto;
    }

    private boolean checkIfAnimalTypeSuitable(AnimalDto animalDto) {
        Optional<AnimalDocument> test = animalRepository.findFirstByStorage(animalDto.getStorage());
        return test.map(animalDocument -> animalDocument.getType().equals(animalDto.getAnimal().getType())).orElse(true);
    }
}
