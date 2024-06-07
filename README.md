## 🎯Desafio back-end Alura/ONE(Oracle Next Education T6) Catálogo de livros LiterAlura 

<h2>Bem-vindo a LiterAlura!</h2> 
O Desafio tem como objetivo fazer um catálogo de livros usando a linguagem Java.
O programa tem interação com o usuário via console através de um menu com opções.
Para fazer o catálogo de livros é preciso interagir com a API https://gutendex.com/ e salvar as informações de livros e autores num banco de dados feito em PostgreSQL.
Foi usado a biblioteca Jackson Databind para desserializar o json da API nos modelos de negócio criados no app.</p>

## ✔️ Tecnologias utilizadas:
- Java
- Spring Boot
- Postgres
- Hibernate
- Gutendex API
- Maven
- Jackson Databind
- Spring Data JPA
- Banco de dados PostgreSQL.

## :hammer: Funcionalidades do projeto

A aplicação oferece as seguintes funcionalidades:

- Buscar livro pelo título: Permite ao usuário buscar um livro pelo título e armazená-lo no banco de dados.
- Listar livros registrados: Lista todos os livros registrados no banco de dados.
- Listar autores registrados: Lista todos os autores registrados no banco de dados.
- Listar autores vivos em um ano específico: Lista os autores que estavam vivos em um ano específico e que foram registrados no banco de dados.
- Listar livros em determinado idioma: Lista os livros disponíveis no banco de dados em um idioma específico.
- Listar Top 10 livros mais baixados: Mostra os 10 livros mais baixados no Gutendex.
- Buscar autor: Permite ao usuário buscar informações sobre um autor. Caso o autor não seja encontrado no banco de dados, será realizada uma busca de um livro de sua autoria que será inserido no banco de dados.
- Verificar percentual de livros por idioma: Mostra o percentual de livros no banco de dados em cada idioma.


## 📁 Acesso ao projeto
Você pode [clonar](https://github.com/saranovaes/literAlura.git) ou
[baixar](https://github.com/saranovaes/literAlura/archive/refs/heads/main.zip) os arquivos do projeto.

## 🛠️ Abrir e rodar o projeto

**Para executar este projeto, você precisará de:

- Instale o Java JDK se ainda não estiver instalado. 
- Instale o Maven se ainda não estiver instalado.
- Clone este repositório ou baixe os arquivos para sua máquina local.
- Abra o projeto no IntelliJ IDEA ou outro IDE de sua escolha que suporte Maven.
Instale e configure o PostgreSQL (precisa ter un Banco de Dados com o nome "literalura")
Atualize as configurações no arquivo application.properties. (neste caso tem referencias a variavéis de entorno que vc precisa criar no seu computador)
Execute a classe LiteraluraApplication.java.

## Uso:

Após iniciar o aplicativo, você será apresentado com um menu interativo. Basta selecionar a opção desejada e seguir as instruções.

![image](https://github.com/saranovaes/literAlura/assets/121099160/274ca9a3-f2f9-4116-981a-80e0d19fde1b)



