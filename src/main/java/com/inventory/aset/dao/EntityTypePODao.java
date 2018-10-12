/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityTypePODaoLocal;
import com.inventory.aset.entity.EntityTypePO;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateful
public class EntityTypePODao extends AbstractFacade<EntityTypePO> implements EntityTypePODaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityTypePODao() {
        super(EntityTypePO.class);
    }

    protected EntityManager EntityTypePODao() {
        return em;
    }

    @Override
    public void createTypePO(EntityTypePO dataTypePO) {
        em.persist(dataTypePO);
    }

    @Override
    public void updateTypePO(EntityTypePO dataTypePO) {
        em.merge(dataTypePO);
    }

    @Override
    public void deleteTypePO(EntityTypePO dataTypePO) {
        em.merge(dataTypePO);
    }

    @Override
    public void removeTypePO(long paramLong) {
        em.remove(getTypePO(paramLong));
    }

    @Override
    public EntityTypePO getTypePO(long paramlong) {
        return (EntityTypePO) em.find(EntityTypePO.class, paramlong);
    }

    @Override
    public List<EntityTypePO> getAllTypePO(int max) {
//        return em.createNamedQuery("EntityTypePO.findAll").getResultList();
        return em.createQuery("SELECT c FROM EntityTypePO c").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityTypePO> getByTypePO(String paramName) {
        return em.createQuery("SELECT c FROM EntityTypePO c WHERE c.typePo  =  \"" + paramName + "\"").getResultList();
    }

    @Override
    public List<EntityTypePO> findWithTypePo(String paramName) {
        return em.createQuery("SELECT c FROM EntityTypePO c WHERE c.typePo =  \"" + paramName + "\"").getResultList();
    }

    @Override
    public List<EntityTypePO> findByTypePo(String varName) {
        return em.createQuery("SELECT Distinct c.typePo  FROM EntityTypePO c WHERE c.typePo LIKE \"" + varName + "%\" ").getResultList();
    }

    @Override
    public EntityTypePO find(Object object) {
        return (EntityTypePO) em.find(EntityTypePO.class, object);
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
