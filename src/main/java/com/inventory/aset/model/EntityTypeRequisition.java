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
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_type_permintaan_aset")
@NamedQueries({
    @javax.persistence.NamedQuery(name = "EntityTypeRequisition.findByAll", query = "SELECT t FROM EntityTypeRequisition t")})
public class EntityTypeRequisition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_req_id", columnDefinition = "serial", nullable = false)
    private Long typeReqId;
    @Basic(optional = false)
    @Column(name = "type_req")
    private String typeReq;

    @Basic(optional = false)
    @Column(name = "desc_req")
    private String descReq;

    @Column(name = "input_date")
    @Temporal(TemporalType.DATE)
    private Date inputDate;

    @Basic(optional = false)
    @Column(name = "input_time")
    private String inputTime;

    @Column(name = "pic")
    private String pic;

    public EntityTypeRequisition() {
    }

    public EntityTypeRequisition(Long typeReqId, String typeReq, String descReq, Date inputDate, String inputTime, String pic) {
        this.typeReqId = typeReqId;
        this.typeReq = typeReq;
        this.descReq = descReq;
        this.inputDate = inputDate;
        this.inputTime = inputTime;
        this.pic = pic;
    }

    public Long getTypeReqId() {
        return typeReqId;
    }

    public void setTypeReqId(Long typeReqId) {
        this.typeReqId = typeReqId;
    }

    public String getTypeReq() {
        return typeReq;
    }

    public void setTypeReq(String typeReq) {
        this.typeReq = typeReq;
    }

    public String getDescReq() {
        return descReq;
    }

    public void setDescReq(String descReq) {
        this.descReq = descReq;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
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
        hash += (typeReqId != null ? typeReqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityTypeRequisition)) {
            return false;
        }
        EntityTypeRequisition other = (EntityTypeRequisition) object;
        if ((this.typeReqId == null && other.typeReqId != null) || (this.typeReqId != null && !this.typeReqId.equals(other.typeReqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityTypeRequisition[ typeReqId=" + typeReqId + " ]";
    }

}
