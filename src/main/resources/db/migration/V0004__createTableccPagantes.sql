CREATE TABLE ccPagantes (
    cc_id bigint not null auto_increment,
    projeto_id bigint not null,
    responsavel_id bigint not null,
    percentual decimal not null,
    valor decimal not null,

    PRIMARY KEY(cc_id)
);

ALTER TABLE ccPagantes ADD FOREIGN KEY (projeto_id) REFERENCES projetos(id);
ALTER TABLE ccPagantes ADD FOREIGN KEY (responsavel_id) REFERENCES funcionarios(numero_cracha);