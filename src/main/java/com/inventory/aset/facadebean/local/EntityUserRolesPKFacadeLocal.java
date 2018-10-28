/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.entity.users.EntityUserRolesPK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityUserRolesPKFacadeLocal {

    void createUserRoles(EntityUserRolesPK dataUserRolesPk);

    void updateUserRoles(EntityUserRolesPK dataUserRolesPk);

    void deleteUserRoles(EntityUserRolesPK dataUserRolesPk);

    void removeUserRoles(long paramLong);

    EntityUserRolesPK getUserRoles(long pramLong);

    List<EntityUserRolesPK> getAllUserRoles();

    List<EntityUserRolesPK> findByUserName(String username);

    List<EntityUserRolesPK> findByRoleName(String roleName);

    EntityUserRolesPK find(Object paramObject);

    int count();
}
