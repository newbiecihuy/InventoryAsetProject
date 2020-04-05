/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.users.EntityPrivilege;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityPrivilegeFacadeLocal {

    void createPrivilege(EntityPrivilege dataPrivilege);

    void updatePrivilege(EntityPrivilege dataPrivilege);

    void deletePrivilege(EntityPrivilege dataPrivilege);

    void removePrivilege(long paramLong);

    EntityPrivilege getPrivilege(long paramLong);
    
    List<EntityPrivilege> getAlltPrivilege();
}
