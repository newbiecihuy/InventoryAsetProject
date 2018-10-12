/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityPrivilegeLocal;
import com.inventory.aset.entity.users.EntityPrivilege;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityPrivilegeDao extends AbstractFacade<EntityPrivilege> implements EntityPrivilegeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityPrivilegeDao() {
        super(EntityPrivilege.class);
    }

    protected EntityManager EntityCategoriesDao() {
        return em;
    }

    @Override
    public void createPrivilege(EntityPrivilege dataPrivilege) {
        em.persist(dataPrivilege);
    }

    @Override
    public void updatePrivilege(EntityPrivilege dataPrivilege) {
        em.merge(dataPrivilege);
    }

    @Override
    public void deletePrivilege(EntityPrivilege dataPrivilege) {
        em.merge(dataPrivilege);
    }

    @Override
    public void removePrivilege(long paramLong) {
        em.remove(getPrivilege(paramLong));
    }

    @Override
    public EntityPrivilege getPrivilege(long paramLong) {
        return (EntityPrivilege) em.find(EntityPrivilege.class, paramLong);
    }
   @Override
    public List<EntityPrivilege> getAlltPrivilege() {
        return em.createNamedQuery("EntityPrivilege.findAll").getResultList();
    }
    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

}
