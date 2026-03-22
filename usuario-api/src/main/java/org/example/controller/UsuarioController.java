package org.example.controller;

import org.example.model.Usuario;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/myproject/api/v1/usuarios")
    public Usuario save(Usuario usuario){
        return usuarioService.save(usuario);
    }
    @GetMapping("/myproject/api/v1/usuarios")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }
    @GetMapping("/api/usuario/{id}")
    public Usuario findById(@PathVariable String id){
        return usuarioService.findById(id);
    }
}
