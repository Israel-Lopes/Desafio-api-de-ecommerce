# Rotas de Login e Cadastro

[<-- voltar](../../README.md)

### [POST] CADASTRO DE NOVOS USUARIOS - /registration
```agsl
curl -X POST -H "Content-Type: application/json" -d '{ 
    "registrationName": "Nome de exemplo", 
    "registrationEmail": "exemplo@email.com", 
    "registrationPassword": "senha123"
}' http://localhost:8080/registration
```
- retorna usuario cadastrado

### [POST] FAZER LOGIN - /login
```agsl
curl -X POST -H "Content-Type: application/json" -d '{ 
    "loginEmail": "exemplo@email.com",
    "loginPassword": "senha123"
}' http://localhost:8080/login
```
- retorna token do usuario ao fazer login

[<-- voltar](../../README.md)