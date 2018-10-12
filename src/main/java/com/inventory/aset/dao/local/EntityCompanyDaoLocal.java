/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao.local;

import com.inventory.aset.entity.EntityCompany;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityCompanyDaoLocal {

    void createCompany(EntityCompany dataCompany);

    void updateCompany(EntityCompany dataCompany);

    void deleteCompany(EntityCompany dataCompany);

    void removeCompany(long paramLong);

    EntityCompany getCompany(long categoryId);

    List<EntityCompany> getAllCompany(int max);

    List<EntityCompany> getIdCompany(String paramString);

    List<EntityCompany> findWithCompanyName(String categoriesName);

    List<EntityCompany> findByCompanyName(String varName);

}
