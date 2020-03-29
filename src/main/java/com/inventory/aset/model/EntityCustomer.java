/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_customer")
@NamedQueries({
    @NamedQuery(name = "EntityCutomer.findAll", query = "SELECT m FROM EntityCutomer m")
})
public class EntityCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", columnDefinition = "serial", nullable = false)
    private Long idCutomer;

    @Column(name = "cutomer_name")
    private String cutomerName;

    @Lob
    @Column(name = "address", length = 512)
    private String address;

    @Basic(optional = false)
    @Column(name = "contact_name", length = 100)
    private String contactName;

    @Basic(optional = false)
    @Column(name = "contact_num", length = 30)
    private String contactNum;

    @Basic(optional = false)
    @Column(name = "is_active")
    private int isActive = 0;

    @Basic(optional = false)
    @Column(name = "tax")
    private boolean tax = false;
    @Column(name = "is_delete")
    private boolean isDelete = false;
    @Column(name = "pic")
    private String pic;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Temporal(TemporalType.TIME)
    @Column(name = "created_time")
    private Date createdTime;

    @PrePersist
    void createdAt() {
        this.createdDate = new Date();
        this.createdTime = new Date();
    }

//  @PreUpdate
//  void updatedAt() {
//    this.updatedAt = new Date();
//  }
    public EntityCustomer() {
    }

    public EntityCustomer(Long idCutomer, String cutomerName, String address, String contactName, String contactNum, String pic, Date createdDate, Date createdTime) {
        this.idCutomer = idCutomer;
        this.cutomerName = cutomerName;
        this.address = address;
        this.contactName = contactName;
        this.contactNum = contactNum;
        this.pic = pic;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }

    public Long getIdCutomer() {
        return idCutomer;
    }

    public void setIdCutomer(Long idCutomer) {
        this.idCutomer = idCutomer;
    }

    public String getCutomerName() {
        return cutomerName;
    }

    public void setCutomerName(String cutomerName) {
        this.cutomerName = cutomerName;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCutomer != null ? idCutomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityCustomer)) {
            return false;
        }
        EntityCustomer other = (EntityCustomer) object;
        return !((this.idCutomer == null && other.idCutomer != null) || (this.idCutomer != null && !this.idCutomer.equals(other.idCutomer)));
    }

    @Override
    public String toString() {
        return "com.inventory.aset.model.EntityCutomer[ idCutomer=" + idCutomer + " ]";
    }

}
