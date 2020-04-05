/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.EncryptionUtil;
import com.inventory.aset.controller.util.LogSystem;
import com.inventory.aset.model.EntitySuppliers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntitySuppliersFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntitySuppliersFacade extends AbstractFacade<EntitySuppliers> implements EntitySuppliersFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntitySuppliersFacade() {
        super(EntitySuppliers.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createSuppliers(EntitySuppliers dataSupplier) {
        em.persist(dataSupplier);
    }

    @Override
    public void updateSuppliers(EntitySuppliers dataSupplier) {
        em.merge(dataSupplier);
    }

    @Override
    public void deleteSuppliers(EntitySuppliers dataSupplier) {
        try {
            em.merge(dataSupplier);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public void removeSuppliers(long paramLong) {

        em.remove(getSuppliers(paramLong));
    }

    @Override
    public EntitySuppliers getSuppliers(long supplierId) {
        try {
            return (EntitySuppliers) em.find(EntitySuppliers.class, supplierId);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntitySuppliers> getAllSuppliers(int max, int start) {
//        return em.createNamedQuery("EntitySuppliers.findAll").getResultList();
        try {
//            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers where enSuppliers.isDelete =" + false + "").setMaxResults(max).setFirstResult(start).getResultList();
            String sql = "SELECT enSuppliers FROM EntitySuppliers enSuppliers where enSuppliers.isDelete = :supisDelete ";
            Query query = em.createQuery(sql);
            query.setParameter("supisDelete", false);
            return (List<EntitySuppliers>) query.setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntitySuppliers> searchSuppliers(String search, int max, int start) {
        try {
//             return em.createQuery(
//                    "SELECT Distinct es.supplierName FROM EntitySuppliers es WHERE es.supplierName LIKE :supplierName")
//                    .setParameter("supplierName", supplierName + "%")
//                    .getResultList();
            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE "
                    + "  enSuppliers.supplierName LIKE :supplierName "
                    + " OR enSuppliers.supplierCode  LIKE :supplierCode "
                    + " OR enSuppliers.contactName LIKE :contactName "
                    + " OR enSuppliers.isActive  = \"" + EncryptionUtil.getStatus(search.toLowerCase()) + "\"")
                    .setParameter("supplierName", search.toLowerCase() + "%")
                    .setParameter("supplierCode", search.toLowerCase() + "%")
                    .setParameter("contactName", search.toLowerCase() + "%")
                    .setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntitySuppliers getSupplierName(String supplierName) {
        try {
//            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE  LOWER(enSuppliers.supplierName)  =  \"" + supplierName.toLowerCase() + "\"").getResultList();
            String sql = "from EntitySuppliers enSuppliers WHERE  LOWER(enSuppliers.supplierName) = :supplierName";
            Query query = em.createQuery(sql);
            query.setParameter("supplierName", supplierName);
            return (EntitySuppliers) query.getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntitySuppliers> listSupplierName(String supplierName) {
        try {
//            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE  LOWER(enSuppliers.supplierName)  =  \"" + supplierName.toLowerCase() + "\"").getResultList();
            String sql = "from EntitySuppliers enSuppliers WHERE  LOWER(enSuppliers.supplierName) = :supplierName";
            Query query = em.createQuery(sql);
            query.setParameter("supplierName", supplierName);
            return (List<EntitySuppliers>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntitySuppliers> getSupplierCode(String supplierCode) {
        try {
//            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierCode  =  \"" + supplierCode + "\"").getResultList();
            String sql = "from EntitySuppliers enSuppliers WHERE  enSuppliers.supplierCode = :supplierCode";
            Query query = em.createQuery(sql);
            query.setParameter("supplierCode", supplierCode);
            return (List<EntitySuppliers>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
//    public List<EntitySuppliers> findByStatusActive(Long supplier_id) {
    public EntitySuppliers findByStatusActive(Long supplier_id) {
        try {
//        return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierId  =  \"" + supplier_id + "\" AND enSuppliers.isActive=1").getResultList();
            return (EntitySuppliers) em.createNamedQuery("EntitySuppliers.findByStatusActive").setParameter("supplierId", supplier_id).getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntitySuppliers findWithParam(String param1, String param2) {
        try {
//            return (EntitySuppliers) em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE LOWER(enSuppliers.supplierName)  =  \"" + param1.toLowerCase() + "\" OR "
//                    + "  LOWER(enSupplier.supplierCode) =  \"" + param2.toLowerCase() + "\"").getSingleResult();

            String sql = "from EntitySuppliers enSuppliers WHERE  LOWER(enSuppliers.supplierName) = :supplierName OR LOWER(enSupplier.supplierCode) = :supplierCode";
            Query query = em.createQuery(sql);
            query.setParameter("supplierName", param1.toLowerCase());
            query.setParameter("supplierCode", param2.toLowerCase());
            return (EntitySuppliers) query.getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntitySuppliers find(Object paramObject) {
        try {
            return (EntitySuppliers) em.find(EntitySuppliers.class, paramObject);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntitySuppliers> findBySupplierCode(String pramString) {
        try {
//            return (EntitySuppliers) em.createQuery("SELECT Distinct es.supplierCode  FROM EntitySuppliers es WHERE es.supplierCode LIKE \"" + pramString + "%\" ").getResultList();
            String sql = "from EntitySuppliers enSuppliers WHERE  enSuppliers.supplierCode LIKE :supplierCode ";
            Query query = em.createQuery(sql);
            query.setParameter("supplierCode", pramString + "%");
            return (List<EntitySuppliers>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntitySuppliers> findBySupplierName(String supplierName) {
        try {
//            return em.createQuery("SELECT Distinct es.supplierName  FROM EntitySuppliers es WHERE es.supplierName LIKE \"" + supplierName + "%\" AND es.isActive =  \"" + 1 + "\"").getResultList();

            return em.createQuery(
                    "SELECT Distinct es.supplierName FROM EntitySuppliers es WHERE es.supplierName LIKE :supplierName")
                    .setParameter("supplierName", supplierName + "%")
                    .getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(es) FROM EntitySuppliers es");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
