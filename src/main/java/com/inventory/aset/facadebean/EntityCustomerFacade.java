/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.controller.util.EncryptionUtil;
import com.inventory.aset.controller.util.LogSystem;
import com.inventory.aset.model.EntityCustomer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityCustomerFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityCustomerFacade extends AbstractFacade<EntityCustomer> implements EntityCustomerFacadeLocal {

    @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;

    public EntityCustomerFacade() {
        super(EntityCustomer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createCutomer(EntityCustomer entity) {
        em.persist(entity);
    }

    @Override
    public void updateCutomer(EntityCustomer entity) {
        em.merge(entity);
    }

    @Override
    public void deleteCutomer(EntityCustomer entity) {
        try {
            entity.setIsDelete(true);
            em.merge(entity);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public void removeCutomer(long paramLong) {
        em.remove(getCutomer(paramLong));
    }

    @Override
    public EntityCustomer getCutomer(long custId) {
        try {
            return (EntityCustomer) em.find(EntityCustomer.class, custId);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityCustomer> getAllCutomer(int max, int start) {
        try {
//            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers where enSuppliers.isDelete =" + false + "").setMaxResults(max).setFirstResult(start).getResultList();
            String sql = "SELECT ec FROM EntityCustomer ec where ec.isDelete = :supisDelete "
                    + " AND ec.patnerType =\"" + "Customer" + "\"";
            Query query = em.createQuery(sql);
            query.setParameter("supisDelete", false);
            return (List<EntityCustomer>) query.setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityCustomer> searchCutomer(String search, int max, int start) {
        try {
//             return em.createQuery(
//                    "SELECT Distinct es.supplierName FROM EntitySuppliers es WHERE es.supplierName LIKE :supplierName")
//                    .setParameter("supplierName", supplierName + "%")
//                    .getResultList();
            return em.createQuery("SELECT ec FROM EntityCustomer ec WHERE "
                    + " ec.name LIKE LOWER(:customerName) "
                    + " OR ec.partnerCode  LIKE LOWER(:customerCode) "
                    + " OR ec.contactName LIKE LOWER(:contactName) "
                    + " OR ec.isActive  = \"" + EncryptionUtil.getStatus(search) + "\""
                    + " AND ec.patnerType = \"" + "Customer" + "\"")
                    .setParameter("customerName", search + "%")
                    .setParameter("customerCode", search + "%")
                    .setParameter("contactName", search + "%")
                    .setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityCustomer getCutomerName(String supplierName) {
        try {
//            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE  LOWER(enSuppliers.supplierName)  =  \"" + supplierName.toLowerCase() + "\"").getResultList();
            String sql = "from EntityCustomer ec WHERE  LOWER(enSuppliers.name) = LOWER(:supplierName) "
                    + " AND ec.patnerType =\"" + "Customer" + "\"";
            Query query = em.createQuery(sql);
            query.setParameter("supplierName", supplierName);
            return (EntityCustomer) query.getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityCustomer> listCutomerName(String supplierName) {
        try {
//            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE  LOWER(enSuppliers.supplierName)  =  \"" + supplierName.toLowerCase() + "\"").getResultList();
            String sql = "from EntityCustomer ec WHERE  LOWER(ec.name) =  LOWER(:supplierName) "
                    + "AND ec.patnerType =\"" + "Customer" + "\"";
            Query query = em.createQuery(sql);
            query.setParameter("supplierName", supplierName);
            return (List<EntityCustomer>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityCustomer> getCutomerCode(String customerCode) {
        try {
//            return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierCode  =  \"" + supplierCode + "\"").getResultList();
            String sql = "from EntityCustomer ec WHERE  ec.partnerCode = :customerCode "
                    + " AND enSuppliers.patnerType =\"" + "Customer" + "\"";
            Query query = em.createQuery(sql);
            query.setParameter("customerCode", customerCode);
            return (List<EntityCustomer>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityCustomer findByStatusActive(Long customer_id) {
        try {
//        return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierId  =  \"" + supplier_id + "\" AND enSuppliers.isActive=1").getResultList();
            return (EntityCustomer) em.createNamedQuery("EntityCustomer.findByStatusActive").setParameter("customerId", customer_id).getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityCustomer findByCutomerCode(String pramString) {
    try {
//            return (EntitySuppliers) em.createQuery("SELECT Distinct es.supplierCode  FROM EntitySuppliers es WHERE es.supplierCode LIKE \"" + pramString + "%\" ").getResultList();
            String sql = "from EntityCustomer ec WHERE  ec.partnerCode LIKE :partnerCode AND ec.isActive =  \"" + 1 + "\" "
                    + " AND enSuppliers.patnerType =\"" + "Customer" + "\"";
            Query query = em.createQuery(sql);
            query.setParameter("supplierCode", pramString + "%");
            return (EntityCustomer) query.getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }
    
     @Override
    public List<EntityCustomer> listSupplierCode(String paramString) {
        try {
//            return (EntitySuppliers) em.createQuery("SELECT Distinct es.supplierCode  FROM EntitySuppliers es WHERE es.supplierCode LIKE \"" + pramString + "%\" ").getResultList();
       String sql = "from EntityCustomer ec WHERE  ec.partnerCode LIKE :partnerCode AND ec.isActive =  \"" + 1 + "\" "
                    + " AND enSuppliers.patnerType =\"" + "Customer" + "\"";
            Query query = em.createQuery(sql);
            query.setParameter("supplierCode", paramString + "%");
            return (List<EntityCustomer>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityCustomer findByCutomerName(String supplierName) {
        try {
//            return em.createQuery("SELECT Distinct es.supplierName  FROM EntitySuppliers es WHERE es.supplierName LIKE \"" + supplierName + "%\" AND es.isActive =  \"" + 1 + "\"").getResultList();

            return (EntityCustomer) em.createQuery(
                    "SELECT Distinct ec.supplierName FROM EntityCustomer ec WHERE ec.name LIKE :customerName "
                    + "AND es.isActive =\"" + 1 + "\" "
                    + "AND es.patnerType =\"" + "Customer" + "\"")
                    .setParameter("EntityCustomer", supplierName + "%")
                    .getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityCustomer findWithParam(String param1, String param2) {
        try {
//            return (EntitySuppliers) em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE LOWER(enSuppliers.supplierName)  =  \"" + param1.toLowerCase() + "\" OR "
//                    + "  LOWER(enSupplier.supplierCode) =  \"" + param2.toLowerCase() + "\"").getSingleResult();

            String sql = "from EntityCustomer ec WHERE  LOWER(ec.name) = :supplierName OR LOWER(ec.partnerCode) = :supplierCode "
                    + " AND enSuppliers.patnerType =\"" + "Customer" + "\"";
            Query query = em.createQuery(sql);
            query.setParameter("supplierName", param1.toLowerCase());
            query.setParameter("supplierCode", param2.toLowerCase());
            return (EntityCustomer) query.getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityCustomer findById(Object paramObject) {
        try {
            return (EntityCustomer) em.find(EntityCustomer.class, Long.parseLong(paramObject.toString()));
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public int count() {
         Query queryMax = em.createQuery("SELECT COUNT(ec) FROM EntityCustomer ec "
                + " WHERE ec.patnerType =\"" + "Customer" + "\"");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
