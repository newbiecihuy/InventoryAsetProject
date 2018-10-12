/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.dao.local.EntityVerificationTokenLocal;
import com.inventory.aset.entity.users.EntityVerificationToken;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityVerificationTokenDao extends AbstractFacade<EntityVerificationToken> implements EntityVerificationTokenLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityVerificationTokenDao() {
        super(EntityVerificationToken.class);
    }

    protected EntityManager EntityCategoriesDao() {
        return em;
    }

    @Override
    public void createVerificationToken(EntityVerificationToken dataVerificationToken) {
        em.persist(dataVerificationToken);
    }

    @Override
    public void updateVerificationToken(EntityVerificationToken dataVerificationToken) {
        em.merge(dataVerificationToken);
    }

    @Override
    public void deleteVerificationTokens(EntityVerificationToken dataVerificationToken) {
        em.merge(dataVerificationToken);
    }

    @Override
    public void removeVerificationToken(long paramLong) {
        em.remove(getVerificationToken(paramLong));
    }

    @Override
    public EntityVerificationToken getVerificationToken(long paramLong) {
        return (EntityVerificationToken) em.find(EntityVerificationToken.class, paramLong);
    }

    @Override
    public List<EntityVerificationToken> getAllVerificationToken() {
        return em.createNamedQuery("EntityVerificationToken.findAll").getResultList();
    }

    @Override
    public List<EntityVerificationToken> getIdCategories(String paramString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
