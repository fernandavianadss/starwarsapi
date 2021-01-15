# Star Wars API REST

### Tecnologias usadas:

`Java 11`, `Spring Boot`, `Spring Data`, `Postgres`, `Swagger` e `Heroku`

Informações para uso da API pelo localhost:

Para acessar é necessário configurar o servidor do Postgres, criando a base de dados star wars.
No arquivo application.properties do Spring na propriedade spring.profiles.active alterar o valor para dev.

Informações para uso da API pelo Heroku:

Para acessar a aplicação na web é necessário acessar o endereço abaixo:
<h3><b>Link da aplicação: https://starwarsapirest.herokuapp.com/swagger-ui.html</b></h3>

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
Lista todos os planetas existentes salvos


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

Ao salvar um planeta, ele se comunica com API do Star Wars, recupera a quantidade de aparições e finaliza o processo de salvar exibindo uma mensagem de que o planeta foi criado com seu id respectivo.


Buscar um planeta por id : 

```
(GET) http://localhost:8080/planets/{id}
```

Ao buscar um planeta informando seu id único, em caso de sucesso é retornado os dados do planeta, caso não encontre é informada a mensagem de que o planeta não foi encontrado.

Busca um planeta po nome : 

```
(GET) http://localhost:8080/planets/name/{name}
```
Ao buscar um planeta informando seu nome, em caso de sucesso é retornado os dados do planeta, caso não encontre é informada a mensagem de que o planeta não foi encontrado.

Remover planeta : 
```
(DELETE) http://localhost:8080/planets/{id}
```
Ao informar o id do planeta para removoção, em caso de sucesso é finalizado a ação, caso não encontre é informada uma mensagem de que o planeta não foi encontrado.

<h3><b>API pública utilizada: https://swapi.dev/about</b></h3>
