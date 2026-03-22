package org.example.controllers;

import org.example.model.Planilha;
import org.example.service.PlanilhaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
}
