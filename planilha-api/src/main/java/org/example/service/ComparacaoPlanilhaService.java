package org.example.service;

import java.util.List;

import org.example.model.ComparacaoPlanilha;
import org.example.repository.ComparacaoPlanilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComparacaoPlanilhaService {

    @Autowired
    private ComparacaoPlanilhaRepository comparacaoPlanilhaRepository;

    public ComparacaoPlanilha save(ComparacaoPlanilha comparacaoPlanilha){
        return comparacaoPlanilhaRepository.save(comparacaoPlanilha);
    }

    public List<ComparacaoPlanilha> findAll(){
        return comparacaoPlanilhaRepository.findAll();
    }
}