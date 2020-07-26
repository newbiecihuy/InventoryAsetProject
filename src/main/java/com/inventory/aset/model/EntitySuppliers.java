/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_suppliers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, length = 80)
@DiscriminatorValue("Supplier")
@NamedQueries({
    @NamedQuery(name = "EntitySuppliers.findAll", query = "SELECT s FROM EntitySuppliers s"),
    @NamedQuery(name = "EntitySuppliers.findByStatusActive", query = "SELECT s FROM EntitySuppliers s WHERE s.partnerId = :partnerId And s.isActive = 1 And s.patnerType =\"" + "Supplier" + "\"")})
public class EntitySuppliers extends EntityPartner implements Serializable {

    @Column(name = "uuid")
    private String uuid;

    @PrePersist
    @Override
    public void onCreate() {
        this.patnerType = "supplier";
        this.setUuid(UUID.randomUUID().toString());
    }

    public EntitySuppliers() {
    }

    public EntitySuppliers(String uuid, Long partnerId, String partnerCode, String name, String address, String contactName, String contactNum, Date inputDate, Date updatedDate, int isActive, boolean tax, boolean isDelete, List<EntityProducts> entityProducts, List<EntityDocument> entityDocument, String pic, String patnerType) {
        super(partnerId, partnerCode, name, address, contactName, contactNum, inputDate, updatedDate, isActive, tax, isDelete, entityProducts, entityDocument, pic, patnerType);
        this.uuid = uuid;
    }

    public String getPatnerType() {
        return patnerType;
    }

    public void setPatnerType(String patnerType) {
        this.patnerType = patnerType;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
                .replaceAll("<script>(.*?)</script>", "")
                .replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "")
                .replaceAll("(?i)<.*?\\s+on.*?/>", "")
                .replaceAll("(?i)<.*?\\s+on.*?>", "")
                .replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "")
                .replaceAll("vbscript", "")
                .replaceAll("encode", "")
                .replaceAll("decode", "")
                .replaceAll("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", "")
                .replaceAll("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", "")
                .replaceAll("</script>", "")
                .replaceAll("<script(.*?)>", "")
                .replaceAll("eval\\((.*?)\\)", "")
                .replaceAll("expression\\((.*?)\\)", "")
                .replaceAll("['\":<>\\[\\],-]", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
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

    public List<EntityProducts> getEntityProducts() {
        return entityProducts;
    }

    public void setEntityProducts(List<EntityProducts> entityProducts) {
        this.entityProducts = entityProducts;
    }

    public List<EntityDocument> getEntityDocument() {
        return entityDocument;
    }

    public void setEntityDocument(List<EntityDocument> entityDocument) {
        this.entityDocument = entityDocument;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partnerId != null ? partnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntitySuppliers)) {
            return false;
        }
        EntitySuppliers other = (EntitySuppliers) object;
        if ((this.partnerId == null && other.partnerId != null) || (this.partnerId != null && !this.partnerId.equals(other.partnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.Suppliers[ partnerId=" + partnerId + " ]";
    }

}
