/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntitySuppliers;
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

    List<EntitySuppliers> getAllSuppliers(int max, int start);

    List<EntitySuppliers> searchSuppliers(String search, int max, int start);

    EntitySuppliers getSupplierName(String supplierName);
    
    List<EntitySuppliers> listSupplierName(String supplierName);

    List<EntitySuppliers> getSupplierCode(String supplierCode);
    
    EntitySuppliers cekSupplierCode(String supplierCode);

//    List<EntitySuppliers> findByStatusActive(Long supplier_id);
    EntitySuppliers findByStatusActive(Long supplier_id);

    List<EntitySuppliers> findBySupplierCode(String pramString);

    List<EntitySuppliers> findBySupplierName(String supplierName);

    EntitySuppliers findWithParam(String param1, String param2);

//    List<EntityStock> findWithMinimumStock(int minimumStock);
    EntitySuppliers find(Object paramObject);

    int count();

}
