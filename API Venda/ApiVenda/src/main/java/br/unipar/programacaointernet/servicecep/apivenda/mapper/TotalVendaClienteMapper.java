package br.unipar.programacaointernet.servicecep.apivenda.mapper;

import br.unipar.programacaointernet.servicecep.apivenda.dto.TotalVendaClienteDTO;
import br.unipar.programacaointernet.servicecep.apivenda.model.Cliente;
import br.unipar.programacaointernet.servicecep.apivenda.model.Venda;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TotalVendaClienteMapper {

    public List<TotalVendaClienteDTO> totalVendaClienteDTOs(List<Cliente> clientes){
        return clientes.stream().filter(Objects::nonNull).map(this::totalVendaClienteDTOs).collect(Collectors.toList());
    }
}
