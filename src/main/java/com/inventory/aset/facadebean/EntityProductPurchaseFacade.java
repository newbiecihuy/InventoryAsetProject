/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntityProductPurchase;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityProductPurchaseFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityProductPurchaseFacade extends AbstractFacade<EntityProductPurchase> implements EntityProductPurchaseFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityProductPurchaseFacade() {
        super(EntityProductPurchase.class);
    }

    protected EntityManager EntityLocationsDao() {
        return em;
    }

    @Override
    public void createProductPurchase(EntityProductPurchase dataLocations) {
        em.persist(dataLocations);
    }

    @Override
    public void updateProductPurchase(EntityProductPurchase dataLocations) {
        em.merge(dataLocations);
    }

    @Override
    public void deleteLProductPurchase(EntityProductPurchase dataLocations) {
        em.merge(dataLocations);
    }

    @Override
    public void removeProductPurchase(long paramLong) {
        em.remove(getProductPurchase(paramLong));
    }

    @Override
    public EntityProductPurchase getProductPurchase(long paramLong) {
        return em.find(EntityProductPurchase.class, paramLong);
    }

    @Override
    public List<EntityProductPurchase> getAllProductPurchase(int param, int max) {
//        return em.createNamedQuery("EntityProductPurchase.findAll").getResultList();
        return em.createQuery("SELECT l FROM EntityProductPurchase l where l.purchaseId.purchaseId=  \"" + param + "\"").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityProductPurchase> findByPOCode(String param) {
        return em.createQuery("SELECT l FROM EntityProductPurchase l WHERE l.purchaseId.purchaseCode =  \"" + param + "\"").getResultList();
    }

    @Override
    public EntityProductPurchase find(Object id) {
        return (EntityProductPurchase) em.find(EntityProductPurchase.class, id);
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
