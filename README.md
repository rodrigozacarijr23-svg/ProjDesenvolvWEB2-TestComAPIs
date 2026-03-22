# 📌 ProjDesenvolvWEB2-TestComAPIs

Repositório de **APIs REST em Java com Spring Boot**, com persistência de dados via MongoDB e documentação via Swagger/OpenAPI.  

O projeto contém duas APIs principais:

- **Usuario API** – gerenciamento de usuários  
- **Planilha API** – gerenciamento de dados estruturados (planilhas)

---

## 🧩 Estrutura do Projeto

ProjDesenvolvWEB2-TestComAPIs/
├── usuario-api/              
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/...       # Código fonte Java
│   │   │   └── resources/     # Configurações (application.properties)
│   │   └── test/              # Testes unitários
│   └── pom.xml                
├── planilha-api/              
│   └── ...
├── README.md                 
└── .gitignore

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**  
- **Spring Boot**  
  - Spring Web  
  - Spring Data MongoDB  
- **Maven**  
- **Swagger/OpenAPI**  
- **MongoDB**  

---

## ▶️ Como Rodar

1. Clone o repositório:

git clone https://github.com/rodrigozacarijr23-svg/ProjDesenvolvWEB2-TestComAPIs.git

2. Entre na pasta da API desejada:

cd ProjDesenvolvWEB2-TestComAPIs/usuario-api

3. Configure o MongoDB em `src/main/resources/application.properties`:

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=contadb

4. Rode a aplicação:

mvn clean spring-boot:run

ou

mvn clean package
java -jar target/*.jar

5. Acesse o Swagger UI para testar os endpoints:

http://localhost:8082/swagger-ui/index.html

---

## 🌐 Endpoints – Usuario API

| Método | Caminho | Descrição |
|--------|---------|-----------|
| GET    | /myproject/api/v1/usuarios      | Lista todos os usuários |
| POST   | /myproject/api/v1/usuarios      | Cria novo usuário |
| GET    | /myproject/api/v1/usuarios/{id} | Consulta usuário por ID |
| PUT    | /myproject/api/v1/usuarios/{id} | Atualiza usuário por ID |
| DELETE | /myproject/api/v1/usuarios/{id} | Remove usuário por ID |

**Exemplo de POST (JSON no body):**

{
  "nome": "Rodrigo",
  "telefone": "999999999",
  "endereco": {
    "logradouro": "Rua A",
    "cidade": "Matao",
    "bairro": "Centro",
    "cep": "15990-000",
    "numero": "123"
  }
}

> ⚠️ Sempre envie JSON no corpo da requisição; não use query params para objetos complexos.

---

## 🌐 Endpoints – Planilha API

| Método | Caminho | Descrição |
|--------|---------|-----------|
| GET    | /myproject/api/v1/planilhas   | Lista todas planilhas |
| POST   | /myproject/api/v1/planilhas   | Cria nova planilha |
| GET    | /myproject/api/v1/planilhas/{id} | Consulta planilha por ID |
| PUT    | /myproject/api/v1/planilhas/{id} | Atualiza planilha por ID |
| DELETE | /myproject/api/v1/planilhas/{id} | Remove planilha por ID |

---

## 🧪 Testes

Execute os testes unitários e de integração:

mvn test

---

## 💾 Banco de Dados

Configuração básica MongoDB (`application.properties`):

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=contadb

---

## ⚡ Fluxo de Funcionamento

[Cliente / Swagger] 
        │
        ▼
    POST /usuarios
        │
        ▼
[UsuarioController] → [UsuarioService] → [UsuarioRepository] → [MongoDB]
        │
        ▼
    GET /usuarios

---

## 📜 Licença

Projeto aberto para estudo. Pode ser usado, copiado ou modificado citando autoria.
