# Teste Magazine

APIs com funcionalidades de cadastro de clientes, produtos com controle de estoque e cálculos de custo e lucro, e que possam ser realizadas vendas para esses clientes.

## Índice

- [Pré-requisitos](#pré-requisitos)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Executando o Projeto](#executando-o-projeto)
- [Testes](#testes)
- [Documentação da API](#documentação-da-api)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (Java 11.0.21 ou superior)
- [Maven](https://maven.apache.org/download.cgi) (Apache Maven 3.6.3 ou superior)
- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- [Docker](https://docs.docker.com/engine/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Configuração do Ambiente

1. Clone o repositório:

```bash
git clone https://github.com/marcoscpedro/Teste-Magazine.git
cd Teste-Magazine
```
    

2. Build do Projeto:

```bash
mvn clean install
```    

## Executando o Projeto

1. Foi usado como banco de dados o MySql, que está rodando em uma imagem Docker que está na raiz do projeto. Para subir a imagem, rode o comando abaixo de dentro da pasta do repositório:

```bash
sudo docker compose up -d
```

2. Execute o aplicativo Spring Boot:

```bash
mvn spring-boot:run
```

O comando irá inicializar a aplicação, gerar as tabelas e relacionamentos e também fazer uma carga inicial de dados de clientes e produtos.



3. Acesse o aplicativo em [http://localhost:8080](http://localhost:8080)


## Testes

Para executar os testes, utilize o seguinte comando:

```bash
mvn test
```


## Documentação da API

A documentação da API é gerada automaticamente e pode ser acessada em  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)