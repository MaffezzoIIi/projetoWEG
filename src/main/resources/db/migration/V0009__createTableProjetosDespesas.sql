CREATE TABLE projetos_despesas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    projeto_id BIGINT NOT NULL,
    despesas_id BIGINT NOT NULL,

    PRIMARY KEY(id)
);

ALTER TABLE projetos_despesas ADD CONSTRAINT fk_projetoid
FOREIGN KEY (projeto_id) REFERENCES projetos(id);

ALTER TABLE projetos_despesas ADD CONSTRAINT fk_despesas
FOREIGN KEY (despesas_id) REFERENCES despesas(id);