/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityProtocolDaoLocal;
import com.inventory.aset.entity.EntityCurrency;
import com.inventory.aset.entity.EntityProtocol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityProtocolDao extends AbstractFacade<EntityProtocol> implements EntityProtocolDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityProtocolDao() {
        super(EntityProtocol.class);
    }

    protected EntityManager EntityCurrencyDao() {
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
    public List<EntityProtocol> getAllProtocol(int max) {
        return em.createQuery("SELECT entityProtocol FROM EntityProtocol entityProtocol ").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityProtocol> getEmail(String paramString) {
//        return em.createNamedQuery("EntityProtocol.findByEmail").getResultList();
         return em.createQuery("SELECT entityProtocol FROM EntityProtocol entityProtocol WHERE entityProtocol.email =  \"" + paramString + "\"").getResultList();
    }

    @Override
    public List<EntityProtocol> findWithEmail(String paramString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
