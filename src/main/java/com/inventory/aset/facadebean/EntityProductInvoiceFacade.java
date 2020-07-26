/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.facadebean;

import com.inventory.aset.controller.util.Constants;
import javax.ejb.Stateful;
import com.inventory.aset.facadebean.local.EntityProductInvoiceFacadeLocal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author newbiecihuy
 */
@Stateful
public class EntityProductInvoiceFacade implements EntityProductInvoiceFacadeLocal {
    @PersistenceContext(unitName = Constants.JPA_UNIT_NAME)
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
