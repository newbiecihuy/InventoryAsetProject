/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.LogSystem;
import com.inventory.aset.model.EntityCategories;
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
        try {
            em.persist(dataCategories);
            em.flush();
            return dataCategories;
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void updateCategories(EntityCategories dataCategories) {
        try {

            em.merge(dataCategories);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public void deleteCategories(EntityCategories dataCategories) {
        try {
            em.merge(dataCategories);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public void removeCategories(long paramLong) {
        try {
            em.remove(getCategories(paramLong));
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public EntityCategories getCategories(long categoryId) {
        try {
            return (EntityCategories) em.find(EntityCategories.class, categoryId);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityCategories> getAllCategories(int max, int start) {
//        return em.createNamedQuery("EntityCategories.findAll").getResultList();
        try {
            return em.createQuery("SELECT c FROM EntityCategories c Where c.isDelete=" + false + "").setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityCategories> searchCategories(String search, int max, int start) {
        try {
            return em.createQuery("SELECT c FROM EntityCategories c "
                    + " WHERE(c.categoriesName Like \'" + search.toLowerCase() + "%\' "
                    + " ) ").setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityCategories getIdCategories(String paramString) {
        try {
            return (EntityCategories) em.createNamedQuery("EntityCategories.findBycategoryId").getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityCategories> findWithCategoriesName(String categoriesName) {
        try {
            return em.createQuery("SELECT c FROM EntityCategories c WHERE c.categoriesName =  \"" + categoriesName + "\"").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityCategories> findByCategoriesName(String varName) {
        try {
            return em.createQuery("SELECT Distinct c.categoriesName  FROM EntityCategories c WHERE c.categoriesName LIKE \"" + varName + "%\" ").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityCategories find(Object categoryId) {
        try {
            return (EntityCategories) em.find(EntityCategories.class, categoryId);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
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
    @Override
    public EntityCategories findCategoriesName(String categoriesName) {
        try {
            return (EntityCategories) em.createQuery("SELECT c FROM EntityCategories c WHERE c.categoriesName =  \"" + categoriesName + "\"").getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }
}
