CREATE TABLE projetos (
    id bigint not null auto_increment,
    numero_do_projeto bigint not null,
    titulo varchar(250) not null,
    descricao varchar(500) not null,
    responsavel_id bigint not null,
    solicitante_id bigint not null,
    status VARCHAR(20),
    horas_apontadas int,
    data_de_inicio varchar(10) not null,
    data_de_termino varchar(10) not null,
    data_de_aprovacao varchar(10) not null,
    data_do_cadastro timestamp,
    primary key(id)
);