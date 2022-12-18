# Rotas do Carrinho

[<-- voltar](../../README.md)

### [GET] Busca carrinho
```agsl
curl -X GET -H "Authorization: Bearer meu-token" 'http://localhost:8080/cart/{id}'
```

### [POST] Cria um carrinho: O usuario ja e adicionado internamente com a checagem do token
```agsl
curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer <MEU_TOKEN_AQUI>" -d '{
  "products": [
    {
      "productId": 1,
      "productName": "Blusa preta",
      "productPrice": 9999,
      "productDescription": "Product description"
    }
  ]
}' 'http://localhost:8080/cart'
```

### [PUT] Atualiza um carrinho
```agsl
curl -X PUT -H "Content-Type: application/json" -H "Authorization: Bearer <MEU_TOKEN_AQUI>" -d '{
  "field1":"value1", 
  "field2":"value2"
}' 'http://localhost:8080/cart'
```

### [DELETE] Deleta um carrinho
```agsl
curl -X DELETE -H "Authorization: Bearer meu-token" 'http://localhost:8080/cart/{id}'
```

[<-- voltar](../../README.md)
