/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityUserRolesPKDaoLocal;
import com.inventory.aset.entity.users.EntityUserRolesPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityUserRolesPKDao extends AbstractFacade<EntityUserRolesPK> implements EntityUserRolesPKDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityUserRolesPKDao() {
        super(EntityUserRolesPK.class);
    }

    protected EntityManager EntityCategoriesDao() {
        return em;
    }

    @Override
    public void createUserRoles(EntityUserRolesPK dataUserRolesPK) {
        em.persist(dataUserRolesPK);
    }

    @Override
    public void updateUserRoles(EntityUserRolesPK dataUserRolesPK) {
        em.merge(dataUserRolesPK);
    }

    @Override
    public void deleteUserRoles(EntityUserRolesPK dataUserRolesPK) {
        em.merge(dataUserRolesPK);
    }

    @Override
    public void removeUserRoles(long paramLong) {
        em.remove(getUserRoles(paramLong));
    }

    @Override
    public EntityUserRolesPK getUserRoles(long paramLong) {
        return (EntityUserRolesPK) em.find(EntityUserRolesPK.class, paramLong);
    }

    @Override
    public List<EntityUserRolesPK> getAllUserRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityUserRolesPK> findByUserName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityUserRolesPK> findByRoleName(String roleName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityUserRolesPK find(Object paramObject) {
        return (EntityUserRolesPK) em.find(EntityUserRolesPK.class, paramObject);
//        EntityUserRoles userRole = (EntityUserRoles) em.find(EntityUserRoles.class, userRolesPK);
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
