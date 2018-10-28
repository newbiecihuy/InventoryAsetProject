/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.entity.users.EntityVerificationToken;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityVerificationTokenFacadeLocal {
    
    void createVerificationToken(EntityVerificationToken dataVerificationToken);

    void updateVerificationToken(EntityVerificationToken dataVerificationToken);

    void deleteVerificationTokens(EntityVerificationToken dataVerificationToken);

    void removeVerificationToken(long paramLong);

    EntityVerificationToken getVerificationToken(long paramLong);

    List<EntityVerificationToken> getAllVerificationToken();

    List<EntityVerificationToken> getIdCategories(String paramString);
}
