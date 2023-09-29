# SA3_ShoesHappy
Trabalho escolar apresentado a Disciplina de Desenvolvimento de Sistema.

Este repositório contém uma aplicação web de cadastro de clientes desenvolvida em Java EE, utilizando o servidor Tomcat, Servlets, JSP, a IDE Eclipse, JDBC para integração com o banco de dados MySQL e seguindo o padrão de arquitetura MVC (Model-View-Controller).

# Visão Geral

A aplicação permite a gestão de informações (matrícula, nome, endereço e modalidade) de clientes de uma loja em um banco de dados MySQL , incluindo as seguintes funcionalidades:

Inclusão de novos clientes.
Edição dos dados de clientes existentes.
Exclusão de clientes.
Listagem de todos os clientes cadastrados.

# Requisitos

Para executar esta aplicação em sua máquina, você precisará do seguinte:

Java Development Kit (JDK)
  Java EE com Servlets e JSP
IDE Eclipse (ou outra IDE de sua escolha)
Servidor Apache Tomcat
MySQL Server / Workbench
MySQL Connector/J (Driver JDBC para MySQL)

# Configuração do Ambiente

Para configurar o ambiente de desenvolvimento e execução da aplicação, siga os passos abaixo:

Instale o Servidor Tomcat:
  Baixe e instale o Apache Tomcat.

Configure o Projeto no Eclipse:
  Importe o projeto na IDE Eclipse.

Certifique-se de que o Tomcat está configurado como servidor de aplicação no Eclipse.

Banco de Dados MySQL:
  Instale o MySQL e crie um banco de dados chamado "ShoesHappy" com a tabela "contatos".
  Configure as credenciais de acesso ao banco de dados no arquivo src/main/java/model/DAO.java.

Executando a Aplicação:
  Inicie o servidor Tomcat.
  Inclua a aplicação no servidor Tomcat.

# Estrutura do Projeto

A estrutura do projeto segue o padrão MVC:


src/
├── main/
│   ├── java/
│   │   ├── controller/
│       │   └── ServletControl.java              # Configuração do Servlet
│       ├── model   
│   │        ├── Cliente,java                    # Modelo de dados
│   │        └── DAO.java                        # Configuração do Banco de Dados
│   │                                    
│   └── webapp/
│       ├── WEB-INF/
│       │   └── web.xml
│       ├── scripst/
│       │     ├── confirmador.js                  # Confirmador de exclusão
│       │     └── validador.js                    # Validador de inclusão de dados
│       ├── agenda.jsp                            # página de gerenciamento
│       ├── editar.jsp                            # página de edição 
│       ├── index.html                            # página de acesso
│       ├── novo.html                             # página de inclusão de dados
│       └── style.css                             # configuração do layout

# Uso da Aplicação

Após configurar o ambiente e iniciar a aplicação, você pode acessar a interface web em http://localhost:8080/ShoesHappy
  A partir daí, você pode realizar as seguintes operações:

Listar Clientes: Visualizar a lista de clientes cadastrados.
Adicionar Cliente: Adicionar um novo cliente à lista.
Editar Cliente: Editar os detalhes de um cliente existente.
Excluir Cliente: Remover um cliente da lista.

# Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para melhorar esta aplicação e fazer pull requests.

# Autores

Aldir Newe
Leonardo Sopranzetti Lara
Marcos Vinicius Motta Brugger

# Licença

Este projeto está licenciado sob a [Licença XYZ].


