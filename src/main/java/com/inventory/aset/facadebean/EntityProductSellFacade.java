/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.model.EntityProductSell;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityProductSellFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityProductSellFacade extends AbstractFacade<EntityProductSell> implements EntityProductSellFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityProductSellFacade() {
        super(EntityProductSell.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createProductSell(EntityProductSell dataProductSell) {
        em.persist(dataProductSell);
    }

    @Override
    public void updateProductSell(EntityProductSell dataProductSell) {
        em.merge(dataProductSell);
    }

    @Override
    public void deleteProductSell(EntityProductSell dataProductSell) {
        em.merge(dataProductSell);
    }

    @Override
    public void removeProductSell(long paramLong) {
        em.remove(getProductSell(paramLong));
    }

    @Override
    public EntityProductSell getProductSell(long idProductSell) {
        return (EntityProductSell) em.find(EntityProductSell.class, idProductSell);
    }

    @Override
    public List<EntityProductSell> getAllProductSell(int max,int start) {
        return em.createNamedQuery("EntityProductSell.findAll").setMaxResults(max).setFirstResult(start).getResultList();
    }

//    @Override
//    public List<EntityProductSell> getSellId(Object sellId) {
//      return em.createNamedQuery("EntityProductSell.findById").getResultList();
//    }
    @Override
    public EntityProductSell find(Object sellId) {
        return (EntityProductSell) em.find(EntityProductSell.class, sellId);
    }

    @Override
    public int count() {
         Query queryMax = em.createQuery("SELECT COUNT(s) FROM EntityProductSell s");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
