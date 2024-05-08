package br.unipar.programacaointernet.servicecep.apivenda.service;

import br.unipar.programacaointernet.servicecep.apivenda.dto.QuantidadeVendaDTO;
import br.unipar.programacaointernet.servicecep.apivenda.dto.TotalVendaDTO;
import br.unipar.programacaointernet.servicecep.apivenda.mapper.TotalVendaMapper;
import br.unipar.programacaointernet.servicecep.apivenda.model.ItensVenda;
import br.unipar.programacaointernet.servicecep.apivenda.model.Produto;
import br.unipar.programacaointernet.servicecep.apivenda.model.Venda;
import br.unipar.programacaointernet.servicecep.apivenda.repository.ProdutoRepository;
import br.unipar.programacaointernet.servicecep.apivenda.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class VendaService {

    @Inject
    private VendaRepository vendaRepository;

    public List<Venda> listar() {
        return vendaRepository.listar();
    }

    public Venda buscarPorID(Integer id) {
        return vendaRepository.buscarPorID(id);
    }

    public void cadastrar(Venda venda) throws Exception {
        for (ItensVenda item : venda.getItens()){
            item.setVenda(venda);
        }
        vendaRepository.cadastrar(venda);
    }

    public void atualizar(Venda venda) throws Exception {
        vendaRepository.atualizar(venda);
    }

    public void deletar(Venda venda) throws Exception {
        deletar(venda);
    }

    /*private void deletar(Integer id) throws Exception {
        try {
            vendaRepository.deletar(id);
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar venda: " + ex.getMessage());
        }
    }*/

    public List<TotalVendaDTO> listarTotalVenda() {
        List<Venda> listVendaTotal = vendaRepository.listar();
        return TotalVendaMapper.toDto(listVendaTotal);

    }

//    public List<QuantidadeVendaDTO> quantidadeVenda() throws Exception{
//        return vendaRepository.quantidadeVenda();
//    }
}
