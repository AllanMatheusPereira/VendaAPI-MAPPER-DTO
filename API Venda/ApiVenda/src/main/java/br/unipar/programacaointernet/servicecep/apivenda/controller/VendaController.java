package br.unipar.programacaointernet.servicecep.apivenda.controller;

import br.unipar.programacaointernet.servicecep.apivenda.model.Venda;
import br.unipar.programacaointernet.servicecep.apivenda.service.ProdutoService;
import br.unipar.programacaointernet.servicecep.apivenda.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Venda")
public class VendaController {

    @Inject
    private VendaService vendaService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarVendas(){return Response.ok(vendaService.listar()).build();}

    @GET
    @Path("/totalVenda")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarTotalVenda(){return Response.ok(vendaService.listarTotalVenda()).build();
    }

//    @GET
//    @Path("/quantidadeVendas")
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response quantidadeVenda(){return Response.ok(VendaService.quantidadeVenda()).build();
//    }


    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response listarVendaPorID(@PathParam("id") Integer id) {
        Venda venda = vendaService.buscarPorID(id);
        if(venda == null)
            return Response.status(204).entity("Venda não encontrada").build();

        return Response.ok(venda).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarVendas(Venda venda){
        try{
            vendaService.cadastrar(venda);
            return Response.status(201).entity("Venda registrada com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizarVenda(Venda venda) {
        try {
            vendaService.atualizar(venda);
            return Response.status(201).entity("Venda atualizada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
    @DELETE
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarVenda(@PathParam("id") Integer id){
        try {
            Venda venda = vendaService.buscarPorID(id);
            if (venda == null) {
                return Response.status(204).entity("Venda não encontrado").build();
            }
            vendaService.deletar(venda);
            return Response.status(200)
                    .entity("Venda excluído com sucesso!")
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
