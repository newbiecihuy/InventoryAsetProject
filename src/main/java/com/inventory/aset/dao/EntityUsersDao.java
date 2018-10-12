/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityUsersLocal;
import com.inventory.aset.entity.users.EntityUsers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityUsersDao extends AbstractFacade<EntityUsers> implements EntityUsersLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;
    private Long idUser;

    public EntityUsersDao() {
        super(EntityUsers.class);
    }

    protected EntityManager EntityCategoriesDao() {
        return em;
    }

    @Override
    public void createUser(EntityUsers dataUser) {
        em.persist(dataUser);
        em.flush();
        this.idUser = dataUser.getUserId();
    }

    @Override
    public Long getIdUser() {
        return idUser;
    }

    @Override
    public void updateUser(EntityUsers dataUser) {
        em.merge(dataUser);
    }

    @Override
    public void deleteUser(EntityUsers dataUser) {
        em.merge(dataUser);
    }

    @Override
    public void removeUser(long paramLong) {
        em.remove(getUsers(paramLong));
    }

    @Override
    public EntityUsers getUsers(long userId) {
        return em.find(EntityUsers.class, userId);
    }

    @Override
    public List<EntityUsers> getAllUsers(int max) {
//        return em.createNamedQuery("EntityUsers.findAll").getResultList();
        return em.createQuery("SELECT u FROM EntityUserss u").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityUsers> findByUsername(String username) {
        return em.createQuery("SELECT u FROM EntityUsers u WHERE u.username =  \"" + username + "\"").getResultList();
    }

    @Override
    public List<EntityUsers> findByRoleName(String varName) {
        return em.createQuery("SELECT Distinct us.roleName  FROM EntityUsers us WHERE us.roleName LIKE \"" + varName + "%\" ").getResultList();
    }

    @Override
    public EntityUsers find(Object paramObject) {
        return (EntityUsers) em.find(EntityUsers.class, paramObject);
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
