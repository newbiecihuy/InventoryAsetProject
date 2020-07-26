/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.model.users.EntityPrivilege;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityPrivilegeFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityPrivilegeFacade extends AbstractFacade<EntityPrivilege> implements EntityPrivilegeFacadeLocal {

    @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;

    public EntityPrivilegeFacade() {
        super(EntityPrivilege.class);
    }

    @Override
    protected EntityManager getEntityManager() {
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

}
