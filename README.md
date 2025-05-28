# 📝 To-Do List API

API RESTful desenvolvida com Spring Boot para gerenciamento de tarefas (to-do list). Este projeto foi criado com o objetivo de aprendizado e prática da stack Java + Spring, além de compor o portfólio de desenvolvimento backend.

---

## 📌 Funcionalidades

- ✅ Criar uma nova tarefa  
- ✅ Listar todas as tarefas  
- ✅ Buscar uma tarefa por ID  
- ✅ Atualizar uma tarefa existente  
- ✅ Deletar uma tarefa  

---

## 🧰 Tecnologias utilizadas

- Java 17  
- Spring Boot 3.4.4  
- Spring Data JPA  
- MySQL  
- Lombok  
- Swagger / OpenAPI (documentação automática via SpringDoc)  

---

## 🔄 Endpoints

| Método | Endpoint               | Descrição                      |
|--------|------------------------|-------------------------------|
| POST   | `/task/save`           | Cria uma nova tarefa           |
| GET    | `/task/findAll`        | Lista todas as tarefas         |
| GET    | `/task/findById/{id}`  | Busca tarefa pelo ID           |
| PUT    | `/task/update/{id}`    | Atualiza uma tarefa existente  |
| DELETE | `/task/delete/{id}`    | Deleta uma tarefa pelo ID      |

---

## 🚀 Como executar

1. Clone o repositório  
2. Configure as credenciais do banco MySQL no arquivo `application.properties`  
3. Execute a aplicação com o comando:  
   ```bash
   ./mvnw spring-boot:run
4. A API estará disponível em: http://localhost:8080

## 📖 Documentação da API

A documentação interativa está disponível via Swagger UI:
`http://localhost:8080/swagger-ui.html`
   
---

## ⚙️ Pipeline de Integração Contínua (CI)

Este projeto conta com uma pipeline de Integração Contínua configurada no GitHub Actions, que é acionada automaticamente em pushes e pull requests para a branch `main`. A pipeline é dividida em dois jobs principais:

### 1. Testes Automatizados

- Executado em um ambiente Ubuntu com MySQL 8 configurado como serviço.
- A pipeline aguarda o banco de dados MySQL ficar disponível antes de rodar os testes.
- O código é verificado (`checkout`) e o JDK 17 é configurado.
- Em seguida, os testes do projeto são executados utilizando o Maven Wrapper (`./mvnw test`).
- Caso os testes falhem, a pipeline é interrompida, evitando builds inválidos.

### 2. Build e Publicação da Imagem Docker

- Este job depende da conclusão bem-sucedida dos testes.
- Também executado em ambiente Ubuntu, realiza o checkout do código e configura o Docker Buildx para construção multiplataforma (se necessário).
- A imagem Docker é criada com a tag baseada no hash do commit atual.
- A imagem é então publicada no Docker Hub, utilizando as credenciais armazenadas em segredos do GitHub (`DOCKERHUB_TOKEN`).

---

Essa pipeline garante que a aplicação esteja sempre testada e que uma imagem Docker atualizada e confiável esteja disponível para deploys ou uso em ambientes de produção e homologação.
   