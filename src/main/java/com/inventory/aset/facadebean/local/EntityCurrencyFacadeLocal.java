/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityCurrency;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityCurrencyFacadeLocal {

    void createCurrencies(EntityCurrency dataCurrency);

    void updateCurrencies(EntityCurrency dataCurrency);

    void deleteCurrencies(EntityCurrency dataCurrency);

    void removeCurrenciess(long paramLong);

    EntityCurrency getCurrenciess(long paramLong);

    List<EntityCurrency> getAllCurrencies(int max, int start);

    List<EntityCurrency> getCurrencyRate(String paramString);

    EntityCurrency findWithCurrencyName(String paramString);

    EntityCurrency find(Object paramObject);

    int count();
}
