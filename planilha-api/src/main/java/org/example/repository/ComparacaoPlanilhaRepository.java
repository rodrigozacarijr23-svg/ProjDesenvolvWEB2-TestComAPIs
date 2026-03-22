package org.example.repository;

import org.example.model.ComparacaoPlanilha;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComparacaoPlanilhaRepository extends MongoRepository<ComparacaoPlanilha, String> {
}