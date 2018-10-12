/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityTaxDaoLocal;
import com.inventory.aset.entity.EntityTax;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityTaxDao extends AbstractFacade<EntityTax> implements EntityTaxDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityTaxDao() {
        super(EntityTax.class);
    }

    protected EntityManager EntityLocationsDao() {
        return em;
    }

    @Override
    public void createTax(EntityTax dataTax) {
        em.persist(dataTax);
    }

    @Override
    public void updateTax(EntityTax dataTax) {
        em.merge(dataTax);
    }

    @Override
    public void deleteTax(EntityTax dataTax) {
        em.merge(dataTax);
    }

    @Override
    public void removeTax(long paramId) {
        em.remove(getTax(paramId));
    }

    @Override
    public EntityTax getTax(long paramId) {
        return em.find(EntityTax.class, paramId);
    }

    @Override
    public List<EntityTax> getAllTax(int max) {
//        return em.createNamedQuery("EntityTax.findAll").getResultList();
        return em.createQuery("SELECT t FROM EntityTax t").setMaxResults(max).getResultList();
    }

    @Override
    public EntityTax find(Object paramId) {
        return (EntityTax) em.find(EntityTax.class, paramId);
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
