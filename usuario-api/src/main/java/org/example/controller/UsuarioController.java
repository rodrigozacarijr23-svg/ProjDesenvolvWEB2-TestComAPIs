package org.example.controller;

import org.example.model.Usuario;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/myproject/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario save(@RequestBody @Valid Usuario usuario){
        System.out.println(usuario.getNome());
        System.out.println(usuario.getTelefone());
        System.out.println(usuario.getEndereco());
        return usuarioService.save(usuario);
    }
    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable String id){
        return usuarioService.findById(id);
    }
}
