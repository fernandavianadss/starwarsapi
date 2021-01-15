# Star Wars API REST

### Tecnologias usadas:

`Java 11`, `Spring Boot`, `Spring Data` e `Postgres`

Informações para uso da API:

Para utilizar a API é necessário configurar o servidor do Postgres.
No arquivo application.properties do Spring na propriedade spring.profiles.active=test alterar o valor para dev.

<h3><b>Funcionalidades:</b></h3>

* Adicionar um planeta
* Listar planetas
* Buscar por nome
* Buscar por ID
* Remover planeta

<h3><b>EndPoints da API:</b></h3>

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
