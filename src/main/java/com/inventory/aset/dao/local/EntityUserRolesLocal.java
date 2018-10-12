/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao.local;

import com.inventory.aset.entity.users.EntityUserRoles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityUserRolesLocal {

    void createUserRoles(EntityUserRoles dataUserRoles);

    void updateUserRoles(EntityUserRoles dataUserRoles);

    void deleteUserRoles(EntityUserRoles dataUserRoles);

    void removeUserRoles(long paramLong);

    EntityUserRoles getUserRoles(long pramLong);

    List<EntityUserRoles> getAllUserRoles();

    List<EntityUserRoles> findByUserName(String username);

    List<EntityUserRoles> findByRoleName(String roleName);

    EntityUserRoles find(Object paramObject);

    int count();
}
