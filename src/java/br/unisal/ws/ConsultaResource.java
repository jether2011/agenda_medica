/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.ws;

import br.unisal.dao.ConsultaDao;
import br.unisal.model.Consulta;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author pensadorx
 */
@Path("consulta")
public class ConsultaResource {

    @Context
    private UriInfo context;
    private ConsultaDao dao;

    /**
     * Creates a new instance of ConsultaResource
     */
    public ConsultaResource() {
    }

    /**
     * Retrieves representation of an instance of br.unisal.ws.ConsultaResource
     *
     * @return an instance of br.unisal.model.Consulta
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConsultas() {
        GenericEntity<List<Consulta>> consultas
                = new GenericEntity<List<Consulta>>(getDao().getAll()) {
                };
        return Response.ok(consultas)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of ConsultaResource
     *
     * @param id
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConsulta(@PathParam("id") Integer id) {
        Consulta p = new Consulta();
        p.setIdConsulta(id);
        return Response.ok(getDao().getById(p))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteConsulta(@PathParam("id") Integer id) {
        Consulta p = new Consulta();
        p.setIdConsulta(id);
        getDao().remove(p);
        String msg = "{\"msg\":\"Exclusão realizada com sucesso!\"}";
        return Response.ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateConsulta(Consulta p, @PathParam("id") Integer id) {
        p.setIdConsulta(id);
        getDao().update(p);
        String msg = "{\"msg\":\"Atualização realizada com sucesso!\"}";
        return Response.ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createConsulta(Consulta p) {
        getDao().insert(p);
        String msg = "{\"msg\":\"Inserção realizada com sucesso!\"}";
        return Response.ok(msg)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();
    }

    public ConsultaDao getDao() {
        if (dao == null) {
            dao = new ConsultaDao();
        }
        return dao;
    }

}
