/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.entity.EntitySuppliers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntitySuppliersFacadeLocal {

    void createSuppliers(EntitySuppliers dataSuppliers);

    void updateSuppliers(EntitySuppliers dataSuppliers);

    void deleteSuppliers(EntitySuppliers dataSuppliers);

    void removeSuppliers(long paramLong);

    EntitySuppliers getSuppliers(long supplierId);

    List<EntitySuppliers> getAllSuppliers(int max);

    List<EntitySuppliers> getSupplierName(String supplierName);

    List<EntitySuppliers> getSupplierCode(String supplierCode);

    List<EntitySuppliers> findBySupplierCode(String pramString);

    List<EntitySuppliers> findBySupplierName(String supplierName);

    List<EntitySuppliers> findWithParam(String param1, String param2);

//    List<EntityStock> findWithMinimumStock(int minimumStock);
    EntitySuppliers find(Object paramObject);

    int count();

}
