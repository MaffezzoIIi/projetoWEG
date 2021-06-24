CREATE TABLE centros_de_custos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    responsavel_id BIGINT NOT NULL,
    nome VARCHAR(255),

    PRIMARY KEY(id)
);

ALTER TABLE centros_de_custos ADD CONSTRAINT fk_responsavel_centros_de_custos
FOREIGN KEY (responsavel_id) REFERENCES funcionarios(id);