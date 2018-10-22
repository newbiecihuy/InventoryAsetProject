/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao.local;

import com.inventory.aset.entity.EntityTax;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityTaxDaoLocal {

    void createTax(EntityTax dataTax);

    void updateTax(EntityTax dataTax);

    void deleteTax(EntityTax dataTax);

    void removeTax(long paramId);

    EntityTax getTax(long paramId);

    List<EntityTax> getAllTax(int max);

    List<EntityTax> getTaxByType(String taxType);
    
    EntityTax find(Object paramObject);

    int count();

}
