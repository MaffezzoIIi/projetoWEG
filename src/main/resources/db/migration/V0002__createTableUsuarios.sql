CREATE TABLE usuarios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(200) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    cargo_id BIGINT NOT NULL,

    PRIMARY KEY (id)
);

ALTER TABLE usuarios ADD CONSTRAINT fk_usuarios_cargo
FOREIGN KEY (cargo_id) REFERENCES cargos (id);
