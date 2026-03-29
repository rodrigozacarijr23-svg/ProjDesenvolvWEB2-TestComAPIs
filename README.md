# ProjDesenvolvWEB2-TestComAPIs

Projeto de teste de integração com APIs REST para gerenciamento de usuários, planilhas e comparações. Desenvolvido como atividade prática do curso de Desenvolvimento Web 2.

---

## 🔹 Objetivo

- Criar e gerenciar usuários com dados pessoais e endereço.
- Criar planilhas vinculadas a usuários.
- Comparar planilhas, gerando scores e histórico de comparações.
- Testar e consumir APIs REST usando uma interface web intuitiva.

---

## 🔹 Tecnologias Utilizadas

- **Front-end:** HTML, CSS, JavaScript
- **Back-end:** APIs REST (simuladas em servidores locais)
- **Ferramentas:** VS Code para edição de código, GitHub para versionamento

---

## 🔹 Estrutura do Projeto

```
ProjDesenvolvWEB2-TestComAPIs/
│
├─ index.html       # Página principal com interface para testes de API
├─ script.js        # Lógica de interação com APIs
├─ style.css        # Estilos visuais do projeto
└─ README.md        # Documentação do projeto
```

---

## 🔹 Funcionalidades

### Usuário
- Criar usuário com nome, telefone e endereço completo.
- Listar todos os usuários.
- Buscar usuário por ID.

### Planilha
- Criar planilha vinculada a um usuário.
- Listar todas as planilhas.
- Buscar planilha por ID.

### Comparação
- Comparar duas planilhas selecionadas.
- Visualizar histórico e score das comparações.
- Listar histórico e scores completos ou por ID.

---

## 🔹 Visualização dos Resultados

- Resultados podem ser exibidos em **JSON** ou em **formato de tabela legível**.
- Interface com **abas separadas** para criar usuários, planilhas e comparações, mantendo a tela organizada.
- Dados complexos e objetos aninhados são renderizados de forma estruturada e fácil de ler.

Exemplo de saída em formato "tabela legível":

**Usuário 1:**
```
id: 69c955820d20ea3b8131e3b7
nome: Rodrigo
telefone: 16999999999
Endereço:
  logradouro: Rua A
  cidade: Araraquara
  numero: 123
  cep: 14800000
  bairro: Centro
```

---

## 🔹 Como Utilizar

1. Abra o arquivo `index.html` em qualquer navegador moderno.
2. Use as abas para criar usuários, planilhas e comparações.
3. Escolha entre visualização em **JSON** ou **Tabela** para facilitar a leitura dos dados.
4. As ações interagem com os endpoints configurados nas variáveis:

```javascript
const APIUsuarios = "http://localhost:8082/myproject/api/v1";
const APIPlanilhas = "http://localhost:8081/myproject/api/v1";
```

---

## 🔹 Observações

- Certifique-se de que os servidores das APIs estão rodando antes de usar a interface.
- Projeto focado em manipulação de dados JSON aninhados e renderização clara no front-end.
- Código preparado para testes práticos de APIs REST e visualização de resultados complexos.

---

## 🔹 Licença

Projeto destinado a fins educacionais e demonstrativos.