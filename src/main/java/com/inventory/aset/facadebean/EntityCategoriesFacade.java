/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntityCategories;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityCategoriesFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityCategoriesFacade extends AbstractFacade<EntityCategories> implements EntityCategoriesFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityCategoriesFacade() {
        super(EntityCategories.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public EntityCategories createCategories(EntityCategories dataCategories) {
        em.persist(dataCategories);
        em.flush();
        return dataCategories;
    }

    @Override
    public void updateCategories(EntityCategories dataCategories) {
        em.merge(dataCategories);
    }

    @Override
    public void deleteCategories(EntityCategories dataCategories) {
        em.merge(dataCategories);
    }

    @Override
    public void removeCategories(long paramLong) {
        em.remove(getCategories(paramLong));
    }

    @Override
    public EntityCategories getCategories(long categoryId) {
        return (EntityCategories) em.find(EntityCategories.class, categoryId);
    }

    @Override
    public List<EntityCategories> getAllCategories(int max, int start) {
//        return em.createNamedQuery("EntityCategories.findAll").getResultList();
        return em.createQuery("SELECT c FROM EntityCategories c ").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public List<EntityCategories> getIdCategories(String paramString) {
        return em.createNamedQuery("EntityCategories.findBycategoryId").getResultList();
    }

    @Override
    public List<EntityCategories> findWithCategoriesName(String categoriesName) {
        return em.createQuery("SELECT c FROM EntityCategories c WHERE c.categoriesName =  \"" + categoriesName + "\"").getResultList();
    }

    @Override
    public List<EntityCategories> findByCategoriesName(String varName) {
        return em.createQuery("SELECT Distinct c.categoriesName  FROM EntityCategories c WHERE c.categoriesName LIKE \"" + varName + "%\" ").getResultList();
    }

    @Override
    public EntityCategories find(Object categoryId) {
        return (EntityCategories) em.find(EntityCategories.class, categoryId);
    }

  @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(c) FROM EntityCategories c");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }


//    @Override
//    protected EntityManager getEntityManager() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
