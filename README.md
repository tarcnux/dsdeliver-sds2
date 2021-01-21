# Semana [DevSuperior](https://github.com/devsuperior) 2.0
Realizada entre 04 a 10 de janeiro de 2021 (Eu sei tá, eu me atrasei um pouco para concluir)
Projeto desenvolvido com a tutoria de [Nelio Alves](https://github.com/acenelio) no Backend em Java e 
[Washington Soares](https://github.com/washingtonsoares) no Frontend em ReactJs e no Mobile em React Native.

## Repo dsdeliver-sds2
Backend em Java com Springboot, Frontend em ReactJS com Typescript e Mobile em React Native também com Typescript, Banco de Dados Heroku PostgreSQL

Aplicação Web de cadastro de pedidos para entrega de comida. Escreve o endereço já sendo apresentado no mapa em tempo real e seleciona os produtos. 
A aplicação soma os valores de todos os produtos mostrando o total a pagar.

Aplicação Mobile para o entregador acompanhar os pedidos pendentes, localizar a rota do ponto de entrega e confirmar a entrega do pedido.

## API Rest em Java
[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.postman.co/run-collection/ef7d5efef516637ed893)

Backend no Heroku: https://tarcnux-sds2-dsdeliver.herokuapp.com

**Listar Produtos**
----
  Retorna um json com todos os produtos em ordem alfabética.

* **URL**

  [/products](https://tarcnux-sds2-dsdeliver.herokuapp.com/products)

* **Metódo:**

  `GET` 

* **Resposta em caso de sucesso:**

  * **Código:** 200 OK<br />
    **Conteúdo:** 
    ```
    [
    {
        "id": 6,
        "name": "Macarrão Espaguete",
        "price": 35.9,
        "description": "Macarrão fresco espaguete com molho especial e tempero da casa.",
        "imageUri": "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_espaguete.jpg"
    },
    {
        "id": 7,
        "name": "Macarrão Fusili",
        "price": 38.0,
        "description": "Macarrão fusili com toque do chef e especiarias.",
        "imageUri": "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_fusili.jpg"
    }
    ]
    ```

**Listar Pedidos**
----
  Retorna um json com todos os pedidos em ordem do mais antigo no topo.

* **URL**

  [/orders](https://tarcnux-sds2-dsdeliver.herokuapp.com/orders)

* **Method:**

  `GET` 

* **Resposta em caso de sucesso:**

  * **Código:** 200 OK<br />
    **Conteúdo:** 
    ```
       [ 
       {
          id: 6,
          address: "Avenida Paulista, 1500",
          latitude: -23.56168,
          longitude: -46.656139,
          moment: "2021-01-01T14:00:00Z",
          status: "PENDING",
          total: 109.85,
          products: [
              {
                id: 1,
                name: "Pizza Bacon",
                price: 49.9,
                description: "Pizza de bacon com mussarela, orégano, molho especial e tempero da casa.",
                imageUri: "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg"
              },
              {
                id: 5,
                name: "Risoto Funghi",
                price: 59.95,
                description: "Risoto Funghi feito com ingredientes finos e o toque especial do chef.",
                imageUri: "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg"
              }
          ]
        }
        ]
    ```
    

**Cadastrar Pedido**
----
  Cadastra um novo pedido e retorna um json do pedido cadastrado, associado aos produtos selecionados.

* **URL**

  /orders

* **Metódo:**

  `POST`

* **Parâmetros no corpo da requisição**

  ```
  {
      "address": "Av. Primeiro de Maio, 1500",
      "latitude": -23.56168,
      "longitude": -46.656139,    
      "products": [
          {
              "id" : 2
          },
          {
              "id" : 5
          }
      ]
  }
  ```

* **Resposta de sucesso:**

  * **Código:** 201 Created <br />
    **Conteúdo:**
    ```
    {
      "id": 20,
      "address": "Av. Primeiro de Maio, 1500",
      "latitude": -23.56168,
      "longitude": -46.656139,
      "moment": "2021-01-21T05:30:20.326216Z",
      "status": **"PENDING"**,
      "total": 119.85,
      "products": [
          {
              "id": 2,
              "name": "Pizza Moda da Casa",
              "price": 59.9,
              "description": "Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.",
              "imageUri": "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg"
          },
          {
              "id": 5,
              "name": "Risoto Funghi",
              "price": 59.95,
              "description": "Risoto Funghi feito com ingredientes finos e o toque especial do chef.",
              "imageUri": "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg"
          }
      ]
    }
    ```


**Alterar status do pedido**
----
  Altera o status do pedido para entregue

* **URL**

  /orders/:id/delivered

* **Método:**

  `PUT`
  
*  **Parâmetros de URL**

   **Necessário:**
 
   `id=[integer]`

* **Parâmetros no corpo da requisição**

  None

* **Resposta de sucesso:**

  * **Code:** 200 OK<br />
    **Conteúdo:** 
    ```
      {
          "id": 20,
          "address": "Av. Primeiro de Maio, 1500",
          "latitude": -23.56168,
          "longitude": -46.656139,
          "moment": "2021-01-21T05:30:20.326216Z",
          "status": "DELIVERED",
          "total": 119.85,
          "products": [
              {
                  "id": 2,
                  "name": "Pizza Moda da Casa",
                  "price": 59.9,
                  "description": "Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.",
                  "imageUri": "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg"
              },
              {
                  "id": 5,
                  "name": "Risoto Funghi",
                  "price": 59.95,
                  "description": "Risoto Funghi feito com ingredientes finos e o toque especial do chef.",
                  "imageUri": "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg"
              }
          ]
      }
    ```
    
    
## Website
Listar produtos e cadastrar pedidos.
Frontend no Netlify: https://dsdeliver-sds2-tarcnux.netlify.app/
