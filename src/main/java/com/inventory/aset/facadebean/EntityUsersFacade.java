/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.model.users.EntityUsers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityUsersFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityUsersFacade extends AbstractFacade<EntityUsers> implements EntityUsersFacadeLocal {

   @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;
    private Long idUser;

    public EntityUsersFacade() {
        super(EntityUsers.class);
    }

    @Override
    protected EntityManager getEntityManager() {
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
    public List<EntityUsers> getAllUsers(int max, int start) {
        return em.createNamedQuery("EntityUsers.findAll").setMaxResults(max).setFirstResult(start).getResultList();
//        return em.createQuery("SELECT u FROM EntityUsers u").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityUsers> getUsers() {
//        return em.createNamedQuery("EntityUsers.findAll").setMaxResults(max).getResultList();
        return em.createQuery("SELECT u FROM EntityUsers u").getResultList();
    }

    @Override
    public List<EntityUsers> checkUsers(String userName, String passWord) {
        return em.createQuery("SELECT us.id FROM EntityUsers us WHERE us.userPass = :passWord AND "
                + " us.userName = :userName  AND "
                + " us.isActive =\"" + true + "\" ")
                .setParameter("userName", userName)                
                .setParameter("passWord", passWord)
                .getResultList();
    }

    @Override
    public List<EntityUsers> findByUsername(String username) {
        return em.createQuery("SELECT u FROM EntityUsers u WHERE u.username = :username ")
                .setParameter("username", username)
                .getResultList();
    }

    @Override
    public List<EntityUsers> findByRoleName(String varName) {
        return em.createQuery("SELECT Distinct us.roleName  FROM EntityUsers us WHERE us.roleName LIKE  :varName ")
                .setParameter("varName", varName + "%")
                .getResultList();
    }

    @Override
    public EntityUsers find(Object paramObject) {
        return (EntityUsers) em.find(EntityUsers.class, paramObject);
    }

    @Override
    public int count() {
        Query queryMax = em.createQuery("SELECT COUNT(us) FROM EntityUsers us");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
