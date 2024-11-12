# Desafio de Engenheiro de software

Criar um micro serviço que consuma dados de uma fila RabbitMQ e grave os dados para conseguir listar as informações:
Valor total do pedido, quantidade de pedidos por cliente lista de pedidos realizados por cliente. 

## Tecnologias utilizadas:

- Java 21
- Spring Boot
- Spring Data MongoDB
- RabbitMQ
- Docker

## Endpoints disponíveis: 

- http://localhost:8080/customers/{customerId}/orders

## Acessando o RabbitMQ: 

- http://localhost:15672

### Credênciais de acesso do RabbitMQ: 
- guest - para ambos os campos

### Exemplo de body para ser enviado do RabbitMQ:

```
   {
       "codigoPedido": 1001,
       "codigoCliente":1,
       "itens": [
           {
               "produto": "celular",
               "quantidade": 10,
               "preco": 1900.00
           },
           {
               "produto": "mouse",
               "quantidade": 100,
               "preco": 50.00
           }
       ]
   }
```
