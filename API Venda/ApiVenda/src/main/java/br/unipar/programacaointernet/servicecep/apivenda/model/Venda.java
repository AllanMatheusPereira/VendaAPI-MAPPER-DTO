package br.unipar.programacaointernet.servicecep.apivenda.model;

import jakarta.ejb.ApplicationException;
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
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal total;

    private String observacoes;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItensVenda> itens = new ArrayList<>();

}
