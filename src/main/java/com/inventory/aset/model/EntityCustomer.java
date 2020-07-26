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
@Table(name = "tbl_customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING, length = 80)
@DiscriminatorValue("Customer")
@NamedQueries({
    @NamedQuery(name = "EntityCustomer.findAll", query = "SELECT ec FROM EntityCustomer ec"),
    @NamedQuery(name = "EntityCustomer.findByStatusActive", query = "SELECT ec FROM EntityCustomer ec WHERE ec.partnerId = :customerId And ec.isActive = 1 And ec.patnerType =\"" + "Customer" + "\"")})
public class EntityCustomer extends EntityPartner implements Serializable {

//  @PreUpdate
//  void updatedAt() {
//    this.updatedAt = new Date();
//  }
    @Column(name = "uuid")
    private String uuid;

    @PrePersist
    @Override
    public void onCreate() {
        this.patnerType = "Customer";
        this.setUuid(UUID.randomUUID().toString());
    }

    public EntityCustomer() {
    }

    public EntityCustomer(String uuid, Long partnerId, String partnerCode, String name, String address, String contactName, String contactNum, Date inputDate, Date updatedDate, int isActive, boolean tax, boolean isDelete, List<EntityProducts> entityProducts, List<EntityDocument> entityDocument, String pic, String patnerType) {
        super(partnerId, partnerCode, name, address, contactName, contactNum, inputDate, updatedDate, isActive, tax, isDelete, entityProducts, entityDocument, pic, patnerType);
        this.uuid = uuid;
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
        if (!(object instanceof EntityCustomer)) {
            return false;
        }
        EntityCustomer other = (EntityCustomer) object;
        return !((this.partnerId == null && other.partnerId != null) || (this.partnerId != null && !this.partnerId.equals(other.partnerId)));
    }

    @Override
    public String toString() {
        return "com.inventory.aset.model.EntityCutomer[ partnerId=" + partnerId + " ]";
    }

}
