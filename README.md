# Projeto JDBC com PostgreSQL e JUnit

Este projeto demonstra o uso de JDBC (Java Database Connectivity) para conectar a um banco de dados PostgreSQL, utilizando uma abordagem genérica para manipulação de dados. Além disso, o projeto emprega JUnit para realizar testes automatizados, promovendo boas práticas de programação.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **JPA (Hibernate)**: Para interação com bancos de dados utilizando Java Persistence API.
- **PostgreSQL**: Banco de dados utilizado para armazenamento de dados.
- **JUnit**: Framework para testes automatizados.
- **Generics**: Utilizado para criar métodos e classes reutilizáveis e mais seguros.

## Funcionalidades

- **Conexão com o PostgreSQL**: O projeto faz uso de JPA (Hibernate) para estabelecer a conexão com o banco de dados PostgreSQL.
- **CRUD Genérico**: Utilização de generics para implementar operações de CRUD (Create, Read, Update, Delete) de maneira reutilizável para diferentes tipos de dados.
- **Testes Automatizados com JUnit**: Implementação de testes unitários para garantir o funcionamento correto do código e a qualidade do projeto.

## Como Rodar o Projeto

1. **Configuração do Banco de Dados**:
   - Certifique-se de ter o PostgreSQL instalado e configurado em sua máquina.
   - Crie um banco de dados no PostgreSQL e adicione as credenciais de conexão no arquivo de configuração do projeto.

2. **Instalação das Dependências**:
   - Certifique-se de ter o [Maven](https://maven.apache.org/) ou [Gradle](https://gradle.org/) configurado em seu ambiente de desenvolvimento.
   - Instale as dependências do projeto através do Maven ou Gradle.

   Se estiver usando o Maven, o arquivo `pom.xml` deve conter as dependências necessárias, como o driver JDBC para PostgreSQL e o Hibernate como implementação do JPA.

3. **Compilação e Execução**:
   - Compile e execute o projeto utilizando o Maven ou Gradle.
   - Para rodar os testes, execute o comando do Maven ou Gradle correspondente aos testes unitários.



