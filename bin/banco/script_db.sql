create database lojadb;
use lojadb;

create table cliente(
idcliente int auto_increment primary key,
nomecliente varchar(50) not null,
cpf varchar(13) not null unique,
sexo char(2) not null,
cadastro timestamp default current_timestamp(),
idusuario int not null,
idcontato int not null,
idendereco int not null
)engine InnoDB;

create table funcionario(
idfuncionario int auto_increment primary key,
nomefuncionario varchar(50) not null,
cpf varchar(13) not null unique,
sexo char(2) not null,
cargo varchar(30) not null,
idusuario int not null,
idcontato int not null,
idendereco int not null
)engine InnoDB;

create table usuario(
idusuario int auto_increment primary key,
nomeusuario varchar(30) not null unique,
senha varchar(200) not null,
foto varchar(200) not null
)engine InnoDB;

create table contato(
idcontato int auto_increment primary key,
telefone varchar(20) not null,
email varchar(100) not null unique
)engine InnoDB;

create table endereco(
idendereco int auto_increment primary key,
tipo varchar(10) not null,
logradouro varchar(50) not null,
numero varchar(10) not null,
complemento varchar(30),
cep varchar(10) not null
)engine InnoDB;

create table produto(
idproduto int auto_increment primary key,
nomeproduto varchar(20) not null,
descricao text not null,
preco decimal(10,2) not null,
foto varchar(200)
)engine InnoDB;

create table venda(
idvenda int auto_increment primary key,
idcliente int not null,
idfuncionario int not null,
datavenda timestamp default current_timestamp()
)engine InnoDB;

create table detalhevenda(
iddetalhevenda int auto_increment primary key,
idvenda int not null,
idproduto int not null,
quantidade int not null default 1
)engine InnoDB;





