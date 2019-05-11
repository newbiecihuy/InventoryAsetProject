/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.entity.users.EntityUsers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityUsersFacadeLocal {

    void createUser(EntityUsers dataUser);

    void updateUser(EntityUsers dataUser);

    void deleteUser(EntityUsers dataUser);

    void removeUser(long paramLong);

    EntityUsers getUsers(long categoryId);

    public Long getIdUser();

    List<EntityUsers> getAllUsers(int max);

    List<EntityUsers> getUsers();
    
    List<EntityUsers> checkUsers(String userName, String passWord) ;

    List<EntityUsers> findByUsername(String username);

    public List<EntityUsers> findByRoleName(String varName);

    EntityUsers find(Object paramObject);

    int count();

   

}
