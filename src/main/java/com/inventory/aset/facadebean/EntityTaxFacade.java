/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntityTax;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityTaxFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityTaxFacade extends AbstractFacade<EntityTax> implements EntityTaxFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityTaxFacade() {
        super(EntityTax.class);
    }

    @Override
    protected EntityManager getEntityManager() {
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
    public List<EntityTax> getAllTax(int max, int start) {
//        return em.createNamedQuery("EntityTax.findAll").getResultList();
        return em.createQuery("SELECT t FROM EntityTax t").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public List<EntityTax> getTaxByType(String taxType) {
//        return em.createNamedQuery("EntityTax.findAll").getResultList();
        return em.createQuery("SELECT t FROM EntityTax t WHERE t.taxType =  \"" + taxType + "\"").getResultList();
    }

    @Override
    public EntityTax find(Object paramId) {
        return (EntityTax) em.find(EntityTax.class, paramId);
    }

    @Override
    public int count() {
         Query queryMax = em.createQuery("SELECT COUNT(t) FROM EntityTax t");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
