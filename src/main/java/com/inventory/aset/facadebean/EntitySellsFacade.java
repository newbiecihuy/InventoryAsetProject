/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.model.EntitySales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntitySellsFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntitySellsFacade extends AbstractFacade<EntitySales> implements EntitySellsFacadeLocal {

   @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;

    public EntitySellsFacade() {
        super(EntitySales.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createSell(EntitySales dataSell) {
        em.persist(dataSell);
    }

    @Override
    public void updateSell(EntitySales dataSell) {
        em.merge(dataSell);
    }

    @Override
    public void deleteSell(EntitySales dataSell) {
        em.merge(dataSell);
    }

    @Override
    public void removeSell(long sellId) {
        em.remove(getSell(sellId));
    }

    @Override
    public EntitySales getSell(long sellId) {
        return em.find(EntitySales.class, sellId);
    }

    @Override
    public List<EntitySales> getAllSells(int max, int start) {
//       return em.createNamedQuery("EntitySales.findAll").getResultList();
        return em.createQuery("SELECT s FROM EntitySells s").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public EntitySales find(Object sellId) {
        return (EntitySales) em.find(EntitySales.class, sellId);
    }

    @Override
    public int count() {
          Query queryMax = em.createQuery("SELECT COUNT(s) FROM EntitySells s");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
