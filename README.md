# sorteio

Sistema para realizar sorteio de um veículo, com cadastro de participantes. Usuário administradores podem inserir, listar, editar ou excluir os participantes. Um usuario participantes poderá apenas realizar seu proprio cadastro.

## Instruções de Instalação

1. Clone o repositório: `git clone https://github.com/joaobfigueiredo/sorteio.git`
2. Entre no diretório do projeto: `cd sorteio`
3. Será necessário criar o banco de dados. No arquivo "db.sql" na raiz do projeto temos o script. Instalar MySQL versao 5.7.44(https://dev.mysql.com/downloads/installer ) e executar o arquivo db.sql(https://dev.mysql.com/doc/refman/8.0/en/backup-and-recovery.html).
4. Rodar comando "mvn clean package". Para instalar maven: https://maven.apache.org/install.html 
5. Copiar arquivo "sorteio.war" que foi gerado na pastar "sorteio/target" para a pasta "webapp" do Tomcat 9. Para instalar Tomcat 9: https://tomcat.apache.org/tomcat-9.0-doc/setup.html
