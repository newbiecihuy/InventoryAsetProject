/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.entity.EntityProducts;
import com.inventory.aset.entity.EntityStock;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.dao.local.EntityStockDaoLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityStockDao extends AbstractFacade<EntityStock> implements EntityStockDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityStockDao() {
        super(EntityStock.class);
    }

    protected EntityManager EntityLocationsDao() {
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
    public List<EntityStock> getAllStock(int max) {
//        return em.createNamedQuery("EntityStock.findAll").getResultList();
        return em.createQuery("SELECT p FROM EntityStock p").setMaxResults(max).getResultList();
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
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
