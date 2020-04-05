/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.model.EntityCategories;
import com.inventory.aset.model.EntityCompany;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityCompanyFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateful
public class EntityCompanyFacade extends AbstractFacade<EntityCompany> implements EntityCompanyFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityCompanyFacade() {
        super(EntityCompany.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createCompany(EntityCompany dataCompany) {
        em.persist(dataCompany);
    }

    @Override
    public void updateCompany(EntityCompany dataCompany) {
        em.merge(dataCompany);
    }

    @Override
    public void deleteCompany(EntityCompany dataCompany) {
        em.merge(dataCompany);
    }

    @Override
    public void removeCompany(long paramLong) {
        em.remove(getCompany(paramLong));
    }

    @Override
    public EntityCompany getCompany(long paramLong) {
        return (EntityCompany) em.find(EntityCompany.class, paramLong);
    }

    @Override
    public List<EntityCompany> getAllCompany(int max, int start) {
        return em.createNamedQuery("EntityCompany.findAll").setMaxResults(max).setFirstResult(start).getResultList();
//       return em.createQuery("SELECT c FROM EntityCompany c ").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public EntityCompany getIdCompany(String paramString) {
        return (EntityCompany) em.createNamedQuery("EntityCompany.findByIdCompany").getResultList();
    }

    @Override
    public EntityCompany findWithCompanyName(String paramName) {
//        return (EntityCompany) em.createQuery("SELECT c FROM EntityCompany c WHERE c.companyName =  \"" + paramName + "\"").getSingleResult();
        String sql = "SELECT c FROM EntityCompany c WHERE c.companyName = :paramName";
        Query query = em.createQuery(sql);
        query.setParameter("paramName", paramName);
        return (EntityCompany) query.getSingleResult();
    }

    @Override
    public List<EntityCompany> findByCompanyName(String varName) {
//        return em.createQuery("SELECT Distinct c.companyName  FROM EntityCompany c WHERE c.companyName LIKE \"" + varName + "%\" ").getResultList();
        String sql = "SELECT Distinct c.companyName  FROM EntityCompany c WHERE c.companyName LIKE :varName ";
        Query query = em.createQuery(sql);
        query.setParameter("varName", varName + "%");
        return (List<EntityCompany>) query.getResultList();
    }

    @Override
    public EntityCompany find(Object compId) {
        return (EntityCompany) em.find(EntityCompany.class, compId);
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(c) FROM EntityCompany c");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
