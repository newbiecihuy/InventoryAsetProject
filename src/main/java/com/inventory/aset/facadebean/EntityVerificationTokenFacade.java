/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.model.users.EntityVerificationToken;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityVerificationTokenFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityVerificationTokenFacade extends AbstractFacade<EntityVerificationToken> implements EntityVerificationTokenFacadeLocal {

   @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;

    public EntityVerificationTokenFacade() {
        super(EntityVerificationToken.class);
    }

    @Override
    protected EntityManager getEntityManager() {
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
    public int count() {
       Query queryMax = em.createQuery("SELECT COUNT(t) FROM EntityVerificationToken t");
        return Integer.parseInt(queryMax.getSingleResult().toString());
    }

}
