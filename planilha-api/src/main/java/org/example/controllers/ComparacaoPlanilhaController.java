package org.example.controllers;

import org.example.model.ComparacaoPlanilha;
import org.example.service.ComparacaoPlanilhaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ComparacaoPlanilhaController {

    @Autowired
    private ComparacaoPlanilhaService comparacaoPlanilhaService;

    @PostMapping("/myproject/api/v1/comparacao-planilha")
    public ComparacaoPlanilha save(@RequestBody ComparacaoPlanilha comparacaoPlanilha){
        return comparacaoPlanilhaService.save(comparacaoPlanilha);
    }

    @GetMapping("/myproject/api/v1/comparacao-planilha")
    public List<ComparacaoPlanilha> findAll(){
        return comparacaoPlanilhaService.findAll();
    }
}