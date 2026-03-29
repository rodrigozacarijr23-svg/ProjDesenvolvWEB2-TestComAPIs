package org.example.controllers;


import java.util.List;
import org.example.model.HistoricoComparacaoPlanilhas;
import org.example.model.ScoreComparacao;
import org.example.repository.HistoricoComparacaoPlanilhasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myproject/api/v1/historico")
public class HistoricoController {

    @Autowired
    private HistoricoComparacaoPlanilhasRepository historicoRepository;

    @GetMapping
    public List<HistoricoComparacaoPlanilhas> findAll(){
        return historicoRepository.findAll();
    }

    @GetMapping("/{id}")
        public HistoricoComparacaoPlanilhas findById(@PathVariable String id){
        return historicoRepository.findById(id).orElse(null);
    }
}