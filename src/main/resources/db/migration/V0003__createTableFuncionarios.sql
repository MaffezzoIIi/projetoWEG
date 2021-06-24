CREATE TABLE funcionarios(
    numero_cracha BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    cpf VARCHAR(12) NOT NULL,
    usuario_id BIGINT NOT NULL,

    PRIMARY KEY (numero_cracha)
);

ALTER TABLE funcionarios ADD CONSTRAINT fk_funcionarios_usuario
FOREIGN KEY (usuario_id) REFERENCES usuarios (id);