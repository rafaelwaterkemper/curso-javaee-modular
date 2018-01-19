package com.waterkemper.learnmodularizado.rest.resources;

import com.waterkemper.learnmodularizado.model.Pessoa;
import com.waterkemper.learnmodularizado.service.PessoaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("pessoa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    private PessoaService service;

    @GET
    public Response findAll(@DefaultValue("50") @QueryParam("limit") Long limit,
                            @DefaultValue("0") @QueryParam("offset") Long offset,
                            @DefaultValue("") @QueryParam("filter") String filter,
                            @DefaultValue("+nome") @QueryParam("sort") Long sort) {
        return Response.ok(service.findAll(offset, limit, filter)).build();
    }

    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") final long id) {
        Pessoa pessoa = service.findOne(id);
        if (Objects.isNull(pessoa)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(pessoa).build();
    }

    @POST
    public Response save(Pessoa pessoa) {
        service.save(pessoa);
        return Response.ok(pessoa).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final long id, Pessoa pessoa) {
        Pessoa pessoaFinded = service.findOne(id);

        if (Objects.isNull(pessoaFinded)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("O id passado para atualizar não existe.")
                    .build();
        }

        return Response.ok(service.update(pessoa)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final long id) {
        service.remover(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
