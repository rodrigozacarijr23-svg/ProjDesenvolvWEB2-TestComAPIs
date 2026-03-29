package org.example.controllers;

import org.example.model.Planilha;
import org.example.model.ScoreComparacao;
import org.example.service.PlanilhaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PlanilhaController {

    @Autowired
    private PlanilhaService planilhaService;

    @PostMapping("/myproject/api/v1/planilha")
    public Planilha save(@RequestBody Planilha planilha){
        return planilhaService.save(planilha);
    }

    @GetMapping("/myproject/api/v1/planilha")
    public List<Planilha> findAll(){
        return planilhaService.findAll();
    }

    @GetMapping("/{id}")
        public Planilha findById(@PathVariable String id){
        return planilhaService.findById(id);
    }
}
