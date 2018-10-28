/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntityProducts;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityProductsFacade extends AbstractFacade<EntityProducts> implements EntityProductsFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityProductsFacade() {
        super(EntityProducts.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public EntityProducts createProducts(EntityProducts dataProducts) {
        em.persist(dataProducts);
        em.flush();

        return dataProducts;
    }

    @Override
    public void updateProducts(EntityProducts dataProducts) {
        em.merge(dataProducts);
    }

    @Override
    public void deleteProducts(EntityProducts dataProducts) {
        em.merge(dataProducts);
    }

    @Override
    public void removeProducts(long paramLong) {
        em.remove(getProducts(paramLong));
    }

    @Override
    public EntityProducts getProducts(long idProduct) {
        return (EntityProducts) em.find(EntityProducts.class, idProduct);
    }

    @Override
    public List<EntityProducts> getAllProducts(int max) {
//        return em.createNamedQuery("EntityProducts.findAll").getResultList();
        return em.createQuery("SELECT ep FROM EntityProducts ep ").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityProducts> getSku(long idProduct) {
        return em.createQuery("SELECT ep  FROM EntityProducts ep  WHERE ep.idProduct =  \"" + idProduct + "\"").getResultList();
    }

    @Override
    public List<EntityProducts> findWithMinimumStock(int minimumStock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityProducts find(Object paramObject) {
        return (EntityProducts) em.find(EntityProducts.class, paramObject);
    }

    @Override
    public List<EntityProducts> findWithProductName(String paramName) {
        return em.createQuery("SELECT ep FROM EntityProducts ep WHERE ep.productName =  \"" + paramName + "\"").getResultList();
    }

    @Override
    public List<EntityProducts> findWithProductNameSuplier(String paramName, long paramLong) {
        return em.createQuery("SELECT ep FROM EntityProducts ep WHERE ep.productName =  \"" + paramName + "\" AND " + "ep.supplierId.supplierId =  \"" + paramLong + "\" ").getResultList();
    }

    @Override
    public List<EntityProducts> findByProductName(String paramString) {
        return em.createQuery("SELECT Distinct ep.productName  FROM EntityProducts ep WHERE ep.productName LIKE \"" + paramString + "%\" ").getResultList();
    }

    @Override
    public List<EntityProducts> findByProductCode(String paramString) {
        return em.createQuery("SELECT Distinct ep.productCode  FROM EntityProducts ep WHERE ep.productCode LIKE \"" + paramString + "%\" ").getResultList();
    }

    @Override
    public List<EntityProducts> findBySuplierId(Long paramLong) {
        return em.createQuery("SELECT Distinct ep.productName   FROM EntityProducts ep WHERE ep.supplierId.supplierId =  \"" + paramLong + "\"").getResultList();
    }

    @Override
    public List<EntityProducts> findBySuplierIdItemId(Long paramSupId, Long paramId) {
        return em.createQuery("SELECT  ep   FROM EntityProducts ep WHERE ep.supplierId.supplierId =  \"" + paramSupId + "\" AND " + "ep.idProduct =  \"" + paramId + "\"").getResultList();
    }

    @Override
    public List<EntityProducts> getItemDetails(Long paramLong, String paramString) {
        return em.createQuery("SELECT  ep  FROM EntityProducts ep WHERE ep.supplierId.supplierId =  \"" + paramLong + "\" "
                + "AND ep.productName=  \"" + paramString + "\"").getResultList();
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
