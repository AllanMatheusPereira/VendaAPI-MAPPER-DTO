package br.unipar.programacaointernet.servicecep.apivenda.mapper;

import br.unipar.programacaointernet.servicecep.apivenda.dto.QuantidadeVendaDTO;
import br.unipar.programacaointernet.servicecep.apivenda.dto.TotalVendaDTO;
import br.unipar.programacaointernet.servicecep.apivenda.model.ItensVenda;
import br.unipar.programacaointernet.servicecep.apivenda.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class QuantidadeVendaMapper {

    public static List<QuantidadeVendaDTO> toDto(List<ItensVenda> itensVendaList){

        List<QuantidadeVendaDTO> dtoList = new ArrayList<>();

        for (ItensVenda itensVenda : itensVendaList) {
            QuantidadeVendaDTO dto = new QuantidadeVendaDTO();
            dto.setQuantidade(itensVenda.getQuantidade());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
