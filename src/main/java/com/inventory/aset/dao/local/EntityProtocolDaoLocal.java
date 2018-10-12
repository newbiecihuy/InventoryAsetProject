/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.dao.local;

import com.inventory.aset.entity.EntityProtocol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author newbiecihuy
 */
@Local
public interface EntityProtocolDaoLocal {

    void createProtocol(EntityProtocol dataProtocol);

    void updateProtocol(EntityProtocol dataProtocol);

    void deleteProtocol(EntityProtocol dataProtocol);

    void removeProtocol(long paramLong);

    EntityProtocol getProtocol(long paramLong);

    List<EntityProtocol> getAllProtocol(int max);

    List<EntityProtocol> getEmail(String paramString);

    List<EntityProtocol> findWithEmail(String paramString);

    EntityProtocol find(Object paramObject);

    int count();
}
