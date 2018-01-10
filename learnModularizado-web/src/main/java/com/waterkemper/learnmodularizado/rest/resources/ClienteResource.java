package com.waterkemper.learnmodularizado.rest.resources;

import com.waterkemper.learnmodularizado.model.Cliente;
import com.waterkemper.learnmodularizado.service.ClienteService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    private ClienteService service;

    @GET
    public Response findAll(@DefaultValue("50") @QueryParam("limit") Long limit,
                            @DefaultValue("0") @QueryParam("offset") Long offset,
                            @DefaultValue("") @QueryParam("filter") Long filter,
                            @DefaultValue("+nome") @QueryParam("sort") Long sort) {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") final long id) {
        Cliente cliente = service.findOne(id);
        if (Objects.isNull(cliente)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(cliente).build();
    }

    @POST
    public Response save(Cliente cliente) {
        service.save(cliente);
        return Response.ok(cliente).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final long id, Cliente cliente) {
        Cliente clienteFinded = service.findOne(id);

        if (Objects.isNull(clienteFinded)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("O id passado para atualizar não existe.")
                    .build();
        }

        return Response.ok(service.update(cliente)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final long id) {
        service.remover(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
