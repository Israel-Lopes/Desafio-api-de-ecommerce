# Desafio api de ecommerce

----------------------------
### Configuração do projeto

``Requesitos``

 - Java version 17
 - SpringBoot 2.7.0
 - SDK GraalVM 17.0.5

``mvn compile instaall``


___________________________

### ``Rotas``

1. [rotas de produto](documentation/routes_curl/product.md)
2. [rotas de cadastro/login](documentation/routes_curl/cadastro_login.md)
3. [rotas de catalogo](documentation/routes_curl/catalog.md)
4. [rotas do carrinho](documentation/routes_curl/cart.md)

### ``Regras``

[regras do desafio](documentation/regras_do_desafio.md)

__________________________
## Configuração MySQL

Instalação

``$ sudo apt install mysql-server -y
``

``$ sudo systemctl enable mysql
``

``$ sudo mysql_secure_installation``

<br />

Interrompe mysql

``sudo service mysql stop
``

Incia o mysql

``sudo service mysql start``

Connect to the database as root

``# mysql -u root -p -h localhost
``

Para alterar a senha

``sudo mysqladmin -u root -p password NEW_PASSWORD
``

Create a test database.

``> CREATE DATABASE test_database;
``

Ver o status

``mysqladmin -u root -p status
``

## Criar e configurar Usuario mysql

1. Crie um novo usuário no MySQL com permissões limitadas

``CREATE USER 'usuario_teste'@'localhost' IDENTIFIED BY 'usuario_teste';
``

2. Conceda as permissões apropriadas para o novo usuário.

``GRANT SELECT, INSERT, UPDATE, DELETE ON test_database.* TO 'usuario_teste'@'localhost';
``

3.Atualize os privilégios do MySQL para aplicar as alterações.

``FLUSH PRIVILEGES;
``

## Estrutura do Projeto

```
└── desafioViaSoluti
    └── demo
        ├── DesafioViaSolutiApplication.java
        ├── percistence
        │   └── entity
        │       ├── CartEntity.java
        │       ├── CatalogEntity.java
        │       ├── ProductEntity.java
        │       └── UserEntity.java
        ├── repository
        │   ├── CartRepository.java
        │   ├── CatalogRepository.java
        │   ├── ProductRepository.java
        │   └── UserRepository.java
        ├── service
        │   ├── CartService.java
        │   ├── CatalogService.java
        │   ├── common
        │   │   └── PasswordHasher.java
        │   ├── logfatory
        │   │   └── LogFactory.java
        │   ├── LoginService.java
        │   ├── model
        │   │   ├── Cart.java
        │   │   ├── Catalog.java
        │   │   ├── Login.java
        │   │   ├── Product.java
        │   │   ├── Registration.java
        │   │   └── User.java
        │   ├── ProductService.java
        │   ├── RegistrationService.java
        │   └── token
        │       ├── TokenGenerator.java
        │       └── TokenVerifier.java
        └── web
            ├── controller
            │   ├── CartController.java
            │   ├── CatalogController.java
            │   ├── LoginController.java
            │   ├── ProductController.java
            │   └── RegistrationController.java
            └── mapper
                ├── CartMapper.java
                ├── CatalogMapper.java
                ├── LoginMapper.java
                ├── ProductMapper.java
                ├── RegistrationMapper.java
                └── UserMapper.java
```

### Query 

``USE test_database;
``

```agsl
CREATE TABLE tb_cart (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  product_id INT,
  creation_date DATE,
  FOREIGN KEY (user_id) REFERENCES tb_user(id),
  FOREIGN KEY (product_id) REFERENCES tb_product(id)
);

CREATE TABLE tb_catalog (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  product_id INT,
  FOREIGN KEY (product_id) REFERENCES tb_product(id)
);

CREATE TABLE tb_product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  price DOUBLE,
  description VARCHAR(255) DEFAULT 'Produto não possui descrição'
);

CREATE TABLE tb_user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
  creation_date DATE,
  token VARCHAR(255)
);
```