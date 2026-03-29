package org.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.example.model.HistoricoComparacaoPlanilhas;

public interface HistoricoComparacaoPlanilhasRepository
    extends MongoRepository<HistoricoComparacaoPlanilhas, String> {
}