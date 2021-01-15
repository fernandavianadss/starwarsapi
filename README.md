# Star Wars API REST

### Tecnologias usadas:

`Java 11`, `Spring Boot`, `Spring Data` e `Postgres`

Obs: para executar a API foi utilizada aIDE Spring Tool Suit (STS)

Informações Importantes para uso da API:

Para utilizar a API é necessário configurar o servidor do MongoDB.
Arquivo de configuração application.properties do Spring: spring.data.mongodb.host=localhost spring.data.mongodb.port=27017 spring.data.mongodb.database=b2w

<h3><b>Funcionalidades:</b></h3>

Adicionar um planeta (com name, climate e terrain)
Listar planetas
Buscar por nome
Buscar por ID
Remover planeta

EndPoints da API :

Listar os planetas Salvos : 

```
(GET) http://localhost:8080/planets
```

Salvar um determinado planeta : 
```
(POST) http://localhost:8080/planets 
```

```
{
  "name": "string",
  "climate": "string",
  "terrain": "string"
}
```

Buscar um planeta por id : 

```
(GET) http://localhost:8080/planets/{id}
```

Busca um planeta po nome : 

```
(GET) http://localhost:8080/planets/name/{name}
```

Remover planeta : 
```
(DELETE) http://localhost:8080/planets/{id}
```

Consumindo a API pública do Star Wars: https://swapi.dev/about

Ao salvar o planeta, ele se comunica com API do Star Wars, recupera a quantidade de aparições e finaliza o processo de salvar exibindo uma mensagem de que o planeta foi criado com seu id.
