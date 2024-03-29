/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityCategories;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityCategoriesFacadeLocal {

    EntityCategories createCategories(EntityCategories dataCategories);

    void updateCategories(EntityCategories dataCategories);

    void deleteCategories(EntityCategories dataCategories);

    void removeCategories(long paramLong);

    EntityCategories getCategories(long categoryId);

    List<EntityCategories> getAllCategories(int max, int start);

    List<EntityCategories> searchCategories(String search, int max, int start);

    EntityCategories getIdCategories(String paramString);

    List<EntityCategories> findWithCategoriesName(String categoriesName);
    
    EntityCategories findCategoriesName(String categoriesName);

    List<EntityCategories> findByCategoriesName(String categoriesName);

    EntityCategories find(Object paramObject);

    int count();

}
