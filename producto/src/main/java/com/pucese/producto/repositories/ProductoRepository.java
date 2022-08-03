package com.pucese.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pucese.entities.producto;
import java.util.List;

public class ProductoRepository {

    @PersistenceContext(unitName = "myProducto_PU")
    EntityManager em;
    
    public List getAllProducto() {
        return em.createNamedQuery("producto.findAll", producto.class).getResultList();
    }

    public producto findById(Long id) {
        return em.find(producto.class, id);
    }

    public producto create(producto producto) {
        em.persist(producto);
        return producto;
    }

    public void update(producto producto) {
        em.merge(producto);
    }

    public void delete(producto producto) {
        if (!em.contains(producto)) {
        	producto = em.merge(producto);
        }

        em.remove(producto);
    }
}

