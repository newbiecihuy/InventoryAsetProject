/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.model.EntityCurrency;
import com.inventory.aset.model.EntityProtocol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityProtocolFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityProtocolFacade extends AbstractFacade<EntityProtocol> implements EntityProtocolFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityProtocolFacade() {
        super(EntityProtocol.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createProtocol(EntityProtocol dataProtocol) {
        em.persist(dataProtocol);
    }

    @Override
    public void updateProtocol(EntityProtocol dataProtocol) {
        em.merge(dataProtocol);
    }

    @Override
    public void deleteProtocol(EntityProtocol dataProtocol) {
        em.merge(dataProtocol);
    }

    @Override
    public void removeProtocol(long paramLong) {
        em.remove(getProtocol(paramLong));
    }

    @Override
    public EntityProtocol getProtocol(long paramLong) {
        return (EntityProtocol) em.find(EntityProtocol.class, paramLong);
    }

    @Override
    public List<EntityProtocol> getAllProtocol(int max, int start) {
        return em.createQuery("SELECT entityProtocol FROM EntityProtocol entityProtocol ").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public EntityProtocol getEmail(String paramString) {
        return (EntityProtocol) em.createNamedQuery("EntityProtocol.findByEmail").getSingleResult();
//        return em.createQuery("SELECT entityProtocol FROM EntityProtocol entityProtocol WHERE entityProtocol.email =  \"" + paramString + "\"").getResultList();
    }

    @Override
    public List<EntityProtocol> findWithEmail(String paramString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(entityProtocol) FROM EntityProtocol entityProtocol");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
