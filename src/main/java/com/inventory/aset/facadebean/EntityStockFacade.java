/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.controller.util.LogSystem;
import com.inventory.aset.model.EntityProducts;
import com.inventory.aset.model.EntityStock;
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

  @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
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
        try {
            return em.createQuery("SELECT p FROM EntityStock p").setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityStock> getStock(int stock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityStock find(Object paramObject) {
        try {
            return (EntityStock) em.find(EntityStock.class, paramObject);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

//    @Override
//    public EntityProducts findByIdProduct(Object paramObject) {
//        return (EntityProducts) em.find(EntityProducts.class, paramObject);
//    }
    @Override
    public List<EntityStock> findByIdProduct(Object idProduct) {
        try {
//            return em.createQuery("SELECT ep  FROM EntityStock ep  WHERE ep.idProduct.idProduct =  \"" + idProduct + "\"").getResultList();
            String sql = "SELECT ep  FROM EntityStock ep  WHERE ep.idProduct.idProduct = :idProduct";
            Query query = em.createQuery(sql);
            query.setParameter("idProduct", Long.parseLong(idProduct.toString()));
            return (List<EntityStock>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityStock> findProductByStock(String param) {
        try {
            return em.createNamedQuery("EntityStock.findProductByStock").setParameter("productName", param).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(ep) FROM EntityStock ep");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
