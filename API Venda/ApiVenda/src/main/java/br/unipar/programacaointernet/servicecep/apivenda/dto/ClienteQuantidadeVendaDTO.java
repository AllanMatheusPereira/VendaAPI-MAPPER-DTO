package br.unipar.programacaointernet.servicecep.apivenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ClienteQuantidadeVendaDTO {

    private String nome;
    private Long quantidade;
}
