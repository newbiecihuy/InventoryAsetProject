/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import com.inventory.aset.model.EntitySettings;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.inventory.aset.facadebean.local.EntitySettingsFacadeLocal;
import javax.persistence.Query;

/**
 *
 * @author newbiecihuy
 */
@Stateless
public class EntitySettingsFacade extends AbstractFacade<EntitySettings> implements EntitySettingsFacadeLocal {

   @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;

    public EntitySettingsFacade() {
        super(EntitySettings.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public EntitySettings createSetting(EntitySettings dataSetting) {
        try {
            em.persist(dataSetting);
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public EntitySettings updateSetting(EntitySettings dataSetting) {
        try {
            em.merge(dataSetting);
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public EntitySettings deleteSetting(EntitySettings dataSetting) {
        try {
            dataSetting.setIsDelete(true);
            em.merge(dataSetting);
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public void removeSetting(long paramLong) {
        try {
            em.remove(getSetting(paramLong));
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }

    }

    @Override
    public EntitySettings getSetting(long settingId) {
        try {
            return (EntitySettings) em.find(EntitySettings.class, settingId);
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<EntitySettings> getAllSettings(int max, int start) {
        try {
//        return em.createNamedQuery("EntitySettings.findAll").getResultList();
            return em.createQuery("SELECT s FROM EntitySettings s").setMaxResults(max).setFirstResult(start).getResultList();
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public EntitySettings findWithParamName(String paramName) {
        try {
//        return em.createQuery("SELECT s FROM EntitySettings s WHERE s.paramName =\"" + paramName + "\"").getResultList();
            String sql = "SELECT s FROM EntitySettings s WHERE s.paramName= :paramName";
            Query query = em.createQuery(sql);
            query.setParameter("paramName", paramName);
            return (EntitySettings) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public EntitySettings find(Object settingObject) {
        try {
            return (EntitySettings) em.find(EntitySettings.class, settingObject);
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return null;
    }

    @Override
    public int count() {
        try {
            Query queryMax = em.createQuery("SELECT COUNT(s) FROM EntitySettings s");
            return Integer.parseInt(queryMax.getSingleResult().toString());
        } catch (Exception e) {
            System.out.println("Something went wrong :" + e.getMessage());
        }
        return 0;
    }

}
