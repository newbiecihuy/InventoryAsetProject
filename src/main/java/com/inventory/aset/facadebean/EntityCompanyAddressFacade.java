/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.model.EntityCompanyAddress;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityCompanyAddressFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateful
public class EntityCompanyAddressFacade extends AbstractFacade<EntityCompanyAddress> implements EntityCompanyAddressFacadeLocal {

    @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;

    public EntityCompanyAddressFacade() {
        super(EntityCompanyAddress.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createCompanyAddress(EntityCompanyAddress dataCompanyAddress) {
        em.persist(dataCompanyAddress);
    }

    @Override
    public void updateCompanyAddress(EntityCompanyAddress dataCompanyAddress) {
        em.merge(dataCompanyAddress);
    }

    @Override
    public void deleteCompanyAddress(EntityCompanyAddress dataCompanyAddress) {
        em.merge(dataCompanyAddress);
    }

    @Override
    public void removeCompanyAddress(long paramLong) {
        em.remove(getCompanyAddress(paramLong));
    }

    @Override
    public EntityCompanyAddress getCompanyAddress(long paramLong) {
        return (EntityCompanyAddress) em.find(EntityCompanyAddress.class, paramLong);
    }

    @Override
    public List<EntityCompanyAddress> getAllCompanyAddress(int max, int start) {
//      return em.createNamedQuery("EntityCompanyAddress.findAll").getResultList();
        return em.createQuery("SELECT c FROM EntityCompanyAddress c ").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public EntityCompanyAddress getIdCompanyAddress(String paramString) {
        return (EntityCompanyAddress) em.createNamedQuery("EntityCompanyAddress.findByIdCompanyAdress").getSingleResult();
    }

    @Override
    public EntityCompanyAddress findWithCompanyAddress(String paramName) {
//      return (EntityCompanyAddress) em.createQuery("SELECT c FROM EntityCompanyAddress c WHERE c.address =  \"" + paramName + "\"").getSingleResult();
        String sql = "SELECT c FROM EntityCompanyAddress c WHERE c.address = :paramName";
        Query query = em.createQuery(sql);
        query.setParameter("paramName", paramName);
        return (EntityCompanyAddress) query.getSingleResult();
    }

    @Override
    public List<EntityCompanyAddress> findByCompanyAddress(String varName) {
//      return em.createQuery("SELECT Distinct c.address  FROM EntityCompanyAddress c WHERE c.address LIKE \"" + varName + "%\" ").getResultList();
        String sql = "SELECT Distinct c.address FROM EntityCompanyAddress c WHERE c.address LIKE :varName ";
        Query query = em.createQuery(sql);
        query.setParameter("varName", varName + "%");
        return (List<EntityCompanyAddress>) query.getResultList();
    }

}
