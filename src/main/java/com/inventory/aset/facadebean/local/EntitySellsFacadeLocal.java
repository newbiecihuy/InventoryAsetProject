/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntitySells;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntitySellsFacadeLocal {

    void createSell(EntitySells dataSell);

    void updateSell(EntitySells dataSell);

    void deleteSell(EntitySells dataSell);

    void removeSell(long sellId);

    EntitySells getSell(long sellId);

    List<EntitySells> getAllSells(int max, int start);

//    List<EntityProductSell> getSellId(Object sellId);
    EntitySells find(Object paramObject);

    int count();
}
