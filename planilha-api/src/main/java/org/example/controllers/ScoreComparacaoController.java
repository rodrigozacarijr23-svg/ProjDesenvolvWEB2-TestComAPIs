package org.example.controllers;

import java.util.List;

import org.example.model.ScoreComparacao;
import org.example.repository.ScoreComparacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myproject/api/v1/score")
public class ScoreComparacaoController {

    @Autowired
    private ScoreComparacaoRepository scoreRepository;

    @GetMapping
    public List<ScoreComparacao> findAll(){
        return scoreRepository.findAll();
    }
    @GetMapping("/{id}")
        public ScoreComparacao findById(@PathVariable String id){
        return scoreRepository.findById(id).orElse(null);
    }
}