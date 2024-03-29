/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityCompanyAddress;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityCompanyAddressFacadeLocal {

    public void createCompanyAddress(EntityCompanyAddress dataCompanyAddress);

    public void updateCompanyAddress(EntityCompanyAddress dataCompanyAddress);

    public void deleteCompanyAddress(EntityCompanyAddress dataCompanyAddress);

    public void removeCompanyAddress(long paramLong);

    public EntityCompanyAddress getCompanyAddress(long paramLong);

    List<EntityCompanyAddress> getAllCompanyAddress(int max, int start);

    EntityCompanyAddress getIdCompanyAddress(String paramString);

    EntityCompanyAddress findWithCompanyAddress(String paramName);

    List<EntityCompanyAddress> findByCompanyAddress(String varName);

}
