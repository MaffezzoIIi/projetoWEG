CREATE TABLE cc_pagantes(
    centro_de_custo_id BIGINT NOT NULL,
    percentual INT NOT NULL,
    valor DOUBLE NOT NULL
);

ALTER TABLE cc_pagantes ADD CONSTRAINT fk_centro_de_custo
FOREIGN KEY (centro_de_custo_id) REFERENCES centros_de_custos(id);

