/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "tbl_type_po")
@NamedQueries({
    @NamedQuery(name = "EntityTypePO.findAll", query = "SELECT c FROM EntityTypePO c"),
    @NamedQuery(name = "EntityTypePO.findByTypePOId", query = "SELECT c FROM EntityTypePO c WHERE c.typePOId = :typePOId")
})
public class EntityTypePO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_po_id", columnDefinition = "serial", nullable = false)
    private Long typePOId;

    @Basic(optional = false)
    @Column(name = "type_po")
    private String typePo;

    @Basic(optional = false)
    @Column(name = "payment_term")
    private String paymentTerm;

    @Column(name = "input_date")
    @Temporal(TemporalType.DATE)
    private Date inputDate;

    @Basic(optional = false)
    @Column(name = "input_time")
    private String inputTime;

    @Column(name = "pic")
    private String pic;

    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "typePOId")
    private List<EntityPurchases> entityPurchases;

    public EntityTypePO() {

    }

    public EntityTypePO(Long typePOId, String typePo, String paymentTerm, Date inputDate, String inputTime, String pic, List<EntityPurchases> entityPurchases) {
        this.typePOId = typePOId;
        this.typePo = typePo;
        this.paymentTerm = paymentTerm;
        this.inputDate = inputDate;
        this.inputTime = inputTime;
        this.pic = pic;
        this.entityPurchases = entityPurchases;
    }

    public Long getTypePOId() {
        return typePOId;
    }

    public void setTypePOId(Long typePOId) {
        this.typePOId = typePOId;
    }

    public String getTypePo() {
        return typePo;
    }

    public void setTypePo(String typePo) {
        this.typePo = typePo;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
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

    public List<EntityPurchases> getEntityPurchases() {
        return entityPurchases;
    }

    public void setEntityPurchases(List<EntityPurchases> entityPurchases) {
        this.entityPurchases = entityPurchases;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typePOId != null ? typePOId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityTypePO)) {
            return false;
        }
        EntityTypePO other = (EntityTypePO) object;
        if ((this.typePOId == null && other.typePOId != null) || (this.typePOId != null && !this.typePOId.equals(other.typePOId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.dao.EntityTypePO[ typePOId=" + typePOId + " ]";
    }

}
