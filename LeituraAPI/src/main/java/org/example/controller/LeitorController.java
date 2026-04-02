package org.example.controller;

import java.util.List;
import java.util.Map;

import org.example.model.Usuario;
import org.example.service.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController // Define que essa classe é um controller REST (retorna JSON)
@RequestMapping("/myproject/api/v1/importacao") // URL base da API
public class LeitorController {

    @Autowired // Injeta automaticamente o service
    private LeitorService service;

    // Endpoint para upload de arquivo Excel
    @PostMapping("/upload")
    public List<Usuario> upload(@RequestParam Map<String, MultipartFile> files) {

        // 1️⃣ Pega o PRIMEIRO arquivo enviado (independente do nome)
        MultipartFile file = files.values().stream().findFirst().orElse(null);

        // 2️⃣ Validação básica (evita erro feio)
        if (file == null || file.isEmpty()) {
            throw new RuntimeException("Nenhum arquivo enviado!");
        }

        // 3️⃣ Lê a planilha e transforma em lista de usuários
        List<Usuario> usuarios = service.ler(file);

        // 4️⃣ Envia esses usuários para a outra API
        service.enviar(usuarios);

        // 5️⃣ Retorna os usuários lidos
        return usuarios;
    }
}