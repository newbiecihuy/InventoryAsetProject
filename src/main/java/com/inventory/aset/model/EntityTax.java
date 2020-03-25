/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_tax")
@NamedQueries({
    @NamedQuery(name = "EntityTax.findAll", query = "SELECT t FROM EntityTax t")
    , @NamedQuery(name = "EntityTax.findByTaxId", query = "SELECT t FROM EntityTax t WHERE t.taxId = :taxId")
    ,@NamedQuery(name = "EntityTax.findByTaxType", query = "SELECT t FROM EntityTax t WHERE t.taxType = :taxType")
    , @NamedQuery(name = "EntityTax.findByTaxValue", query = "SELECT t FROM EntityTax t WHERE t.taxValue = :taxValue")
})
public class EntityTax implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id", columnDefinition = "serial", nullable = false)
    private Long taxId;

    @Basic(optional = false)
    @Column(name = "tax_type", length = 500)
    private String taxType;

    @Basic(optional = false)
    @Column(name = "tax_title")
    private String taxTitle;

    @Basic(optional = false)
    @Column(name = "tax_value")
    private int taxValue;

    public EntityTax() {

    }

    public EntityTax(Long taxId, String taxType, String taxTitle, int taxValue) {
        this.taxId = taxId;
        this.taxType = taxType;
        this.taxTitle = taxTitle;
        this.taxValue = taxValue;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxTitle() {
        return taxTitle;
    }

    public void setTaxTitle(String taxTitle) {
        this.taxTitle = taxTitle;
    }

   

    public int getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(int taxValue) {
        this.taxValue = taxValue;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxId != null ? taxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityTax)) {
            return false;
        }
        EntityTax other = (EntityTax) object;
        if ((this.taxId == null && other.taxId != null) || (this.taxId != null && !this.taxId.equals(other.taxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityTax[ taxId=" + taxId + " ]";
    }

}
