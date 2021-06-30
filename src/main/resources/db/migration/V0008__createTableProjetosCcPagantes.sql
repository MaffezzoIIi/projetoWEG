CREATE TABLE projetos_ccpagantes(
    id BIGINT NOT NULL AUTO_INCREMENT,
    projeto_id BIGINT NOT NULL,
    ccpagantes_id BIGINT NOT NULL,

    PRIMARY KEY(id)
);

ALTER TABLE projetos_ccpagantes ADD CONSTRAINT fk_projetoid
FOREIGN KEY (projeto_id) REFERENCES projetos(id);

ALTER TABLE projetos_ccpagantes ADD CONSTRAINT fk_ccpagantes
FOREIGN KEY (ccpagantes_id) REFERENCES cc_pagantes(id);

