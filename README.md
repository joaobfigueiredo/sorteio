# sorteio

Sistema para realizar sorteio de um veículo, com cadastro de participantes. Usuário administradores podem inserir, listar, editar ou excluir os participantes. Um usuario participantes poderá apenas realizar seu proprio cadastro.

## Instruções de Instalação

1. Clone o repositório: `git clone https://github.com/joaobfigueiredo/sorteio.git`
2. Entre no diretório do projeto: `cd sorteio`
3. Será necessário criar o banco de dados. No arquivo "db.sql" na raiz do projeto temos o script. Instalar MySQL versao 5.7.44(https://dev.mysql.com/downloads/installer ) e executar o arquivo db.sql(https://dev.mysql.com/doc/refman/8.0/en/backup-and-recovery.html).
4. Rodar comando "mvn clean package". Para instalar maven: https://maven.apache.org/install.html 
5. Copiar arquivo "sorteio.war" que foi gerado na pastar "sorteio/target" para a pasta "webapp" do Tomcat 9. Para instalar Tomcat 9: https://tomcat.apache.org/tomcat-9.0-doc/setup.html
6. Executar Tomcat
7. Entrar com a URL http://localhost:8080/ no navegador de preferência;

## Observação sobre usuário administrador

No arquivo db.sql o usuario administrador tem como senha Teste@123 criptrografada.
Se for desejavel a troca dessa senha, basta acessar alguma ferramenta que realiza a criptrografica e atualizar a tabela users com o script a baixo

```sql
update `sorteio`.`users` set  `password` = '[senha criptrografada]' where `username` = 'joao'

Outra opção será incluir um novo usuário administrador, lembrando que é necessário incluir o registro referente ao novo usuário na tabela 'authorities'

```sql
INSERT INTO `sorteio`.`users` (`username`, `enabled`, `password`) VALUES ('[nome do usuario]', b'1', '[senha criptrografada]');
INSERT INTO `sorteio`.`authorities` (`username`, `authority`) VALUES ('[nome do usuario]', 'ROLE_ADM');
