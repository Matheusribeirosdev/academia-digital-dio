# Academia Digital - DIO

API REST desenvolvida em Java com Spring Boot para o desafio Academia Digital.

## Tecnologias

- Java 11
- Spring Boot 2.6.1
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Postman

## Funcionalidades

### Alunos

- `POST /alunos` - criar aluno
- `GET /alunos` - listar alunos
- `GET /alunos/{id}` - buscar aluno por ID
- `PUT /alunos/{id}` - atualizar aluno
- `DELETE /alunos/{id}` - excluir aluno

Exemplo de criação:

```json
{
  "nome": "João da Silva",
  "cpf": "98765432100",
  "bairro": "Jardim Camburi",
  "dataDeNascimento": "1990-05-15"
}
```

### Avaliações físicas

- `POST /avaliacoes` - criar avaliação
- `GET /avaliacoes` - listar avaliações
- `GET /avaliacoes/{id}` - buscar avaliação por ID
- `PUT /avaliacoes/{id}` - atualizar avaliação
- `DELETE /avaliacoes/{id}` - excluir avaliação

Exemplo:

```json
{
  "alunoId": 1,
  "peso": 85.5,
  "altura": 1.75
}
```

### Matrículas

- `POST /matriculas` - criar matrícula
- `GET /matriculas` - listar matrículas
- `GET /matriculas/{id}` - buscar matrícula por ID
- `GET /matriculas?bairro=Jardim Camburi` - filtrar matrículas por bairro
- `DELETE /matriculas/{id}` - excluir matrícula

Exemplo:

```json
{
  "alunoId": 1
}
```

## Configuração do banco

Por padrão, a aplicação usa PostgreSQL.

Edite `src/main/resources/application.properties` caso suas credenciais sejam diferentes:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/academia
spring.datasource.username=postgres
spring.datasource.password=postgres
```

Crie o banco antes de iniciar:

```sql
CREATE DATABASE academia;
```

## Executando o projeto

No terminal, na pasta do projeto:

```bash
mvn clean spring-boot:run
```

Ou:

```bash
mvn clean package
java -jar target/academia-digital-0.0.1-SNAPSHOT.jar
```

A API estará disponível em:

```text
http://localhost:8081
```

## Postman

A coleção completa do Postman pode ser importada separadamente:

`Academia-Digital-DIO-Postman-Completo.json`

Ela contém as pastas:

- ALUNOS
- AVALIAÇÕES FÍSICAS
- MATRÍCULAS

## Estrutura

```text
src/main/java/me/dio/academia/digital
├── AcademiaApplication.java
├── controller
├── entity
│   └── form
├── repository
└── service
    └── impl
```

## Observação

O projeto foi organizado para facilitar a execução local, os testes pelo Postman e a publicação no GitHub.
