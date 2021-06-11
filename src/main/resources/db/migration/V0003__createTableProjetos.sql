CREATE TABLE projetos (
    id bigint not null auto_increment,
    numero_do_projeto bigint not null,
    titulo varchar(250) not null,
    descricao varchar(500) not null,
    id_envolvidos bigint not null,
    id_cc bigint not null,
    verba_aprovada decimal(10,2) not null,
    limite_de_horas int not null,
    data_de_inicio varchar(10) not null,
    data_de_termino varchar(10) not null,
    data_de_aprovacao varchar(10) not null,
    data_do_cadastro timestamp,
    primary key(id)
);