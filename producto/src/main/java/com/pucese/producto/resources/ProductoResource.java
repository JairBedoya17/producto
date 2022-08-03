package com.pucese.producto.resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.pucese.producto.entities.*;
import com.pucese.producto.repositories.*;

@RequestScoped
@Path("producto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProductoResource {
    
    @Inject//conexion con la capa de datos
    ProductoRepository productoRepository;

    @GET//metodo para mostrar todos
    public Response getAllProducto() {
        return Response.ok().entity(productoRepository.getAllProducto()).build();
    }
    @GET
    @Path("{id}")
    public Response getPostById(@PathParam("id") Long id) {
        return Response.ok().entity(productoRepository.findById(id)).build();
    }
    @POST
    public Response create(producto producto, @Context UriInfo uriInfo) {
    	producto productoId = productoRepository.create(producto);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Long.toString(productoId.getId()));
        return Response.created(builder.build()).build();
    }
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, producto producto) {
    	producto updateProducto = productoRepository.findById(id);

    	updateProducto.setNombre(producto.getNombre());
    	updateProducto.setCantidad(producto.getCantidad());
    	updateProducto.setPrecio(producto.getPrecio());
    	updateProducto.setDisponible(producto.isDisponible());

        return Response.ok().entity(producto).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        producto producto = productoRepository.findById(id);
        productoRepository.delete(producto);
        return Response.noContent().build();
    }
}
