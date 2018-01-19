package com.waterkemper.learnmodularizado.rest.resources;

import com.waterkemper.learnmodularizado.model.Usuario;
import com.waterkemper.learnmodularizado.service.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    private UsuarioService service;

    @GET
    public Response findAll(@DefaultValue("50") @QueryParam("limit") Long limit,
                            @DefaultValue("0") @QueryParam("offset") Long offset,
                            @DefaultValue("") @QueryParam("filter") Long filter,
                            @DefaultValue("+nome") @QueryParam("sort") Long sort) {
        return Response.ok(service.findAll(offset, limit)).build();
    }

    @GET
    @Path("{id}")
    public Response findOne(    @PathParam("id") final long id) {
        Usuario usuario = service.findOne(id);
        if (Objects.isNull(usuario)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(usuario).build();
    }

    @POST
    public Response save(Usuario usuario) {
        service.save(usuario);
        return Response.ok(usuario).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final long id, Usuario usuario) {
        Usuario usuarioFinded = service.findOne(id);

        if (Objects.isNull(usuarioFinded)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("O id passado para atualizar não existe.")
                    .build();
        }

        return Response.ok(service.update(usuario)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final long id) {
        service.remover(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
