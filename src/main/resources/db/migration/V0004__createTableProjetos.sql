CREATE TABLE projetos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    numero_do_projeto INT NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    solicitante_id BIGINT NOT NULL,
    responsavel_id BIGINT NOT NULL,
    data_de_inicio VARCHAR(15) NOT NULL,
    data_de_termino VARCHAR(15) NOT NULL,
    data_de_aprovacao VARCHAR(15) NOT NULL,
    status VARCHAR(15) NOT NULL,
    horas_apontadas INT NOT NULL,
    data_do_cadastro TIMESTAMP DEFAULT NOW(),

    PRIMARY KEY(id)
);

ALTER TABLE projetos ADD CONSTRAINT fk_solicitante_projeto
FOREIGN KEY (solicitante_id) REFERENCES funcionarios(id);

ALTER TABLE projetos ADD CONSTRAINT fk_responsavel_projeto
FOREIGN KEY (responsavel_id) REFERENCES funcionarios(id);