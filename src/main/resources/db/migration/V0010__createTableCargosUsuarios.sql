CREATE TABLE cargos_usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    usuario_id BIGINT NOT NULL,
    cargo_id BIGINT NOT NULL,

    PRIMARY KEY(id)
);

ALTER TABLE cargos_usuarios ADD CONSTRAINT fk_usuario_id
FOREIGN KEY (usuario_id) REFERENCES usuarios (id);

ALTER TABLE cargos_usuarios ADD CONSTRAINT fk_cargo_id
FOREIGN KEY (cargo_id) REFERENCES cargos (id);