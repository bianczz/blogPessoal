# blogPessoal

# 📝 Blog Pessoal API

Esta é uma API REST robusta desenvolvida com **Spring Boot** para gerenciamento de um blog pessoal. O projeto permite o cadastro de usuários, autenticação (Login) e um sistema completo de CRUD para postagens.

## 🚀 Tecnologias Utilizadas

* **Java** 
* **Spring Boot**
* **Spring Data JPA**: Para persistência de dados.
* **Spring Security**: Para autenticação e autorização.
* **H2 Database / MySQL**: Para Banco de Dados
* **Postman**: Para testes de endpoints.

---

## 🛠️ Funcionalidades (Endpoints)

A API segue o padrão REST e pode ser testada via Postman. Abaixo estão as principais rotas:

### 👤 Usuário & Autenticação

| Método | Endpoint | Descrição |
| --- | --- | --- |
| **POST** | `/usuarios/cadastrar` | Cria uma nova conta no blog. |
| **POST** | `/usuarios/logar` | Autentica o usuário e retorna um Token/Objeto de acesso. |

### ✉️ Postagens (CRUD)

| Método | Endpoint | Descrição |
| --- | --- | --- |
| **GET** | `/postagens` | Lista todas as postagens. |
| **GET** | `/postagens/{id}` | Busca uma postagem específica pelo ID. |
| **POST** | `/postagens` | Cria uma nova postagem (Requer Login). |
| **PUT** | `/postagens` | Edita uma postagem existente. |
| **DELETE** | `/postagens/{id}` | Remove uma postagem permanentemente. |

---

## 🚦 Como Executar o Projeto

1. **Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git

```


2. **Importe o projeto:**
Abra na sua IDE favorita (IntelliJ, Eclipse ou VS Code).
3. **Configure o Banco de Dados:**
Verifique o arquivo `src/main/resources/application.properties` e ajuste as credenciais se necessário.
4. **Execute a aplicação:**
Rode a classe principal `BlogPessoalApplication.java`.
5. **Acesse:**
A API estará rodando em `http://localhost:8080`.

---

## 📮 Testando com Postman

Para testar as funcionalidades, importe as rotas no Postman:

1. Certifique-se de que o servidor está rodando.
2. Para rotas protegidas, utilize o **Bearer Token** recebido no login.
3. No corpo (**Body**) das requisições POST/PUT, utilize o formato JSON:

```json
{
  "titulo": "Meu primeiro post",
  "texto": "Conteúdo da postagem aqui...",
  "tema": { "id": 1 }
}

```

**Gostou dessa estrutura?** Se você quiser, posso te ajudar a escrever a descrição detalhada de um endpoint específico ou criar o arquivo `JSON` de exportação do Postman para você colocar no repositório! Seria útil?
