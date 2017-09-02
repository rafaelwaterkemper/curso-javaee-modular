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
    public Response findAll() {
        return Response.ok(service.findAll(Usuario.class)).build();
    }

    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") final long id) {
        Usuario usuario = service.findOne(id);
        if (Objects.isNull(usuario)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(usuario).build();
    }

    @POST
    public Response persist(Usuario usuario) {
        service.save(usuario);
        return Response.ok(usuario).status(Response.Status.CREATED).build();
    }
}
