/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.users.EntityUserRoles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityUserRolesFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityUserRolesFacade extends AbstractFacade<EntityUserRoles> implements EntityUserRolesFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityUserRolesFacade() {
        super(EntityUserRoles.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createUserRoles(EntityUserRoles dataUserRoles) {
        em.persist(dataUserRoles);
    }

    @Override
    public void updateUserRoles(EntityUserRoles dataUserRoles) {
        em.merge(dataUserRoles);
    }

    @Override
    public void deleteUserRoles(EntityUserRoles dataUserRoles) {
        em.merge(dataUserRoles);
    }

    @Override
    public void removeUserRoles(long paramLong) {
        em.remove(getUserRoles(paramLong));
    }

    @Override
    public EntityUserRoles getUserRoles(long paramLong) {
        return (EntityUserRoles) em.find(EntityUserRoles.class, paramLong);
    }

    @Override
    public List<EntityUserRoles> getAllUserRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityUserRoles> findByUserName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityUserRoles> findByRoleName(String roleName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityUserRoles find(Object paramObject) {
        return (EntityUserRoles) em.find(EntityUserRoles.class, paramObject);
//        EntityUserRoles userRole = (EntityUserRoles) em.find(EntityUserRoles.class, userRolesPK);
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
