/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityCompanyDaoLocal;
import com.inventory.aset.entity.EntityCategories;
import com.inventory.aset.entity.EntityCompany;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateful
public class EntityCompanyDao extends AbstractFacade<EntityCompany> implements EntityCompanyDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityCompanyDao() {
        super(EntityCompany.class);
    }

    protected EntityManager EntityCompanyDao() {
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
    public List<EntityCompany> getAllCompany(int max) {
//        return em.createNamedQuery("EntityCompany.findAll").getResultList();
        return em.createQuery("SELECT c FROM EntityCompany c ").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityCompany> getIdCompany(String paramString) {
        return em.createNamedQuery("EntityCompany.findByIdCompany").getResultList();
    }

    @Override
    public List<EntityCompany> findWithCompanyName(String paramName) {
        return em.createQuery("SELECT c FROM EntityCompany c WHERE c.companyName =  \"" + paramName + "\"").getResultList();
    }

    @Override
    public List<EntityCompany> findByCompanyName(String varName) {
        return em.createQuery("SELECT Distinct c.companyName  FROM EntityCompany c WHERE c.companyName LIKE \"" + varName + "%\" ").getResultList();
    }

    @Override
    public EntityCompany find(Object categoryId) {
        return (EntityCompany) em.find(EntityCompany.class, categoryId);
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
