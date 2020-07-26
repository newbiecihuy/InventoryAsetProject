/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityProductDocument;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityProductDocumentFacadeLocal {

    void createProductPurchase(EntityProductDocument dataLocations);

    void updateProductPurchase(EntityProductDocument dataLocations);

    void deleteLProductPurchase(EntityProductDocument dataLocations);

    void removeProductPurchase(long paramLong);

    EntityProductDocument getProductPurchase(long paramLong);

    List<EntityProductDocument> getAllProductPurchase(int param, int max, int start);

//    List<EntityProductPurchase> getIdProductPurchase(long paramLong);
//    List<EntityProductPurchase> findWithPrice(String price);
    EntityProductDocument findByPOCode(String price);

    EntityProductDocument find(Object paramObject);

    List<EntityProductDocument> productPOlist(Long param);

    int count();

}
