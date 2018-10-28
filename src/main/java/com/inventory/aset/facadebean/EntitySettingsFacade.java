/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.entity.EntitySettings;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntitySettingsFacadeLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntitySettingsFacade extends AbstractFacade<EntitySettings> implements EntitySettingsFacadeLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntitySettingsFacade() {
        super(EntitySettings.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void createSetting(EntitySettings dataSetting) {
        em.persist(dataSetting);
    }

    @Override
    public void updateSetting(EntitySettings dataSetting) {
        em.merge(dataSetting);
    }

    @Override
    public void deleteSetting(EntitySettings dataSetting) {
        em.merge(dataSetting);
    }

    @Override
    public void removeSetting(long paramLong) {
        em.remove(getSetting(paramLong));
    }

    @Override
    public EntitySettings getSetting(long settingId) {
        return (EntitySettings) em.find(EntitySettings.class, settingId);
    }

    @Override
    public List<EntitySettings> getAllSettings(int max) {
//        return em.createNamedQuery("EntitySettings.findAll").getResultList();
        return em.createQuery("SELECT s FROM EntitySettings s").setMaxResults(max).getResultList();
    }

    @Override
    public List<EntitySettings> findWithParamName(String paramName) {
        return em.createQuery("SELECT s FROM EntitySettings s WHERE s.paramName =\"" + paramName + "\"").getResultList();
    }

    @Override
    public EntitySettings find(Object settingObject) {
        return (EntitySettings) em.find(EntitySettings.class, settingObject);
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
