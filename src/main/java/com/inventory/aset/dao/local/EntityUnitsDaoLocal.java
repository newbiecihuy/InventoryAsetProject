/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao.local;

import com.inventory.aset.entity.EntityUnits;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityUnitsDaoLocal {

    EntityUnits createUnit(EntityUnits dataUnit);

    void updateUnit(EntityUnits dataUnit);

    void deleteUnit(EntityUnits dataUnit);

    void removeUnit(long paramLong);

    EntityUnits getUnit(long unitId);

    List<EntityUnits> getAllUnits(int max);

    List<EntityUnits> getUnitName(String unitName);

//    List<EntityStock> findWithMinimumStock(int minimumStock);
    EntityUnits find(Object paramObject);

    int count();
}
