/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntityProducts;
import com.inventory.aset.entity.EntityStock;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityStockFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityStockFacade extends AbstractFacade<EntityStock> implements EntityStockFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityStockFacade() {
        super(EntityStock.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createStock(EntityStock dataStock) {
        em.persist(dataStock);
    }

    @Override
    public void updateStock(EntityStock dataStock) {
        em.merge(dataStock);
    }

    @Override
    public void deleteStock(EntityStock dataStock) {
        em.merge(dataStock);
    }

    @Override
    public void removeStock(long paramLong) {
        em.remove(getStock(paramLong));
    }

    @Override
    public EntityStock getStock(long idStock) {
        return (EntityStock) em.find(EntityStock.class, idStock);
    }

    @Override
    public List<EntityStock> getAllStock(int max, int start) {
//        return em.createNamedQuery("EntityStock.findAll").getResultList();
        return em.createQuery("SELECT p FROM EntityStock p").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public List<EntityStock> getStock(int stock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityStock find(Object paramObject) {
        return (EntityStock) em.find(EntityStock.class, paramObject);
    }

//    @Override
//    public EntityProducts findByIdProduct(Object paramObject) {
//        return (EntityProducts) em.find(EntityProducts.class, paramObject);
//    }
    @Override
    public List<EntityStock> findByIdProduct(Object idProduct) {
        return em.createQuery("SELECT ep  FROM EntityStock ep  WHERE ep.idProduct.idProduct =  \"" + idProduct + "\"").getResultList();
    }

    @Override
    public List<EntityStock> findProductByStock(String param) {
        return em.createNamedQuery("EntityStock.findProductByStock").setParameter("productName", param).getResultList();
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(ep) FROM EntityStock ep");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
