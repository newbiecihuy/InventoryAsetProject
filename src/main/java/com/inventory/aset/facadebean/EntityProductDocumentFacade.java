/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.model.EntityProductDocument;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.inventory.aset.facadebean.local.EntityProductDocumentFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityProductDocumentFacade extends AbstractFacade<EntityProductDocument> implements EntityProductDocumentFacadeLocal {

    @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;

    public EntityProductDocumentFacade() {
        super(EntityProductDocument.class);
    }

    protected EntityManager EntityLocationsDao() {
        return em;
    }

    @Override
    public void createProductPurchase(EntityProductDocument dataLocations) {
        em.persist(dataLocations);
    }

    @Override
    public void updateProductPurchase(EntityProductDocument dataLocations) {
        em.merge(dataLocations);
    }

    @Override
    public void deleteLProductPurchase(EntityProductDocument dataLocations) {
        em.merge(dataLocations);
    }

    @Override
    public void removeProductPurchase(long paramLong) {
        em.remove(getProductPurchase(paramLong));
    }

    @Override
    public EntityProductDocument getProductPurchase(long paramLong) {
        return em.find(EntityProductDocument.class, paramLong);
    }

    @Override
    public List<EntityProductDocument> getAllProductPurchase(int param, int max, int start) {
//        return em.createNamedQuery("EntityProductDocument.findAll").getResultList();
        return em.createQuery("SELECT l FROM EntityProductPurchase l where l.purchaseId.purchaseId=  \"" + param + "\"").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public EntityProductDocument findByPOCode(String param) {
//        return (EntityProductDocument) em.createQuery("SELECT l FROM EntityProductDocument l WHERE l.purchaseId.purchaseCode =  \"" + param + "\"").getSingleResult();
        String sql = "FROM EntityProductPurchase l WHERE l.purchaseId.purchaseCode = :param";
        Query query = em.createQuery(sql);
        query.setParameter("param", param);
        return (EntityProductDocument) query.getSingleResult();
    }

    @Override
    public EntityProductDocument find(Object id) {
        return (EntityProductDocument) em.find(EntityProductDocument.class, id);
    }

    @Override
    public List<EntityProductDocument> productPOlist(Long param) {
        return (List<EntityProductDocument>) em.createNamedQuery("EntityProductPurchase.findByProductPOlist").setParameter("purchaseId", param).getResultList();
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(l) FROM EntityProductPurchase l");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
