<h1>🍕 Pizzaria</h1>
API feita para controlar as vendas de uma pizzaria. 

## O que a API vai fazer:
- Cadastro das informações das pizzas: sabor, preço e tipo.
- Cadastro e controle dos clientes.
- Realização e finalização das vendas.
- quantidade de pizzas já adquirido por cada cliente e o valor gasto por ele.

## 🛠 Modelo de Classe
<img src="img/modelo01.png">

## Desafio 01
<p>Neste desafio foi criado a modelagem do projeto. Foi utilizado a ferramenta <a href="https://app.diagrams.net/">draw.oi</a>.</p>
<p>Criação de um projeto Spring Boot. Utilizando a ferramenta <a href="https://start.spring.io/">spring initializr</a></p> 
<p>Implementação de todas as classes citadas no modelo.</p>
<p>Criação de um repositório Git no <a href="https://github.com/">GitHub</a>.</p>

## Desafio 02
<p>Neste desafio foram criados os controllers de nossa API.</p>
<p>Foi implementado o ResponseEntity para manipular as respostas HTTP. Juntamente foi utilizado o <a href="https://www.postman.com/">Postman</a> para a realização dos testes.</p>
<p>Foi criado a documentação da API com base na especificação OpenAPI 3. Para isso foi adicionada a dependência <b><i>springdoc-openapi-ui</i></b> ao nosso pom.xml.</p>

## Desafio 03
<p>Neste desafio criamos as classes Services de nossa API, que foi integrado com as classes Controllers.</p>
<p>Foi criado uma interface onde foram criados métodos para a realização do CRUD.</p>

## Desafio 04
<p>Neste desafio foram criadas as classes de repository de nossa API. Essas classes são utilizadas para salvar, editar, listar e excluir os dados em nosso banco. Implementamos as classes repository em nossa classa service.</p>
<p>Configuramos o banco de dados H2 em nossa API. Para isso adicionamos as dependências <b><i>h2</i></b> e <b><i>spring-boot-starter-data-jpa</i></b> em nosso arquivo pom.xml.</p>
