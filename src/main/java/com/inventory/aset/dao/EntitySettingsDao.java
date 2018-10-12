/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao;

import com.inventory.aset.entity.EntitySettings;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.dao.local.EntitySettingsDaoLocal;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntitySettingsDao extends AbstractFacade<EntitySettings> implements EntitySettingsDaoLocal {

    @PersistenceContext(unitName = "inventoryAsetPU")
    private EntityManager em;

    public EntitySettingsDao() {
        super(EntitySettings.class);
    }

    protected EntityManager EntityCategoriesDao() {
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

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
