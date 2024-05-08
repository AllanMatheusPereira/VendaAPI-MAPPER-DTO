package br.unipar.programacaointernet.servicecep.apivenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class ItensVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valor_unitario;

    private BigDecimal valor_total;

    private BigDecimal quantidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    @JsonIgnore
    private Venda venda;

}
