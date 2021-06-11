ALTER TABLE gerentes ADD FOREIGN KEY (numero_cracha) REFERENCES funcionarios (numero_cracha);

ALTER TABLE projetos ADD FOREIGN KEY (id_envolvidos) REFERENCES envolvidos (id);