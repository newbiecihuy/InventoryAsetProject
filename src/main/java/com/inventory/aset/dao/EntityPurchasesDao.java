/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.entity.EntityPurchases;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.dao.local.EntityPurchasesDaoLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityPurchasesDao extends AbstractFacade<EntityPurchases> implements EntityPurchasesDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityPurchasesDao() {
        super(EntityPurchases.class);
    }

    protected EntityManager EntityLocationsDao() {
        return em;
    }

    @Override
    public void createPurchases(EntityPurchases dataPurchases) {
        em.persist(dataPurchases);
    }

    @Override
    public void updatePurchases(EntityPurchases dataPurchases) {
        em.merge(dataPurchases);
    }

    @Override
    public void deletePurchases(EntityPurchases dataPurchases) {
        em.merge(dataPurchases);
    }

    @Override
    public void removePurchases(long purchaseId) {
        em.remove(getPurchases(purchaseId));
    }

    @Override
    public EntityPurchases getPurchases(long purchaseId) {
        return (EntityPurchases) em.find(EntityPurchases.class, purchaseId);
    }

    @Override
    public List<EntityPurchases> getAllPurchases(int max) {
//        return em.createNamedQuery("EntityPurchases.findAll").getResultList();
        return em.createQuery("SELECT ep FROM EntityPurchases ep").setMaxResults(max).getResultList();
    }

    @Override
    public EntityPurchases find(Object purchaseId) {
        return (EntityPurchases) em.find(EntityPurchases.class, purchaseId);
    }

    @Override
    public List<EntityPurchases> findByPOCode(String pramString) {
        return em.createQuery("SELECT  ep  FROM EntityPurchases ep WHERE ep.purchaseCode LIKE \"" + pramString + "%\" ").getResultList();
    }

    @Override
    public List<EntityPurchases> getByPOCode(String pramString) {
        return em.createQuery("SELECT Distinct ep.purchaseCode  FROM EntityPurchases ep WHERE ep.purchaseCode LIKE \"" + pramString + "%\" ").getResultList();
    }
//    @Override
//    public List<EntityPurchases> getByTypePO(String pramString) {
//        return em.createQuery("SELECT Distinct ep.poType  FROM EntityPurchases ep WHERE ep.poType LIKE \"" + pramString + "%\" ").getResultList();
//    }

    @Override
    public List<EntityPurchases> findByTransportMode(String pramString) {
        return em.createQuery("SELECT  ep  FROM EntityPurchases ep WHERE ep.transportMode LIKE \"" + pramString + "%\" ").getResultList();
    }

    @Override
    public List<EntityPurchases> findByRfqNumber(String pramString) {
        return em.createQuery("SELECT  ep  FROM EntityPurchases ep WHERE ep.rfqNumber LIKE \"" + pramString + "%\" ").getResultList();
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
