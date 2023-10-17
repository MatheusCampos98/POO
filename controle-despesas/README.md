# Controle de despesas

## Objetivo

Com o software de Controle de despesas, oferecemos uma solução para gerenciar os pagamentos de dividas do usuário. Com ele, você pode cadastrar novos débitos, registrar entradas e saídas e realizar consultas e edições de pagamentos de forma eficiente.

## História de Usuário

Como usuário, gostaria de um sistema que faça o cadastro das minhas dividas, salvando todas as entradas que eu cadastro e as saídas. Muitas vezes, precisamos alterar o registro de um débito por conta de uma informação que precisamos atualizar ou foi digitado incorretamente, então será necessário poder alterar os registros cadastrados, mantendo as entradas e saídas do mesmo. Vamos precisar também de uma tela de consulta, para visualizar tudo de uma maneira mais facil. 

## Tecnologias Utilizadas:
* Vaadin;
* MySQL;
* JAVA;

## Criação do Banco:
* CREATE TABLE Despesas (
   <br> CodDesp INT AUTO_INCREMENT,
   <br> Data DATE,
   <br> Desc VARCHAR(500),
   <br> Val DECIMAL(10, 2),
   <br> Cat VARCHAR(50),
   <br> PRIMARY KEY (CodDesp)
);

## Classes:

<img src="images\class.png">


