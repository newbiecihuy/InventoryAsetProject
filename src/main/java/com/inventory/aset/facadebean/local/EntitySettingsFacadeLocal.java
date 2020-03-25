/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntitySettings;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntitySettingsFacadeLocal {

    void createSetting(EntitySettings dataSetting);

    void updateSetting(EntitySettings dataSetting);

    void deleteSetting(EntitySettings dataSetting);

    void removeSetting(long paramLong);

    EntitySettings getSetting(long settingId);

    List<EntitySettings> getAllSettings(int max, int start);

    List<EntitySettings> findWithParamName(String paramName);

    EntitySettings find(Object paramObject);

    int count();
}
