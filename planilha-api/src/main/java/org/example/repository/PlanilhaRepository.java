package org.example.repository;

import org.example.model.Planilha;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanilhaRepository extends MongoRepository<Planilha, String> {
}