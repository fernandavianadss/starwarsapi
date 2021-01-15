# Star Wars API REST

Tecnologias utilizadas:

*Java 11 *Spring Boot *Spring Data *Postgres

Obs: para executar a API foi utilizada aIDE Spring Tool Suit (STS)

Informações Importantes para uso da API:

Para utilizar a API é necessário configurar o servidor do MongoDB.
Arquivo de configuração application.properties do Spring: spring.data.mongodb.host=localhost spring.data.mongodb.port=27017 spring.data.mongodb.database=b2w

EndPoints da API :

Listar os planetas Salvos : (GET) http://localhost:8080/planetas

Salvar um determinado planteta : (POST) http://localhost:8080/planetas 

Informando um JSON:

{ "name": "Terra", "climate": "tropical", "terrain": "arido" }

Buscar um planeta por id : (GET) http://localhost:8080/planet/{id}

Busca um planeta po nome : (GET) http://localhost:8080/planetas/name/{name}

Remover planeta : (DELETE) http://localhost:8080/planetas/{id}

Consumindo a API pública do Star Wars: https://swapi.dev/about

Ao salvar o planeta, ele se comunica com API do Star Wars, recupera a quantidade de aparições e finaliza o processo de salvar exibindo uma mensagem de que o planeta foi criado com seu id.
