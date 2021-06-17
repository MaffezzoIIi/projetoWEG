package br.com.projeto.projetoWeg.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProjetoConsultores {

    private long projeto_id;
    private long consultor_id;

}
