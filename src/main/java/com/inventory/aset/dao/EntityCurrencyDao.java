/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityCurrencyDaoLocal;
import com.inventory.aset.entity.EntityCurrency;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityCurrencyDao extends AbstractFacade<EntityCurrency> implements EntityCurrencyDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityCurrencyDao() {
        super(EntityCurrency.class);
    }

    protected EntityManager EntityCurrencyDao() {
        return em;
    }

    @Override
    public void createCurrencies(EntityCurrency dataCurrency) {
        em.persist(dataCurrency);
    }

    @Override
    public void updateCurrencies(EntityCurrency dataCurrency) {
        em.merge(dataCurrency);
    }

    @Override
    public void deleteCurrencies(EntityCurrency dataCurrency) {
        em.merge(dataCurrency);
    }

    @Override
    public void removeCurrenciess(long paramLong) {
        em.remove(getCurrenciess(paramLong));
    }

    @Override
    public EntityCurrency getCurrenciess(long paramLong) {
        return (EntityCurrency) em.find(EntityCurrency.class, paramLong);
    }

    @Override
    public List<EntityCurrency> getAllCurrencies() {
        return em.createNamedQuery("EntityCurrency.findAll").getResultList();
    }

    @Override
    public List<EntityCurrency> getCurrencyRate(String paramString) {
        return em.createQuery("SELECT c FROM EntityCurrency c WHERE c.isActive =  \"" + true + "\"").getResultList();
    }

    @Override
    public List<EntityCurrency> findWithCurrencyName(String paramString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
