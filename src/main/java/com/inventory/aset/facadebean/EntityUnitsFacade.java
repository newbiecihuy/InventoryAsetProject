/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.model.EntityUnits;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntityUnitsFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityUnitsFacade extends AbstractFacade<EntityUnits> implements EntityUnitsFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityUnitsFacade() {
        super(EntityUnits.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
//    @Override
//    public void createUnit(EntityUnits dataUnit) {
//        em.persist(dataUnit);
//    }

    @Override
    public EntityUnits createUnit(EntityUnits dataUnit) {
        em.persist(dataUnit);
        em.flush();

        return dataUnit;
    }

    @Override
    public void updateUnit(EntityUnits dataUnit) {
        em.merge(dataUnit);
    }

    @Override
    public void deleteUnit(EntityUnits dataUnit) {
        em.merge(dataUnit);
    }

    @Override
    public void removeUnit(long paramLong) {
        em.remove(getUnit(paramLong));
    }

    @Override
    public EntityUnits getUnit(long unitId) {
        return (EntityUnits) em.find(EntityUnits.class, unitId);
    }

    @Override
    public List<EntityUnits> getAllUnits(int max, int start) {
//       return em.createNamedQuery("EntityUnits.findAll").getResultList();
        return em.createQuery("SELECT u FROM EntityUnits u").setMaxResults(max).setFirstResult(start).getResultList();
    }

    @Override
    public List<EntityUnits> getUnitName(String unitName) {
        return em.createQuery("SELECT u FROM EntityUnits u WHERE u.unitName = :unitName ")
                .setParameter("unitName", unitName)
                .getResultList();
    }

    @Override
    public EntityUnits find(Object paramObject) {
        return (EntityUnits) em.find(EntityUnits.class, paramObject);
    }
}
