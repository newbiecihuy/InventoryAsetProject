/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntityCompanyAddress;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityCompanyAddressFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateful
public class EntityCompanyAddressFacade extends AbstractFacade<EntityCompanyAddress> implements EntityCompanyAddressFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityCompanyAddressFacade() {
        super(EntityCompanyAddress.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createCompanyAddress(EntityCompanyAddress dataCompanyAddress) {
        em.persist(dataCompanyAddress);
    }

    @Override
    public void updateCompanyAddress(EntityCompanyAddress dataCompanyAddress) {
        em.merge(dataCompanyAddress);
    }

    @Override
    public void deleteCompanyAddress(EntityCompanyAddress dataCompanyAddress) {
        em.merge(dataCompanyAddress);
    }

    @Override
    public void removeCompanyAddress(long paramLong) {
        em.remove(getCompanyAddress(paramLong));
    }

    @Override
    public EntityCompanyAddress getCompanyAddress(long paramLong) {
        return (EntityCompanyAddress) em.find(EntityCompanyAddress.class, paramLong);
    }

    @Override
    public List<EntityCompanyAddress> getAllCompanyAddress(int max) {
//        return em.createNamedQuery("EntityCompanyAddress.findAll").getResultList();
        return em.createQuery("SELECT c FROM EntityCompanyAddress c ").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityCompanyAddress> getIdCompanyAddress(String paramString) {
        return em.createNamedQuery("EntityCompanyAddress.findByIdCompanyAdress").getResultList();
    }

    @Override
    public List<EntityCompanyAddress> findWithCompanyAddress(String paramName) {
        return em.createQuery("SELECT c FROM EntityCompanyAddress c WHERE c.address =  \"" + paramName + "\"").getResultList();
    }

    @Override
    public List<EntityCompanyAddress> findByCompanyAddress(String varName) {
        return em.createQuery("SELECT Distinct c.address  FROM EntityCompanyAddress c WHERE c.address LIKE \"" + varName + "%\" ").getResultList();
    }

}
