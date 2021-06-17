CREATE TABLE despesas(
    id bigint not null auto_increment,
    projeto_id bigint not null,
    nome varchar(255) not null,
    esforco int not null,
    valor decimal not null,

    PRIMARY KEY (id)
);

ALTER TABLE despesas ADD FOREIGN KEY (projeto_id) REFERENCES projetos(id);
