/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.entity.EntitySuppliers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.dao.local.EntitySuppliersDaoLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntitySuppliersDao extends AbstractFacade<EntitySuppliers> implements EntitySuppliersDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntitySuppliersDao() {
        super(EntitySuppliers.class);
    }

    protected EntityManager EntityLocationsDao() {
        return em;
    }

    @Override
    public void createSuppliers(EntitySuppliers dataSupplier) {
        em.persist(dataSupplier);
    }

    @Override
    public void updateSuppliers(EntitySuppliers dataSupplier) {
        em.merge(dataSupplier);
    }

    @Override
    public void deleteSuppliers(EntitySuppliers dataSupplier) {
        em.merge(dataSupplier);
    }

    @Override
    public void removeSuppliers(long paramLong) {
        em.remove(getSuppliers(paramLong));
    }

    @Override
    public EntitySuppliers getSuppliers(long supplierId) {
        return (EntitySuppliers) em.find(EntitySuppliers.class, supplierId);
    }

    @Override
    public List<EntitySuppliers> getAllSuppliers(int max) {
//        return em.createNamedQuery("EntitySuppliers.findAll").getResultList();
        return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntitySuppliers> getSupplierName(String supplierName) {
        return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierName  =  \"" + supplierName + "\"").getResultList();
    }

    @Override
    public List<EntitySuppliers> getSupplierCode(String supplierCode) {
        return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierCode  =  \"" + supplierCode + "\"").getResultList();
    }

    @Override
    public List<EntitySuppliers> findWithParam(String param1, String param2) {
        return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierName  =  \"" + param1 + "\" OR "
                + " enSupplier.supplierCode =  \"" + param2 + "\"").getResultList();
    }

    @Override
    public EntitySuppliers find(Object paramObject) {
        return (EntitySuppliers) em.find(EntitySuppliers.class, paramObject);
    }

    @Override
    public List<EntitySuppliers> findBySupplierCode(String pramString) {
        return em.createQuery("SELECT Distinct es.supplierCode  FROM EntitySuppliers es WHERE es.supplierCode LIKE \"" + pramString + "%\" ").getResultList();
    }

    @Override
    public List<EntitySuppliers> findBySupplierName(String supplierName) {
        return em.createQuery("SELECT Distinct es.supplierName  FROM EntitySuppliers es WHERE es.supplierName LIKE \"" + supplierName + "%\" ").getResultList();
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
