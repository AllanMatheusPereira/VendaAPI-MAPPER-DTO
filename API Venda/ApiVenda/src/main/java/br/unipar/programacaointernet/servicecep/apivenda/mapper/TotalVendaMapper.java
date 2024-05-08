package br.unipar.programacaointernet.servicecep.apivenda.mapper;

import br.unipar.programacaointernet.servicecep.apivenda.dto.QuantidadeVendaDTO;
import br.unipar.programacaointernet.servicecep.apivenda.dto.TotalVendaDTO;
import br.unipar.programacaointernet.servicecep.apivenda.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class TotalVendaMapper {

    public static List<TotalVendaDTO> toDto(List<Venda> vendaList){

        List<TotalVendaDTO> dtoList = new ArrayList<>();

        for (Venda venda : vendaList) {
            TotalVendaDTO dto = new TotalVendaDTO();
            dto.setTotal(venda.getTotal());
            dto.setNome(venda.getCliente().getNome());
            dtoList.add(dto);
        }
        return dtoList;
    }

}
