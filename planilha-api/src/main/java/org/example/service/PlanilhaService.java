package org.example.service;

import java.util.List;

import org.example.Client.UsuarioClient;
import org.example.model.Planilha;
import org.example.model.Usuario;
import org.example.repository.PlanilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanilhaService {

    @Autowired
    private PlanilhaRepository planilhaRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public Planilha save(Planilha planilha){
        Usuario usuario = usuarioClient.buscarUsuario(planilha.getUsuarioCadastrado().getId());

        if(usuario == null){
            throw new RuntimeException("Usuário não encontrado");
        }

        planilha.setUsuarioCadastrado(usuario);
        
        return planilhaRepository.save(planilha);
    }

    public List<Planilha> findAll(){
        return planilhaRepository.findAll();
    }
    public Planilha findById(String id){
        return planilhaRepository.findById(id).orElse(null);
    }
}