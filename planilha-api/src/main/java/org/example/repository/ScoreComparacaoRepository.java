package org.example.repository;

import org.example.model.ScoreComparacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreComparacaoRepository extends MongoRepository<ScoreComparacao, String> {
    
}