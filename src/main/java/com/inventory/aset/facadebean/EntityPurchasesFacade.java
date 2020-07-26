/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.controller.util.EncryptionUtil;
import com.inventory.aset.model.EntityPurchases;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityPurchasesFacadeLocal;
import com.inventory.aset.model.EntityDocument;
import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityPurchasesFacade extends AbstractFacade<EntityPurchases> implements EntityPurchasesFacadeLocal {

    @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
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

//        return em.createQuery("SELECT ep FROM EntityPurchases ep "
//                + " WHERE(ep.purchaseCode Like \'%" + search.toLowerCase() + "%\' "
//                + " OR ep.supplierId.supplierName Like \'" + search.toLowerCase() + "%\' "
//                + " OR ep.typePOId.typePo Like \'" + search.toLowerCase() + "%\' "
//                + " OR ep.invoiceTo Like \'" + search.toLowerCase() + "%\' "
//                + " OR ep.deliveryPoint Like \'" + search.toLowerCase() + "%\'  ) ").setMaxResults(max).setFirstResult(start).getResultList();
        String sql = " FROM EntityPurchases ep WHERE  LOWER(ep.purchaseCode) Like :purchaseCode "
                + " OR ep.supplierId.supplierName Like :supplierName "
                + " OR ep.typePOId.typePo Like :typePo "
                + " OR ep.invoiceTo Like :invoiceTo "
                + " OR ep.deliveryPoint Like  :deliveryPoint "
                + " OR ep.appproveBy Like :appproveBy "
                + " OR ep.isApprove = \"" + EncryptionUtil.getStatus(search.toLowerCase()) + "\"";
        Query query = em.createQuery(sql);
        query.setParameter("purchaseCode", search.toLowerCase() + "%");
        query.setParameter("supplierName", search.toLowerCase() + "%");
        query.setParameter("typePo", search.toLowerCase() + "%");
        query.setParameter("invoiceTo", search.toLowerCase() + "%");
        query.setParameter("deliveryPoint", search.toLowerCase() + "%");
        query.setParameter("appproveBy", search.toLowerCase() + "%");
        return (List<EntityPurchases>) query.setMaxResults(max).setFirstResult(start).getResultList();
    }

//    @Override
//    public List<EntityPurchases> getAllDataPurchases(int max) {
//        return em.createNamedQuery("EntityPurchases.findAll").setMaxResults(max).getResultList();
//    }
    public EntityPurchases find(Long purchaseId) {
        try {
            return (EntityPurchases) em.find(EntityPurchases.class, purchaseId);
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityPurchases> findByPOCode(String paramString) {
        try {
//            return em.createQuery("SELECT  ep  FROM EntityPurchases ep WHERE ep.purchaseCode LIKE \"" + pramString + "%\" ").getResultList();
            String sql = "FROM EntityPurchases ep WHERE ep.purchaseCode LIKE  :paramString ";
            Query query = em.createQuery(sql);
            query.setParameter("pramString", paramString.toLowerCase() + "%");
            return (List<EntityPurchases>) query.getResultList();

        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityPurchases> getByPOCode(String paramString) {
        try {
//            return em.createQuery("SELECT Distinct ep.purchaseCode  FROM EntityPurchases ep WHERE ep.purchaseCode LIKE \"" + pramString + "%\" ").getResultList();
            String sql = "SELECT Distinct ep.purchaseCode  FROM EntityPurchases ep WHERE ep.purchaseCode LIKE :paramString ";
            Query query = em.createQuery(sql);
            query.setParameter("paramString", paramString.toLowerCase() + "%");
            return (List<EntityPurchases>) query.getResultList();
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }
//    @Override
//    public List<EntityPurchases> getByTypePO(String pramString) {
//        return em.createQuery("SELECT Distinct ep.poType  FROM EntityPurchases ep WHERE ep.poType LIKE \"" + pramString + "%\" ").getResultList();
//    }

    @Override
    public List<EntityPurchases> findByTransportMode(String paramString) {
        try {
//            return em.createQuery("SELECT  ep  FROM EntityPurchases ep WHERE ep.transportMode LIKE \"" + pramString + "%\" ").getResultList();
            String sql = "SELECT  ep  FROM EntityPurchases ep WHERE ep.transportMode LIKE :paramString ";
            Query query = em.createQuery(sql);
            query.setParameter("paramString", paramString.toLowerCase() + "%");
            return (List<EntityPurchases>) query.getResultList();
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public EntityPurchases findByRfqNumber(String paramString) {
        try {
//            return em.createQuery("SELECT  ep  FROM EntityPurchases ep WHERE ep.rfqNumber LIKE \"" + pramString + "%\" ").getResultList();
            String sql = "SELECT  ep  FROM EntityPurchases ep WHERE ep.rfqNumber LIKE :paramString ";
            Query query = em.createQuery(sql);
            query.setParameter("paramString", paramString.toLowerCase() + "%");
            return (EntityPurchases) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

//    @Override
//    public List<EntityPurchases> findByNoPo(Date inputDate, String inputTime) {
//        return em.createNamedQuery("EntityPurchases.findByNoPo").setParameter("inputDate", inputDate).setParameter("inputTime", inputTime).getResultList();
//    }
    @Override
    public EntityPurchases findByNoPo(Date inputDate, String inputTime) {
        try {
            return (EntityPurchases) em.createNamedQuery("EntityPurchases.findByNoPo").setParameter("inputDate", inputDate).setMaxResults(1).getResultList();
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public int count() {
        try {
            Query queryMax = em.createQuery("SELECT COUNT(ep) FROM EntityPurchases ep");
            return Integer.parseInt(queryMax.getSingleResult().toString());
        } catch (NumberFormatException e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return 0;
    }
}
