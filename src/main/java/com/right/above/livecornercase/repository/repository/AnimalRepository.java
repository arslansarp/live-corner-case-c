package com.right.above.livecornercase.repository.repository;

import com.right.above.livecornercase.repository.document.AnimalDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface AnimalRepository extends MongoRepository<AnimalDocument, String> {
    Optional<AnimalDocument> findFirstByStorage(String storage);
}
