/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.entity.EntityProductPurchase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityProductPurchaseFacadeLocal {

    void createProductPurchase(EntityProductPurchase dataLocations);

    void updateProductPurchase(EntityProductPurchase dataLocations);

    void deleteLProductPurchase(EntityProductPurchase dataLocations);

    void removeProductPurchase(long paramLong);

    EntityProductPurchase getProductPurchase(long paramLong);

    List<EntityProductPurchase> getAllProductPurchase(int param, int max);

//    List<EntityProductPurchase> getIdProductPurchase(long paramLong);
//    List<EntityProductPurchase> findWithPrice(String price);
    public List<EntityProductPurchase> findByPOCode(String price);

    EntityProductPurchase find(Object paramObject);

    List<EntityProductPurchase> productPOlist(Long param);

    int count();

}
