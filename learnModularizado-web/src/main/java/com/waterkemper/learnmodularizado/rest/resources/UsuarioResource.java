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
    public Response save(Usuario usuario) {
        service.save(usuario);
        return Response.ok(usuario).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final long id, Usuario usuario) {
        Usuario usuarioFinded = service.findOne(id);
        Usuario.Builder.from(usuarioFinded)
                .login(usuario.getLogin())
                .senha(usuario.getSenha())
                .build();
        return Response.ok(service.merge(usuarioFinded)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final long id) {
        service.remove(service.findOne(id));
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
