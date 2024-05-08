package br.unipar.programacaointernet.servicecep.apivenda.mapper;

import br.unipar.programacaointernet.servicecep.apivenda.dto.NomeTelefoneAniversarioClienteDTO;
import br.unipar.programacaointernet.servicecep.apivenda.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class NomeTelefoneAniversarioClienteMapper {

    public static List<NomeTelefoneAniversarioClienteDTO> toDTO(List<Cliente> clienteList) {

        List<NomeTelefoneAniversarioClienteDTO> dtoList = new ArrayList<>();

        for (Cliente cliente : clienteList) {
            NomeTelefoneAniversarioClienteDTO dto =
                    new NomeTelefoneAniversarioClienteDTO();
            dto.setNome(cliente.getNome());
            dto.setTelefone(cliente.getTelefone());
            dto.setAniversario(cliente.getAniversario());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
