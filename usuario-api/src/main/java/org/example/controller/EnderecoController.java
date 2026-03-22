// package org.example.controller;

// import org.example.model.Endereco;
// import org.example.service.EnderecoService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;

// @RestController
// public class EnderecoController {
//     @Autowired
//     private EnderecoService enderecoService;

//     @PostMapping("/myproject/api/v1/enderecos")
//     public Endereco save(Endereco endereco){
//         return enderecoService.save(endereco);
//     }
//     @GetMapping("/myproject/api/v1/enderecos")
//     public List<Endereco> findAll(){
//         return enderecoService.findAll();
//     }
// }
