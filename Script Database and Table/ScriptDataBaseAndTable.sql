Create database Geral;

Use database Geral;

Create table Produto(
  id int not null primary key auto_increment,
  nome varchar(50),
  descricao varchar(255),
  valor double,
  unidade int
)
