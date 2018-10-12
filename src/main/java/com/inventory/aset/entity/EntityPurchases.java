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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_purchase")
@NamedQueries({
    @NamedQuery(name = "EntityPurchases.findAll", query = "SELECT c FROM EntityPurchases c")
    ,
    @NamedQuery(name = "EntityPurchases.findByPurchaseId", query = "SELECT c FROM EntityPurchases c WHERE c.purchaseId = :purchaseId")
})
public class EntityPurchases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", columnDefinition = "serial", nullable = false)
    private Long purchaseId;

    @Basic(optional = false)
    @Column(name = "purchase_code")
    private String purchaseCode;

    @Basic(optional = false)
    @Column(name = "purchase_desc")
    private String purchaseDesc;

    @Basic(optional = false)
    @Column(name = "transport_mode")
    private String transportMode;

    @Basic(optional = false)
    @Column(name = "rfq_number")
    private String rfqNumber;

    @Basic(optional = false)
    @Column(name = "quotation_number")
    private String quotationNumber;

    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "purchaseId")
    private List<EntityProductPurchase> entityProductPurchase;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private EntitySuppliers supplierId;

    @ManyToOne
    @JoinColumn(name = "type_po_id", referencedColumnName = "type_po_id")
    private EntityTypePO typePOId;

    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @Column(name = "time")
    private String time;

    @Column(name = "input_date")
    @Temporal(TemporalType.DATE)
    private Date inputDate;

    @Basic(optional = false)
    @Column(name = "input_time")
    private String inputTime;

    @Basic(optional = false)
    @Column(name = "date_edit")
    @Temporal(TemporalType.DATE)
    private Date dateEdit;

    @Basic(optional = false)
    @Column(name = "time_edit")
    private String timeEdit;

//    @Basic(optional = false)
//    @Column(name = "po_type")
//    private String poType;
//
//    @Basic(optional = false)
//    @Column(name = "payment_term")
//    private String paymentTerm;

    @Basic(optional = false)
    @Column(name = "delivery_term")
    private String deliveryTerm;

    @Basic(optional = false)
    @Column(name = "delivery_point")
    private String deliveryPoint;

    @Basic(optional = false)
    @Column(name = "invoice_to")
    private String invoiceTo;

    @Column(name = "is_approve")
    private boolean isApprove = false;

    @Column(name = "is_delete")
    private boolean isDelete = false;

    @Column(name = "status_po")
    private String statusPo = "No Item";

    @Column(name = "appprove_by")
    private String appproveBy;

    @Column(name = "pic")
    private String pic;

    public EntityPurchases() {

    }

    public EntityPurchases(Long purchaseId, String purchaseCode, String purchaseDesc, String transportMode, String rfqNumber, String quotationNumber, List<EntityProductPurchase> entityProductPurchase, EntitySuppliers supplierId, EntityTypePO typePOId, Date date, String time, Date inputDate, String inputTime, Date dateEdit, String timeEdit, String deliveryTerm, String deliveryPoint, String invoiceTo, String appproveBy, String pic) {
        this.purchaseId = purchaseId;
        this.purchaseCode = purchaseCode;
        this.purchaseDesc = purchaseDesc;
        this.transportMode = transportMode;
        this.rfqNumber = rfqNumber;
        this.quotationNumber = quotationNumber;
        this.entityProductPurchase = entityProductPurchase;
        this.supplierId = supplierId;
        this.typePOId = typePOId;
        this.date = date;
        this.time = time;
        this.inputDate = inputDate;
        this.inputTime = inputTime;
        this.dateEdit = dateEdit;
        this.timeEdit = timeEdit;
        this.deliveryTerm = deliveryTerm;
        this.deliveryPoint = deliveryPoint;
        this.invoiceTo = invoiceTo;
        this.appproveBy = appproveBy;
        this.pic = pic;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }

    public String getPurchaseDesc() {
        return purchaseDesc;
    }

    public void setPurchaseDesc(String purchaseDesc) {
        this.purchaseDesc = purchaseDesc;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getRfqNumber() {
        return rfqNumber;
    }

    public void setRfqNumber(String rfqNumber) {
        this.rfqNumber = rfqNumber;
    }

    public String getQuotationNumber() {
        return quotationNumber;
    }

    public void setQuotationNumber(String quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    public List<EntityProductPurchase> getEntityProductPurchase() {
        return entityProductPurchase;
    }

    public void setEntityProductPurchase(List<EntityProductPurchase> entityProductPurchase) {
        this.entityProductPurchase = entityProductPurchase;
    }

    public EntitySuppliers getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(EntitySuppliers supplierId) {
        this.supplierId = supplierId;
    }

    public EntityTypePO getTypePOId() {
        return typePOId;
    }

    public void setTypePOId(EntityTypePO typePOId) {
        this.typePOId = typePOId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    public String getTimeEdit() {
        return timeEdit;
    }

    public void setTimeEdit(String timeEdit) {
        this.timeEdit = timeEdit;
    }

    public String getDeliveryTerm() {
        return deliveryTerm;
    }

    public void setDeliveryTerm(String deliveryTerm) {
        this.deliveryTerm = deliveryTerm;
    }

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public String getInvoiceTo() {
        return invoiceTo;
    }

    public void setInvoiceTo(String invoiceTo) {
        this.invoiceTo = invoiceTo;
    }

    public boolean isIsApprove() {
        return isApprove;
    }

    public void setIsApprove(boolean isApprove) {
        this.isApprove = isApprove;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatusPo() {
        return statusPo;
    }

    public void setStatusPo(String statusPo) {
        this.statusPo = statusPo;
    }

    public String getAppproveBy() {
        return appproveBy;
    }

    public void setAppproveBy(String appproveBy) {
        this.appproveBy = appproveBy;
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
        hash += (purchaseId != null ? purchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityPurchases)) {
            return false;
        }
        EntityPurchases other = (EntityPurchases) object;
        if ((this.purchaseId == null && other.purchaseId != null) || (this.purchaseId != null && !this.purchaseId.equals(other.purchaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityPurchases[ purchaseId=" + purchaseId + " ]";
    }

}
