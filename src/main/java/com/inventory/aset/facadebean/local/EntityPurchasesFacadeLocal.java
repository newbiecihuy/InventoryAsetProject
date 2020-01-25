/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.entity.EntityPurchases;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityPurchasesFacadeLocal {

    void createPurchases(EntityPurchases dataPurchases);

    void updatePurchases(EntityPurchases dataPurchases);

    void deletePurchases(EntityPurchases dataPurchases);

    void removePurchases(long purchaseId);

    EntityPurchases getPurchases(long purchaseId);

    List<EntityPurchases> getAllPurchases(int max, int start);

    List<EntityPurchases> searchPurchases(String search, int max, int start);

//    List<EntityProductSell> getSellId(Object sellId);
    EntityPurchases find(Object paramObject);

    List<EntityPurchases> findByPOCode(String pramString);

    List<EntityPurchases> findByTransportMode(String pramString);

    List<EntityPurchases> findByRfqNumber(String pramString);

    List<EntityPurchases> getByPOCode(String pramString);

//    List<EntityPurchases> getByTypePO(String pramString);
  EntityPurchases findByNoPo(Date inputDate, String inputTime);

    int count();

}
