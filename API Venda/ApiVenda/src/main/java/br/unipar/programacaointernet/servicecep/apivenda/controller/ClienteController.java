package br.unipar.programacaointernet.servicecep.apivenda.controller;

import br.unipar.programacaointernet.servicecep.apivenda.model.Cliente;
import br.unipar.programacaointernet.servicecep.apivenda.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarClientes(){return Response.ok(clienteService.listar()).build();}

    @GET
    @Path("/clientesAniversario")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarClientesAniversario(){return Response.ok(clienteService.listarClienteAniversario()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response listarClientePorID(@PathParam("id") Integer id) {
        Cliente cliente = clienteService.buscarPorID(id);
        if(cliente == null)
            return Response.status(204).entity("Cliente não encontrado").build();

        return Response.ok(cliente).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(Cliente cliente){
        try{
            clienteService.cadastrar(cliente);
            return Response.status(201).entity("Cliente cadatrado com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizarCliente(Cliente cliente) {
        try {
            clienteService.atualizar(cliente);
            return Response.status(201).entity("Cliente atualizado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
    @DELETE
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarCliente(@PathParam("id") Integer id) {
        try {
            Cliente cliente = clienteService.buscarPorID(id);
            if (cliente == null) {
                return Response.status(404).entity("Cliente não encontrado").build();
            }
            clienteService.deletar(cliente);
            return Response.status(200)
                    .entity("Cliente excluído com sucesso!")
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

}
