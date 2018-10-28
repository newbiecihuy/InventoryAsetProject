/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntitySells;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntitySellsFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntitySellsFacade extends AbstractFacade<EntitySells> implements EntitySellsFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntitySellsFacade() {
        super(EntitySells.class);
    }

    @Override
    protected EntityManager getEntityManager() {
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

}
