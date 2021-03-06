/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.model.EntityTypePO;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityTypePOFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateful
public class EntityTypePOFacade extends AbstractFacade<EntityTypePO> implements EntityTypePOFacadeLocal {

   @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;

    public EntityTypePOFacade() {
        super(EntityTypePO.class);
    }

    @Override
    protected EntityManager getEntityManager() {
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
    public List<EntityTypePO> getAllTypePO(int max, int start) {
//        return em.createNamedQuery("EntityTypePO.findAll").getResultList();
        return em.createQuery("SELECT c FROM EntityTypePO c").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public List<EntityTypePO> getByTypePO(String paramName) {
        return em.createQuery("SELECT c FROM EntityTypePO c WHERE c.typePo   = :paramName")
                .setParameter("paramName", paramName)
                .getResultList();
    }

    @Override
    public List<EntityTypePO> findWithTypePo(String paramName) {
//        return em.createQuery("SELECT c FROM EntityTypePO c WHERE c.typePo =  \"" + paramName + "\"").getResultList();
        return em.createQuery(
                "SELECT c FROM EntityTypePO c WHERE c.typePo = :paramName")
                .setParameter("paramName", paramName)
                .getResultList();
    }

    @Override
    public List<EntityTypePO> findByTypePo(String varName) {
//        return em.createQuery("SELECT Distinct c.typePo  FROM EntityTypePO c WHERE c.typePo LIKE \"" + varName + "%\" ").getResultList();
        return em.createQuery(
                "SELECT Distinct c.typePo  FROM EntityTypePO c WHERE c.typePo LIKE :varName")
                .setParameter("varName", varName + "%")
                .getResultList();
    }

    @Override
    public EntityTypePO find(Object object) {
        return (EntityTypePO) em.find(EntityTypePO.class, object);
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(c) FROM EntityTypePO c");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }
}
