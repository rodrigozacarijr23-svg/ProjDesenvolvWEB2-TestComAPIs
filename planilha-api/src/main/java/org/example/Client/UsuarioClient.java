package org.example.Client;

import org.example.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public Usuario buscarUsuario(String id){
        String url = "http://localhost:8082/myproject/api/v1/usuarios/" + id;
        return restTemplate.getForObject(url, Usuario.class);
    }
}