package com.demo2.orm.dao;

import com.demo2.orm.model.Product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class ProductDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Product product) {
        System.out.println("persist:" + product);
        em.persist(product);
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p")
                .getResultList();
    }
}
