/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean.local;

import com.inventory.aset.model.EntityProtocol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityProtocolFacadeLocal {

    void createProtocol(EntityProtocol dataProtocol);

    void updateProtocol(EntityProtocol dataProtocol);

    void deleteProtocol(EntityProtocol dataProtocol);

    void removeProtocol(long paramLong);

    EntityProtocol getProtocol(long paramLong);

    List<EntityProtocol> getAllProtocol(int max, int start);

   EntityProtocol getEmail(String paramString);

    List<EntityProtocol> findWithEmail(String paramString);

    EntityProtocol find(Object paramObject);

    int count();
}
