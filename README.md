# ProjetoWebJAVA

O ProjetoWebJAVA é uma aplicação web desenvolvida em Java, utilizando a arquitetura MVC (Model-View-Controller) para gerenciar projetos de maneira eficiente. O sistema é construído com JSP, servlets e MySQL, proporcionando uma plataforma robusta e escalável para gerenciamento de tarefas, projetos e usuários.


#### Pré-requisitos

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados:

JDK 11 ou superior: Certifique-se de que o Java Development Kit (JDK) esteja instalado e configurado corretamente no seu sistema.

Apache Tomcat: Um servidor de aplicações Java para rodar a aplicação web.

MySQL: Um sistema de gerenciamento de banco de dados relacional para armazenar os dados da aplicação.

Maven: Para gerenciar as dependências do projeto.
Configuração

Clone o repositório

```bash

git clone https://github.com/Parmaxxx/ProjetoWebJAVA.git
cd ProjetoWebJAVA
```
### Configuração do Banco de Dados

Crie um banco de dados MySQL e configure as credenciais no arquivo web.xml localizado em src/main/webapp/WEB-INF.

Importe o script SQL fornecido para criar as tabelas necessárias no banco de dados.

### Configuração do Ambiente

Certifique-se de que o Tomcat esteja instalado e configurado corretamente no seu ambiente.

Configure o Tomcat para usar a versão adequada do JDK.

### Construir o Projeto

Navegue até o diretório do projeto e execute o comando Maven para compilar e empacotar o projeto.

```bash
mvn clean package
Desdobrar a Aplicação
```
Copie o arquivo WAR gerado (target/ProjetoWebJAVA.war) para o diretório de deploy do Tomcat, geralmente localizado em TOMCAT_HOME/webapps.

### Iniciar o Tomcat

Inicie o servidor Tomcat. A aplicação estará disponível em http://localhost:8080/ProjetoWebJAVA.

Utilização
Após a configuração e inicialização do Tomcat, você pode acessar a aplicação web através do navegador.

Use as credenciais padrão fornecidas no documento de configuração para fazer login e começar a usar o sistema de gerenciamento de projetos.


#### Contribuição
Se você deseja contribuir para o desenvolvimento deste projeto, por favor, siga as seguintes etapas:

Fork o repositório.
Crie uma branch para a sua feature (git checkout -b feature/MinhaNovaFeature).
Faça commit das suas alterações (git commit -am 'Adiciona nova feature').
Envie a branch para o repositório remoto (git push origin feature/MinhaNovaFeature).
Abra uma Pull Request no GitHub.
