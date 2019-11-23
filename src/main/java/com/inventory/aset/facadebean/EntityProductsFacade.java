/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.EncryptionUtil;
import com.inventory.aset.controller.util.LogSystem;
import com.inventory.aset.entity.EntityProducts;
import com.inventory.aset.entity.EntityStock;
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
        em.persist(dataProducts);
        em.flush();

        return dataProducts;
    }

    @Override
    public void updateProducts(EntityProducts dataProducts) {
        em.merge(dataProducts);
    }

    @Override
    public void deleteProducts(EntityProducts dataProducts) {
        em.merge(dataProducts);
    }

    @Override
    public void removeProducts(long paramLong) {
        em.remove(getProducts(paramLong));
    }

    @Override
    public EntityProducts getProducts(long idProduct) {
        return (EntityProducts) em.find(EntityProducts.class, idProduct);
    }

    @Override
    public List<EntityProducts> getAllProducts(int max, int start) {
//        return em.createNamedQuery("EntityProducts.findAll").getResultList();
        try {
            return em.createQuery("SELECT ep FROM EntityProducts ep Where ep.isDelete =" + false + " AND  ep.categoryId.isDelete =" + false + "").setMaxResults(max).setFirstResult(start).getResultList();
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
                    + " WHERE (ep.productName Like \'" + search.toLowerCase() + "%\' "
                    + " OR ep.productCode Like \'" + search.toLowerCase() + "%\' "
                    + " OR ep.supplierId.supplierName Like \'" + search.toLowerCase() + "%\' "
                    + " OR ep.categoryId.categoriesName Like \'" + search.toLowerCase() + "%\' "
                    + " ) ").setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> getSku(long idProduct) {
        try {
            return em.createQuery("SELECT ep  FROM EntityProducts ep  WHERE ep.idProduct =  \"" + idProduct + "\"").getResultList();
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
            return em.createQuery("SELECT ep FROM EntityProducts ep "
                    + " WHERE ep.productName =  \"" + paramName + "\"").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findWithProductNameSuplier(String paramName, long paramLong) {
        try {
            return em.createQuery("SELECT ep FROM EntityProducts ep WHERE "
                    + " ep.productName =  \"" + paramName + "\" "
                    + " AND " + "ep.supplierId.supplierId =  \"" + paramLong + "\" ").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findByProductActiveBySup(Long supplier_id) {
        try {
//        return em.createQuery("SELECT enSuppliers FROM EntitySuppliers enSuppliers WHERE enSuppliers.supplierId  =  \"" + supplier_id + "\" AND enSuppliers.isActive=1").getResultList();
            return em.createNamedQuery("EntityProducts.findByProductActiveBySup").setParameter("supplierId", supplier_id).getResultList();
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
            return em.createQuery("SELECT Distinct ep.productName  FROM EntityProducts ep WHERE "
                    + " ep.supplierId.supplierId =  \"" + paramLong + "\" "
                    + " AND " + " ep.status_item =  \"" + 1 + "\"").getResultList();
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
            return em.createQuery("SELECT es.buyPrice  FROM EntityStock es  WHERE "
                    + " es.idProduct.productName LIKE \"" + paramString + "%\" ").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> findBySuplierIdItemId(Long paramSupId, Long paramId) {
        try {
            return em.createQuery("SELECT  ep   FROM EntityProducts ep WHERE "
                    + " ep.supplierId.supplierId =  \"" + paramSupId + "\" "
                    + " AND " + "ep.idProduct =  \"" + paramId + "\"").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> listItemBySuplierId(Long paramSupId) {
        try {
            return em.createQuery("SELECT  ep   FROM EntityProducts ep WHERE "
                    + " ep.supplierId.supplierId =  \"" + paramSupId + "\" "
                    + " AND " + "ep.status_item =  \"" + 1 + "\"").getResultList();
        } catch (Exception ex) {
            LogSystem.error(getClass(), ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<EntityProducts> getItemDetails(Long paramLong, String paramString) {
        try {
            return em.createQuery("SELECT  ep  FROM EntityProducts ep WHERE "
                    + " ep.supplierId.supplierId =  \"" + paramLong + "\" "
                    + " AND ep.productName=  \"" + paramString + "\"").getResultList();
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
