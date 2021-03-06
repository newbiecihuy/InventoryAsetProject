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
public interface EntityStockFacadeLocal {

    void createStock(EntityStock dataStock);

    void updateStock(EntityStock dataStock);

    void deleteStock(EntityStock dataStock);

    void removeStock(long paramLong);

    EntityStock getStock(long idStock);

    List<EntityStock> getAllStock(int max, int start);

    List<EntityStock> getStock(int stock);

    List<EntityStock> findByIdProduct(Object idProduct);

    List<EntityStock> findProductByStock(String param);

    int count();

//    List<EntityStock> findWithMinimumStock(int minimumStock);
    EntityStock find(Object paramObject);

}
