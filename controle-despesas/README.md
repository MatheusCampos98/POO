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
    CodDesp INT AUTO_INCREMENT,
    Data DATE,
    Desc VARCHAR(500),
    Val DECIMAL(10, 2),
    Cat VARCHAR(50),
    PRIMARY KEY (CodDesp)
);

## Classes:


