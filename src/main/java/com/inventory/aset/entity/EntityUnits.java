/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_units")
@NamedQueries({
    @NamedQuery(name = "EntityUnits.findAll", query = "SELECT u FROM EntityUnits u")
    , @NamedQuery(name = "EntityUnits.findByUnitId", query = "SELECT u FROM EntityUnits u WHERE u.unitId = :unitId")
    , @NamedQuery(name = "EntityUnits.findByUnitName", query = "SELECT u FROM EntityUnits u WHERE u.unitName = :unitName")
})
public class EntityUnits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id", columnDefinition = "serial", nullable = false)
    private Long unitId;
    @Basic(optional = false)
    @Column(name = "unit_name", nullable = false, length = 15)
    private String unitName;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "create_time")
    private String createdTime;
    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Column(name = "update_time")
    private String updateTime;
    @Column(name = "is_delete")
    private boolean isDelete = false;

    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "unitId")
    private Collection<EntityProductPurchase> entityProductPurchase;
    @Column(name = "pic")
    private String pic;

    public EntityUnits() {
    }

    public EntityUnits(Long unitId, String unitName, Date createdDate, String createdTime, Date updateDate, String updateTime, Collection<EntityProductPurchase> entityProductPurchase, String pic) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.entityProductPurchase = entityProductPurchase;
        this.pic = pic;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Collection<EntityProductPurchase> getEntityProductPurchase() {
        return entityProductPurchase;
    }

    public void setEntityProductPurchase(Collection<EntityProductPurchase> entityProductPurchase) {
        this.entityProductPurchase = entityProductPurchase;
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
        hash += (unitId != null ? unitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityUnits)) {
            return false;
        }
        EntityUnits other = (EntityUnits) object;
        if ((this.unitId == null && other.unitId != null) || (this.unitId != null && !this.unitId.equals(other.unitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.Units[ unitId=" + unitId + " ]";
    }

}
