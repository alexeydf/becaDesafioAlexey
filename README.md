<h1>🍕 Pizzaria</h1>
API feita para controlar as vendas de uma pizzaria. 

## O que a API vai fazer:
- Cadastro das informações das pizzas: sabor, preço e tipo.
- Cadastro e controle dos clientes.
- Realização e finalização das vendas.
- quantidade de pizzas já adquirido por cada cliente e o valor gasto por ele.

## 🛠 Modelo de Classe
<img src="img/modelo01.png">

## Endpoints
| Requisições              | Descrição                                                           |
|--------------------------|---------------------------------------------------------------------|
| POST  `/pizza`           | Retorna uma nova pizza.                                             |
| PATCH `/pizza/1`         | Retorna as atulizaçõs solicitadas por meio do ID.                   |
| GET `/pizza/1`           | Retorna a pizza solicitada por meio do ID.                          |
| GET `/pizza`             | Retorna todas pizzas registradas.                                   |
| GET `/pizza/sabor/sabor` | Retorna a pizza solicitada por seu sabor.                           |
| DELETE `/pizza/1`        | Exclui a pizza solicitada por ID.                                   |
| POST `/cliente`          | Retorna o cadastro de um novo cliente.                              |
| PATCH `/cliente/1`       | Retorna as atualizaçõs solicitadas por meio do ID.                  |
| GET `/cliente/1`         | Retorna o cliente solicitado por ID.                                |
| GET `/cliente/nome/nome` | Retorna o cliente solicitado pelo nome.                             |
| GET `/cliente`           | Retorna todos os clientes cadastrados.                              |
| DELETE `/cliente/1`      | Exclui o cliente solicitado por ID.                                 |
| POST `/item`             | Retorna um novo item para venda.                                    |
| PATCH `/item/1`          | Retorna as atualizaçãos feitas no item de venda por meio de seu ID. |
| GET `/item/1`            | Retorna o item da venda solicitado por ID.                          |
| GET `/item`              | Retorna todos os itens de venda.                                    |
| DELETE `/item/1`         | Exclui o item da venda por meito do ID.                             |
| POST `/venda`            | Retorna uma nova venda.                                             |
| PATCH `/venda/1`         | Retorna atualizações feitas na venda por meio do ID.                |
| GET `/venda/1`           | Retorna a venda solicitada por ID.                                  |
| GET `/venda`             | Retorna todas as vendas.                                            |
| DELETE `/venda/1`        | Exclui a venda por meio de seu ID.                                  |


## Desafio 01
<p>Neste desafio foi criado a modelagem do projeto. Foi utilizado a ferramenta <a href="https://app.diagrams.net/">draw.oi</a>.</p>
<p>Criação de um projeto Spring Boot. Utilizando a ferramenta <a href="https://start.spring.io/">spring initializr</a></p> 
<p>Implementação de todas as classes citadas no modelo.</p>
<p>Criação de um repositório Git no <a href="https://github.com/">GitHub</a>.</p>

## Desafio 02
<p>Neste desafio foram criados os controllers de nossa API.</p>
<p>Foi implementado o ResponseEntity para manipular as respostas HTTP. Juntamente foi utilizado o <a href="https://www.postman.com/">Postman</a> para a realização dos testes.</p>
<p>Foi criado a documentação da API com base na especificação OpenAPI 3. Para isso foi adicionada a dependência springdoc-openapi-ui ao nosso pom.xml.</p>
