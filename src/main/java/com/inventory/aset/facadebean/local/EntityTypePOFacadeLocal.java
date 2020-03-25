/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityTypePO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityTypePOFacadeLocal {

    void createTypePO(EntityTypePO dataTypePO);

    void updateTypePO(EntityTypePO dataTypePO);

    void deleteTypePO(EntityTypePO dataTypePO);

    void removeTypePO(long paramLong);

    EntityTypePO getTypePO(long paramlong);

    List<EntityTypePO> getAllTypePO(int max, int start);

    List<EntityTypePO> getByTypePO(String paramName);

    List<EntityTypePO> findWithTypePo(String paramName);

    List<EntityTypePO> findByTypePo(String varName);

    EntityTypePO find(Object object);

    int count();

}
