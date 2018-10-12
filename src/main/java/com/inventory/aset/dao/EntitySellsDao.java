/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntitySellsLocal;
import com.inventory.aset.entity.EntityPurchases;
import com.inventory.aset.entity.EntitySells;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntitySellsDao extends AbstractFacade<EntitySells> implements EntitySellsLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntitySellsDao() {
        super(EntitySells.class);
    }

    protected EntityManager EntityLocationsDao() {
        return em;
    }

    @Override
    public void createSell(EntitySells dataSell) {
        em.persist(dataSell);
    }

    @Override
    public void updateSell(EntitySells dataSell) {
        em.merge(dataSell);
    }

    @Override
    public void deleteSell(EntitySells dataSell) {
        em.merge(dataSell);
    }

    @Override
    public void removeSell(long sellId) {
        em.remove(getSell(sellId));
    }

    @Override
    public EntitySells getSell(long sellId) {
        return em.find(EntitySells.class, sellId);
    }

    @Override
    public List<EntitySells> getAllSells(int max) {
//       return em.createNamedQuery("EntitySells.findAll").getResultList();
        return em.createQuery("SELECT s FROM EntitySells s").setMaxResults(max).getResultList();
    }

    @Override
    public EntitySells find(Object sellId) {
        return (EntitySells) em.find(EntitySells.class, sellId);
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
