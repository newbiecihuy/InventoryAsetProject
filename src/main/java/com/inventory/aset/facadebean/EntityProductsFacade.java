/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.EncryptionUtil;
import com.inventory.aset.controller.util.LogSystem;
import com.inventory.aset.model.EntityProducts;
import com.inventory.aset.model.EntityStock;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityProductsFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityProductsFacade extends AbstractFacade<EntityProducts> implements EntityProductsFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityProductsFacade() {
        super(EntityProducts.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public EntityProducts createProducts(EntityProducts dataProducts) {
        try {
            em.persist(dataProducts);
            em.flush();

            return dataProducts;
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void updateProducts(EntityProducts dataProducts) {
        try {
            em.merge(dataProducts);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }

    }

    @Override
    public void deleteProducts(EntityProducts dataProducts) {
        try {
            em.merge(dataProducts);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }

    }

    @Override
    public void removeProducts(long paramLong) {

        try {
            em.remove(getProducts(paramLong));
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }

    }

    @Override
    public EntityProducts getProducts(long idProduct) {
        try {
            return (EntityProducts) em.find(EntityProducts.class, idProduct);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> getAllProducts(int max, int start) {
//        return em.createNamedQuery("EntityProducts.findAll").getResultList();
        try {
//            return em.createQuery("SELECT ep FROM EntityProducts ep Where ep.isDelete =" + false + " AND  ep.categoryId.isDelete =" + false + "").setMaxResults(max).setFirstResult(start).getResultList();
            String sql = "SELECT ep FROM EntityProducts ep Where ep.isDelete = :isDelete AND  ep.categoryId.isDelete = :catDelete";
            Query query = em.createQuery(sql);
            query.setParameter("isDelete", false);
            query.setParameter("catDelete", false);
            return (List<EntityProducts>) query.setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> serachProducts(String search, int max, int start) {
        try {
            return em.createQuery("SELECT ep FROM EntityProducts ep "
                    + " WHERE ep.productName LIKE :productName "
                    + " OR ep.productCode LIKE :productCode "
                    + " OR ep.supplierId.supplierName LIKE :supplierName "
                    + " OR ep.categoryId.categoriesName LIKE  :categoriesName "
                    + " OR ep.status_item = :status_item ")
                    .setParameter("productName", search.toLowerCase() + "%")
                    .setParameter("productCode", search.toLowerCase() + "%")
                    .setParameter("supplierName", search.toLowerCase() + "%")
                    .setParameter("categoriesName", search.toLowerCase() + "%")
                    .setParameter("status_item", EncryptionUtil.getStatus(search.toLowerCase()))
                    .setMaxResults(max).setFirstResult(start).getResultList();
//            String sql = "SELECT ep FROM EntityProducts ep WHERE "
//                    + " LOWER(ep.productName) Like :productName "
//                    + " OR ep.productCode  Like :productCode "
//                    + " OR ep.supplierId.supplierName Like :supplierName "
//                    + " OR ep.categoryId.categoriesName Like :categoriesName "
//                    + " OR ep.status_item = :status_item ";
//            Query query = em.createQuery(sql);
//            query.setParameter("productName", search.toLowerCase() + "%");
//            query.setParameter("productCode", search.toLowerCase() + "%");
//            query.setParameter("supplierName", search.toLowerCase() + "%");
//            query.setParameter("categoriesName", search.toLowerCase() + "%");
//            query.setParameter("status_item", EncryptionUtil.getStatus(search.toLowerCase()));
//            return (List<EntityProducts>) query.setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityProducts getSku(long idProduct) {
        try {
//            return em.createQuery("SELECT ep  FROM EntityProducts ep  WHERE ep.idProduct =  \"" + idProduct + "\"").getResultList();
            String sql = "from EntityProducts ep WHERE ep.idProduct = :idProduct";
            Query query = em.createQuery(sql);
            query.setParameter("idProduct", idProduct);
            return (EntityProducts) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findWithMinimumStock(int minimumStock) {
        try {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityProducts find(Object paramObject) {
        try {
            return (EntityProducts) em.find(EntityProducts.class, paramObject);
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findWithProductName(String paramName) {
        try {
//            return em.createQuery("SELECT ep FROM EntityProducts ep "
//                    + " WHERE ep.productName =  \"" + paramName + "\"").getResultList();
            String sql = "from EntityProducts ep WHERE ep.productName = :productName";
            Query query = em.createQuery(sql);
            query.setParameter("productName", paramName);
            return (List<EntityProducts>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findWithProductNameSuplier(String paramName, long paramLong) {
        try {
//            return em.createQuery("SELECT ep FROM EntityProducts ep WHERE "
//                    + " ep.productName =  \"" + paramName + "\" "
//                    + " AND " + "ep.supplierId.supplierId =  \"" + paramLong + "\" ").getResultList();
            String sql = "from EntityProducts ep WHERE ep.productName = :productName AND ep.supplierId.supplierId = :supplierId ";
            Query query = em.createQuery(sql);
            query.setParameter("productName", paramName);
            query.setParameter("paramLong", paramName);
            return (List<EntityProducts>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityProducts findByProductActiveBySup(Long supplier_id) {
        try {
//        return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierId  =  \"" + supplier_id + "\" AND enSuppliers.isActive=1").getResultList();
            return (EntityProducts) em.createNamedQuery("EntityProducts.findByProductActiveBySup").setParameter("supplierId", supplier_id).getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findByProductName(String paramString) {
        try {
            return em.createQuery("SELECT Distinct ep.productName  FROM EntityProducts ep WHERE "
                    + " ep.productName LIKE \"" + paramString + "%\" ").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findByProductCode(String paramString) {
        try {
            return em.createQuery("SELECT Distinct ep.productCode  FROM EntityProducts ep WHERE "
                    + " ep.productCode LIKE \"" + paramString + "%\" ").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findBySuplierId(Long paramLong) {
        try {
//            return em.createQuery("SELECT Distinct ep.productName  FROM EntityProducts ep WHERE "
//                    + " ep.supplierId.supplierId =  \"" + paramLong + "\" "
//                    + " AND " + " ep.status_item =  \"" + 1 + "\"").getResultList();
            String sql = "SELECT Distinct ep.productName  FROM EntityProducts ep WHERE ep.supplierId.supplierId = :supplierId "
                    + "A ND ep.status_item= :status_item ";
            Query query = em.createQuery(sql);
            query.setParameter("supplierId", paramLong);
            query.setParameter("status_item", 1);
            return (List<EntityProducts>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

//    @Override
//    public List<EntityProducts> findBySuplierId2(Long paramLong) {
//        return em.createQuery("SELECT ep Distinct FROM EntityProducts left join ep.EntityStock es WHERE "
//                + "ep.supplierId.supplierId =  \"" + paramLong + "\" "
//                + " AND " + " ep.status_item =  \"" + 1 + "\" ").getResultList();
//    }
    @Override
    public List<EntityStock> getBuyPrice(String paramString) {
        try {
//            return em.createQuery("SELECT es.buyPrice  FROM EntityStock es  WHERE "
//                    + " es.idProduct.productName LIKE \"" + paramString + "%\" ").getResultList();

            String sql = "SELECT es.buyPrice  FROM EntityStock es  WHERE "
                    + "es.idProduct.productName LIKE \"" + ":productName" + "%\"";
            Query query = em.createQuery(sql);
            query.setParameter("productName", paramString);
            return (List<EntityStock>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findBySuplierIdItemId(Long paramSupId, Long paramId) {
        try {
//            return em.createQuery("SELECT ep FROM EntityProducts ep WHERE "
//                    + " ep.supplierId.supplierId =  \"" + paramSupId + "\" "
//                    + " AND " + "ep.idProduct =  \"" + paramId + "\"").getResultList();
            String sql = "FROM EntityProducts ep WHERE ep.supplierId.supplierId = :supplierId "
                    + "AND ep.idProduct= :idProduct ";
            Query query = em.createQuery(sql);
            query.setParameter("supplierId", paramSupId);
            query.setParameter("idProduct", paramId);
            return (List<EntityProducts>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> listItemBySuplierId(Long paramSupId) {
        try {
//            return em.createQuery("SELECT  ep   FROM EntityProducts ep WHERE "
//                    + " ep.supplierId.supplierId =  \"" + paramSupId + "\" "
//                    + " AND " + "ep.status_item =  \"" + 1 + "\"").getResultList();
            String sql = "FROM EntityProducts ep WHERE ep.supplierId.supplierId = :supplierId "
                    + "AND ep.status_item= :status_item ";
            Query query = em.createQuery(sql);
            query.setParameter("supplierId", paramSupId);
            query.setParameter("status_item", 1);
            return (List<EntityProducts>) query.getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public EntityProducts getItemDetails(Long paramLong, String paramString) {
        try {
//            return em.createQuery("SELECT  ep  FROM EntityProducts ep WHERE "
//                    + " ep.supplierId.supplierId =  \"" + paramLong + "\" "
//                    + " AND ep.productName=  \"" + paramString + "\"").getResultList();

            String sql = "FROM EntityProducts ep WHERE ep.supplierId.supplierId = :supplierId "
                    + "AND ep.productName= :productName ";
            Query query = em.createQuery(sql);
            query.setParameter("supplierId", paramLong);
            query.setParameter("productName", paramString);

            return (EntityProducts) query.getSingleResult();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public int count() {
        try {
            Query queryMax = em.createQuery("SELECT COUNT(ep) FROM EntityProducts ep");
            return Integer.parseInt(queryMax.getSingleResult().toString());
        } catch (NumberFormatException ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return 0;
    }

}
