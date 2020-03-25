/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityProductSell;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityProductSellFacadeLocal {

    void createProductSell(EntityProductSell dataProductSell);

    void updateProductSell(EntityProductSell dataProductSell);

    void deleteProductSell(EntityProductSell dataProductSell);

    void removeProductSell(long idProductSell);

    EntityProductSell getProductSell(long idProductSell);

    List<EntityProductSell> getAllProductSell(int max,int start);

//    List<EntityProductSell> getSellId(Object sellId);

    EntityProductSell find(Object paramObject);

    int count();
}
