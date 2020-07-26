/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityCustomer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityCustomerFacadeLocal {

    void createCutomer(EntityCustomer entity);

    void updateCutomer(EntityCustomer entity);

    void deleteCutomer(EntityCustomer entity);

    void removeCutomer(long paramLong);

    EntityCustomer getCutomer(long supplierId);

    List<EntityCustomer> getAllCutomer(int max, int start);

    List<EntityCustomer> searchCutomer(String search, int max, int start);

    EntityCustomer getCutomerName(String supplierName);

    List<EntityCustomer> listCutomerName(String supplierName);

    List<EntityCustomer> getCutomerCode(String supplierCode);

    EntityCustomer findByStatusActive(Long supplier_id);

    EntityCustomer findByCutomerCode(String pramString);

    List<EntityCustomer> listSupplierCode(String paramString);

    EntityCustomer findByCutomerName(String supplierName);

    EntityCustomer findWithParam(String param1, String param2);

    EntityCustomer findById(Object paramObject);

    int count();
}
