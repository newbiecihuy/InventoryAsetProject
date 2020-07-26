/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntitySales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntitySellsFacadeLocal {

    void createSell(EntitySales dataSell);

    void updateSell(EntitySales dataSell);

    void deleteSell(EntitySales dataSell);

    void removeSell(long sellId);

    EntitySales getSell(long sellId);

    List<EntitySales> getAllSells(int max, int start);

//    List<EntityProductSell> getSellId(Object sellId);
    EntitySales find(Object paramObject);

    int count();
}
