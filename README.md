# 📊 Sistema de Importação e Comparação de Planilhas com API de Usuários

## 🚀 Sobre o Projeto

Este projeto consiste em um sistema completo que permite:

* 📥 Upload de planilhas Excel
* 🔄 Conversão automática para JSON
* 👤 Criação de usuários em massa via API
* 📊 Visualização dos dados em tabela e JSON
* 🔗 Integração entre múltiplas APIs

O sistema foi desenvolvido com foco em simular um cenário real de aplicações empresariais, onde dados precisam ser importados, tratados e persistidos de forma automatizada.

---

## 🛠️ Tecnologias Utilizadas

### Backend

* Java + Spring Boot
* Maven
* REST API

### Frontend

* HTML5
* CSS3
* JavaScript (Fetch API)

---

## 📂 Estrutura do Projeto

```
📁 Projeto
 ├── 📁 Front-Test
 │    ├── Index.html
 │    ├── Script.js
 │    └── style.css
 │
 ├── 📁 LeituraAPI
 │    ├── controller
 │    ├── service
 │    ├── repository
 │    ├── model
 │    └── config
```

---

## ⚙️ Como Executar o Projeto

### 🔹 Backend (Spring Boot)

```bash
cd LeituraAPI
mvn spring-boot:run
```

A API será iniciada em:

```
http://localhost:8080
```

---

### 🔹 Frontend

Basta abrir o arquivo:

```
Front-Test/Index.html
```

---

## 📡 Endpoints da API

### 📥 Upload de Planilha

```
POST /myproject/api/v1/importacao/upload
```

#### 🧾 Form-data:

| Key  | Tipo |
| ---- | ---- |
| file | File |

---

### 👤 Criar Usuário

```
POST /myproject/api/v1/usuarios
```

#### 📥 Exemplo de JSON:

```json
{
  "nome": "Rodrigo",
  "telefone": "16999999999",
  "endereco": {
    "logradouro": "Rua A",
    "cidade": "Araraquara",
    "numero": "123",
    "cep": "14800000",
    "bairro": "Centro"
  }
}
```

---

### 📋 Buscar Usuários

```
GET /myproject/api/v1/usuarios
```

---

### 🔍 Buscar por ID

```
GET /myproject/api/v1/usuarios/{id}
```

---

## 📊 Formato da Planilha

A planilha deve seguir exatamente este padrão:

| Nome    | Telefone    | Logradouro | Cidade      | Numero | CEP      | Bairro |
| ------- | ----------- | ---------- | ----------- | ------ | -------- | ------ |
| Rodrigo | 16999999999 | Rua A      | Araraquara  | 123    | 14800000 | Centro |
| Danilo  | 16999999999 | Rua B      | Matão       | 456    | 14800000 | Centro |
| Felipe  | 16999999999 | Rua C      | Jaboticabal | 789    | 14800000 | Centro |

### ⚠️ Regras importantes:

* A primeira linha deve conter os nomes das colunas
* Não deixar linhas vazias no meio
* Seguir a ordem das colunas
* Arquivo deve ser `.xlsx`

---

## 🔄 Fluxo do Sistema

1. Usuário envia uma planilha pelo frontend
2. API de leitura processa o arquivo
3. Dados são convertidos para objetos `Usuario`
4. API envia os dados para o endpoint de usuários
5. Usuários são salvos no sistema
6. Resultado é exibido em JSON e tabela

---

## 🧪 Testando com Swagger / Postman

### 📥 Upload de arquivo

* Método: `POST`
* URL: `http://localhost:8080/myproject/api/v1/importacao/upload`
* Body: `form-data`
* Key: `file`
* Tipo: File

---

### 👤 Criar usuário manual

```json
{
  "nome": "Teste",
  "telefone": "16988888888",
  "endereco": {
    "logradouro": "Rua Teste",
    "cidade": "São Paulo",
    "numero": "999",
    "cep": "01000000",
    "bairro": "Centro"
  }
}
```

---

## ⚠️ Problemas Comuns

### ❌ API não responde

✔ Verifique se o backend está rodando

---

### ❌ Erro CORS

✔ Verifique configuração de CORS no backend

---

### ❌ Apenas 1 linha sendo lida

✔ Verifique se há linhas vazias na planilha

---

### ❌ Erro ao enviar arquivo

✔ Confirme que o campo no form-data se chama `file`

---

## 🔥 Melhorias Futuras

* ✔ Validação de dados da planilha
* ✔ Tratamento de erros mais robusto
* ✔ Interface com feedback visual (loading)
* ✔ Upload múltiplo de arquivos
* ✔ Autenticação de usuários

---

## 👨‍💻 Autor

Desenvolvido por Rodrigo Cesar Zacari Junior

---

## 📌 Observações

Este projeto foi desenvolvido para fins acadêmicos, com foco em aprendizado prático de:

* Integração entre sistemas
* Manipulação de arquivos
* APIs REST
* Estruturação de aplicações Spring Boot

---
