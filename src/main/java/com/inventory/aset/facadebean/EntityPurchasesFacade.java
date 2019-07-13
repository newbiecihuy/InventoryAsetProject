/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntityPurchases;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityPurchasesFacadeLocal;
import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityPurchasesFacade extends AbstractFacade<EntityPurchases> implements EntityPurchasesFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityPurchasesFacade() {
        super(EntityPurchases.class);
    }

    @Override
    protected EntityManager getEntityManager() {
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
    public List<EntityPurchases> getAllPurchases(int max, int start) {
//        return em.createNamedQuery("EntityPurchases.findAll").getResultList();
        return em.createQuery("SELECT ep FROM EntityPurchases ep").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public List<EntityPurchases> searchPurchases(String search, int max, int start) {

        return em.createQuery("SELECT ep FROM EntityPurchases ep "
                + " WHERE(ep.purchaseCode Like \'%" + search.toLowerCase() + "%\' "
                + " OR ep.supplierId.supplierName Like \'" + search.toLowerCase() + "%\' "
                + " OR ep.typePOId.typePo Like \'" + search.toLowerCase() + "%\' "
                + " OR ep.invoiceTo Like \'" + search.toLowerCase() + "%\' "
                + " OR ep.deliveryPoint Like \'" + search.toLowerCase() + "%\'  ) ").setMaxResults(max).setFirstResult(start).getResultList();
    }

//    @Override
//    public List<EntityPurchases> getAllDataPurchases(int max) {
//        return em.createNamedQuery("EntityPurchases.findAll").setMaxResults(max).getResultList();
//    }
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

//    @Override
//    public List<EntityPurchases> findByNoPo(Date inputDate, String inputTime) {
//        return em.createNamedQuery("EntityPurchases.findByNoPo").setParameter("inputDate", inputDate).setParameter("inputTime", inputTime).getResultList();
//    }
    @Override
    public List<EntityPurchases> findByNoPo(Date inputDate, String inputTime) {
        return em.createNamedQuery("EntityPurchases.findByNoPo").setParameter("inputDate", inputDate).setMaxResults(1).getResultList();
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(ep) FROM EntityPurchases ep");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
