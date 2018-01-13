package com.waterkemper.learnmodularizado.rest.resources;

import com.mysema.query.types.Predicate;
import com.waterkemper.learnmodularizado.model.Processo;
import com.waterkemper.learnmodularizado.model.QProcesso;
import com.waterkemper.learnmodularizado.service.ProcessoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("processo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProcessoResource {

    @Inject
    private ProcessoService service;

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
        Processo processo = service.findOne(id);
        if (Objects.isNull(processo)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(processo).build();
    }

    @GET
    @Path("cliente/{id}")
    public Response findProcess(@PathParam("id") final long id){
        QProcesso processo = QProcesso.processo;
        Predicate processoPredicate = processo.cliente().id.eq(id);

        List<Processo> processos = service.findAll(processoPredicate);
        return Response.ok(processos).build();
    }

    @POST
    public Response save(Processo processo) {
        service.save(processo);
        return Response.ok(processo).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final long id, Processo processo) {
        Processo processoFinded = service.findOne(id);

        if (Objects.isNull(processoFinded)) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("O id passado para atualizar não existe.")
                    .build();
        }

        return Response.ok(service.update(processo)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final long id) {
        service.remover(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
