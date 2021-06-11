CREATE TABLE envolvidos(
    id bigint NOT NULL auto_increment,
    id_responsavel bigint NOT NULL,
    id_solicitante bigint NOT NULL,
    id_aprovador bigint NOT NULL,
    primary key (id)
);
