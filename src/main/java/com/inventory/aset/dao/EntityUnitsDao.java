/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.entity.EntityUnits;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.dao.local.EntityUnitsDaoLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntityUnitsDao extends AbstractFacade<EntityUnits> implements EntityUnitsDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntityUnitsDao() {
        super(EntityUnits.class);
    }

    protected EntityManager EntityLocationsDao() {
        return em;
    }

    @Override
    public void createUnit(EntityUnits dataUnit) {
        em.persist(dataUnit);
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
    public List<EntityUnits> getAllUnits(int max) {
//       return em.createNamedQuery("EntityUnits.findAll").getResultList();
        return em.createQuery("SELECT u FROM EntityUnits u").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntityUnits> getUnitName(String unitName) {
        return em.createQuery("SELECT u FROM EntityUnits u WHERE u.unitName=  \"" + unitName + "\"").getResultList();
    }

    @Override
    public EntityUnits find(Object paramObject) {
        return (EntityUnits) em.find(EntityUnits.class, paramObject);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
