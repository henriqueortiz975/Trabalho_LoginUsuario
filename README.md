
CREATE DATABASE usuarios;
USE usuarios;

CREATE TABLE tb_usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,    
    senha VARCHAR(50) NOT NULL
);

INSERT INTO usuario (nome, email, senha) 
VALUES ('Henrique Ibarra', 'henriqueortiz3090@gmail.com', ‘sla’);

USE usuarios;
CREATE TABLE tb_cliente(
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(50) NOT NULL,
    endereco_cliente VARCHAR(50),
    cidade_cliente VARCHAR(50),
    UF_cliente VARCHAR(50),
    CPF_cliente VARCHAR(50) NOT NULL,
    telefone_cliente VARCHAR(50) NOT NULL,
    data_nasc_cliente VARCHAR(20) NOT NULL
);



