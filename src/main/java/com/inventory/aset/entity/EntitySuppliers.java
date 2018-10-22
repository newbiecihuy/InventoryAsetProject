/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_suppliers")
@NamedQueries({
    @NamedQuery(name = "EntitySuppliers.findAll", query = "SELECT s FROM EntitySuppliers s")
    , @NamedQuery(name = "EntitySuppliers.findBySupplierId", query = "SELECT s FROM EntitySuppliers s WHERE s.supplierId = :supplierId")
    , @NamedQuery(name = "EntitySuppliers.findBySupplierName", query = "SELECT s FROM EntitySuppliers s WHERE s.supplierName = :supplierName")})
public class EntitySuppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id", columnDefinition = "serial", nullable = false)
    private Long supplierId;

    @Basic(optional = false)
    @Column(name = "supplier_code", length = 500)
    private String supplierCode;

    @Basic(optional = false)
    @Column(name = "supplier_name", length = 500)
    private String supplierName;

    @Lob
    @Column(name = "address", length = 512)
    private String address;

    @Basic(optional = false)
    @Column(name = "contact_name", length = 500)
    private String contactName;

    @Basic(optional = false)
    @Column(name = "contact_num", length = 500)
    private String contactNum;

    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "created_time")
    private String createdTime;
    @Basic(optional = false)
    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
    @Column(name = "updated_time")
    private String updatedTime;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive = true;
    @Basic(optional = false)
    @Column(name = "tax")
    private boolean tax = false;
    @Column(name = "is_delete")
    private boolean isDelete = false;
    @Column(name = "pic")
    private String pic;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "supplierId")
    private List<EntityProducts> entityProducts;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "supplierId")
    private List<EntityPurchases> entityPurchases;

    public EntitySuppliers() {
    }

    public EntitySuppliers(Long supplierId, String supplierCode, String supplierName, String address, String contactName, String contactNum, Date createdDate, String createdTime, Date updatedDate, String updatedTime, boolean tax, String pic, List<EntityProducts> entityProducts, List<EntityPurchases> entityPurchases) {
        this.supplierId = supplierId;
        this.supplierCode = supplierCode;
        this.supplierName = supplierName;
        this.address = address;
        this.contactName = contactName;
        this.contactNum = contactNum;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.updatedDate = updatedDate;
        this.updatedTime = updatedTime;
        this.tax = tax;
        this.pic = pic;
        this.entityProducts = entityProducts;
        this.entityPurchases = entityPurchases;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isTax() {
        return tax;
    }

    public void setTax(boolean tax) {
        this.tax = tax;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public List<EntityProducts> getEntityProducts() {
        return entityProducts;
    }

    public void setEntityProducts(List<EntityProducts> entityProducts) {
        this.entityProducts = entityProducts;
    }

    public List<EntityPurchases> getEntityPurchases() {
        return entityPurchases;
    }

    public void setEntityPurchases(List<EntityPurchases> entityPurchases) {
        this.entityPurchases = entityPurchases;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierId != null ? supplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntitySuppliers)) {
            return false;
        }
        EntitySuppliers other = (EntitySuppliers) object;
        if ((this.supplierId == null && other.supplierId != null) || (this.supplierId != null && !this.supplierId.equals(other.supplierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.Suppliers[ supplierId=" + supplierId + " ]";
    }

}
