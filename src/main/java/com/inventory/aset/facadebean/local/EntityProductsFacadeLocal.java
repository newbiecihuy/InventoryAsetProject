/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityProducts;
import com.inventory.aset.model.EntityStock;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityProductsFacadeLocal {

    EntityProducts createProducts(EntityProducts dataProducts);

    void updateProducts(EntityProducts dataProducts);

    void deleteProducts(EntityProducts dataProducts);

    void removeProducts(long paramName);

    EntityProducts getProducts(long paramName);

    List<EntityProducts> getAllProducts(int max, int start);

    List<EntityProducts> getAllProductsRaw(int max, int start);

    List<EntityProducts> serachProducts(String search, int max, int start);

    List<EntityProducts> serachProductsRaw(String search, int max, int start);

    EntityProducts getSku(long paramName

    );

    List<EntityProducts> findByProductName(String pramString);

    List<EntityProducts> findByProductCode(String pramString);

    List<EntityProducts> findWithMinimumStock(int minimumStock);

    List<EntityProducts> findWithProductName(String paramName);

    List<EntityProducts> findWithProductNameSuplier(String paramName, long paramLong);

    EntityProducts findByProductActiveBySup(Long supplier_id);

    List<EntityProducts> findBySuplierId(Long paramLong);

//    List<EntityProducts> findBySuplierId2(Long paramLong);
    List<EntityStock> getBuyPrice(String paramString);

    List<EntityProducts> findBySuplierIdItemId(Long paramSupId, Long paramId);

    List<EntityProducts> listItemBySuplierId(Long paramSupId);

    List<EntityProducts> getItemDetails(Long paramLong, String paramString);

    EntityProducts find(Object paramObject);

    int count();

}
