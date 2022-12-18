# Rotas para produto

[<-- voltar](../../README.md)

### [GET] BUSCA PRODUTOS - /product/{id}
```agsl
curl -X GET \
  http://localhost:8080/product/{id} \
  -H 'Content-Type: application/json'
```
```agsl
curl -X GET \
  http://localhost:8080/product/{id} \
  -H 'Authorization: Bearer <SEU_TOKEN_AQUI>' \
  -H 'Content-Type: application/json'
```

### [GET] BUSCA PRODUTOS - /product
```agsl
curl -X GET \
  http://localhost:8080/product \
  -H 'Content-Type: application/json'
```
```agsl
curl -X GET \
  http://localhost:8080/product \
  -H 'Authorization: Bearer <SEU_TOKEN_AQUI>' \
  -H 'Content-Type: application/json'
```

### [POST] CADASTRA PRODUTO
```agsl
curl -X POST -H "Content-Type: application/json" -d '{
  "productName": "Product name",
  "productPrice": 99.99,
  "productDescription": "Product description"
}' "http://localhost:8080/product"
```
```agsl
curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer <SEU_TOKEN_AQUI>" -d '{
  "productName": "Product name",
  "productPrice": 99.99,
  "productDescription": "Product description"
}' "http://localhost:8080/product"
```

### [PUT] ATUALIZAR PRODUTO
```agsl
curl -X PUT -H "Content-Type: application/json" -d '{ 
  "productId": 1,
  "productName": "Nome do produto",
  "productPrice": 9.99, 
  "productDescription": "Descrição do produto" 
}' http://localhost:8080/product
```
```agsl
curl -X PUT -H "Content-Type: application/json" -H "Authorization: <SEU_TOKEN_AQUI>" -d '{ 
  "productName": "Nome do produto", 
  "productPrice": 9.99, 
  "productDescription": 
  "Descrição do produto" 
}' http://localhost:8080/product
```

### [DELETE] DELETA UM PRODUTO
```agsl
curl -X DELETE http://localhost:8080/product/{id}
```
```agsl
curl -X DELETE -H "Authorization: <SEU_TOKEN_AQUI>" 
http://localhost:8080/product/{id}
```

[<-- voltar](../../README.md)