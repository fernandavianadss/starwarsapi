# Star Wars API REST

### Tecnologias usadas:

`Java 11`, `Spring Boot`, `Spring Data`, `Postgres`, `Swagger` e `Heroku`

<h4><b>Informações para uso da API pelo localhost</b></h4>

Para acessar é necessário configurar o servidor do Postgres, criando a base de dados star wars.
No arquivo application.properties do Spring na propriedade spring.profiles.active alterar o valor para dev.

<h4><b>Informações para uso da API pelo Heroku</b></h4>

Para acessar a aplicação na web é necessário acessar o endereço abaixo:
<h5><b>Link da aplicação: https://starwarsapirest.herokuapp.com/swagger-ui.html</b></h5>

<h3><b>Funcionalidades:</b></h3>

* Adicionar um planeta
* Listar planetas
* Buscar por nome
* Buscar por ID
* Remover planeta

<h3><b>EndPoints da API:</b></h3>

<h6><b>Listar os planetas Salvos</b></h6>

```
(GET) http://localhost:8080/planets
```
Lista todos os planetas existentes salvos


<h6><b>Salvar um determinado planeta</b></h6>
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
