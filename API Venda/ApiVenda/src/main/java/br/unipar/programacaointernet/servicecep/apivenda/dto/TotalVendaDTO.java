package br.unipar.programacaointernet.servicecep.apivenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TotalVendaDTO {

    private String nome;
    private BigDecimal total;
}
