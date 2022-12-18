# Rotas de Catalogos

[<-- voltar](../../README.md)

### [GET] Retorna todos os catalogos
```agsl
curl -X GET http://localhost:8080/catalog
```

### [GET] Retorna um catalogo por ID
```agsl
curl -X GET http://localhost:8080/catalog/{id}
```

### [POST] Cria um catalogo
```agsl
curl -X POST -H "Content-Type: application/json" -d '{ 
  "catalogName": "Nome do catálogo" 
 }' 
http://localhost:8080/catalog/{id}
```

### [POST] Inseri um produto na lista de catalogo
```agsl
curl -X POST -H "Content-Type: application/json" -d '{
  "catalogName": "My Catalog",
  "products": [
    {
      "productId": 1,
      "productName": "Product 1",
      "productPrice": 10.99,
      "productDescription": "This is the first product in my catalog"
    }
  ]
}' http://localhost:8080/catalog

```

### [PUT] Atualiza um catalogo
```agsl
curl -X PUT -H "Content-Type: application/json" -d '{ 
  "catalogId": 1,
  "catalogName": "Nome do catálogo" 
}' 
http://localhost:8080/catalog
```

### [DELETE] Exclui um catalogo por ID
```agsl
curl -X DELETE http://localhost:8080/catalog/{id}
```

[<-- voltar](../../README.md)

