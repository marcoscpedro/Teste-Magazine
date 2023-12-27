# Teste Magalu Back-end
## Dependências
Para rodar o projeto, é necessario ter instalado as dependencias

* Java 17.0.9 ou superior
* Apache Maven 3.6.3 ou superior

## GitHub
O projeto está no link a baixo do github

https://github.com/marcoscpedro/Teste-Magazine.git

## Iniciar Servidor
Com elas instaladas, você irá rodar o projeto, utilizando qualquer um dos comandos abaixo:
```
mvn clean install

mvn spring-boot:run
```
O comando irá inicializar a aplicação, gerar as tabelas e relacionamentos e também gerar uma seed para alguns iniciais registros.

O projeto irá rodar em localhost:8080/api

## Rodar Carga de Testes
As funcionalidades do projeto foram possuem uma cobertura de testes que podem sem testados por esse comando.
```
./mvnw test
```
## Banco de Dados
Foi usado como banco de dados o MySql, que está rodando nessa imagem Docker que está na raiz do projeto. Para subir a imagem, rode o comando abaixo
```
sudo docker compose up -d
```