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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_purchase")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING, length = 80)
@DiscriminatorValue("PurchaseOrder")

@NamedQueries({
    @NamedQuery(name = "EntityPurchases.findAll", query = "SELECT c FROM EntityPurchases c"),
    @NamedQuery(name = "EntityPurchases.findByPurchaseId", query = "SELECT c FROM EntityPurchases c WHERE c.documentId = :documentId"),
    @NamedQuery(name = "EntityPurchases.findByNoPo", query = "SELECT c FROM EntityPurchases c WHERE c.inputDate = :inputDate order by  c.documentId desc")
})
public class EntityPurchases extends EntityDocument implements Serializable {

//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "purchase_id", columnDefinition = "serial", nullable = false)
//    private Long purchaseId;
    @Basic(optional = false)
    @Column(name = "purchase_code")
    private String purchaseCode;

    @Basic(optional = false)
    @Column(name = "purchase_desc")
    private String purchaseDesc;

    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @Column(name = "transport_mode")
    private String transportMode;

    @Basic(optional = false)
    @Column(name = "rfq_number")
    private String rfqNumber;

    @Basic(optional = false)
    @Column(name = "quotation_number")
    private String quotationNumber;

    @Column(name = "total_product_purchase_cost")
    private String totalProductPurchaseCost = "0";

    @ManyToOne
    @JoinColumn(name = "type_po_id", referencedColumnName = "type_po_id")
    private EntityTypePO typePOId;

    @Basic(optional = false)
    @Column(name = "no_po")
    private Long NoPo;

    @Basic(optional = false)
    @Column(name = "delivery_term")
    private String deliveryTerm;

    @Basic(optional = false)
    @Column(name = "delivery_point")
    private String deliveryPoint;

    @Basic(optional = false)
    @Column(name = "invoice_to")
    private String invoiceTo;

    @Column(name = "status_po")
    private String statusPo;

    @Column(name = "appprove_by")
    private String appproveBy;

    @Column(name = "pic")
    private String pic;

    public EntityPurchases() {

    }

    @PrePersist
    @Override
    protected void onCreate() {
        statusPo = "No Item";
        totalProductPurchaseCost = "0";
        this.documentType = "PurchaseOrder";
    }

    public EntityPurchases(String purchaseCode, String purchaseDesc, Date date, String transportMode, String rfqNumber, String quotationNumber, EntityTypePO typePOId, Long NoPo, String deliveryTerm, String deliveryPoint, String invoiceTo, String statusPo, String appproveBy, String pic) {
        this.purchaseCode = purchaseCode;
        this.purchaseDesc = purchaseDesc;
        this.date = date;
        this.transportMode = transportMode;
        this.rfqNumber = rfqNumber;
        this.quotationNumber = quotationNumber;
        this.typePOId = typePOId;
        this.NoPo = NoPo;
        this.deliveryTerm = deliveryTerm;
        this.deliveryPoint = deliveryPoint;
        this.invoiceTo = invoiceTo;
        this.statusPo = statusPo;
        this.appproveBy = appproveBy;
        this.pic = pic;
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
        this.purchaseDesc = purchaseDesc.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getTotalProductPurchaseCost() {
        return totalProductPurchaseCost;
    }

    public void setTotalProductPurchaseCost(String totalProductPurchaseCost) {
        this.totalProductPurchaseCost = totalProductPurchaseCost;
    }

    public EntityTypePO getTypePOId() {
        return typePOId;
    }

    public void setTypePOId(EntityTypePO typePOId) {
        this.typePOId = typePOId;
    }

    public String getDeliveryTerm() {
        return deliveryTerm;
    }

    public void setDeliveryTerm(String deliveryTerm) {
        this.deliveryTerm = deliveryTerm.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getInvoiceTo() {
        return invoiceTo;
    }

    public void setInvoiceTo(String invoiceTo) {
        this.invoiceTo = invoiceTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatusPo() {
        return statusPo;
    }

    public void setStatusPo(String statusPo) {
        this.statusPo = statusPo.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getAppproveBy() {
        return appproveBy;
    }

    public void setAppproveBy(String appproveBy) {
        this.appproveBy = appproveBy.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public Long getNoPo() {
        return NoPo;
    }

    public void setNoPo(Long NoPo) {
        this.NoPo = NoPo;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public EntityPartner getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(EntityPartner partnerId) {
        this.partnerId = partnerId;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public Date getInputDate() {
        return inputDate;
    }

    @Override
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    @Override
    public int getIsApprove() {
        return isApprove;
    }

    @Override
    public void setIsApprove(int isApprove) {
        this.isApprove = isApprove;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public List<EntityProductDocument> getEntityProductPurchase() {
        return entityProductPurchase;
    }

    @Override
    public void setEntityProductPurchase(List<EntityProductDocument> entityProductPurchase) {
        this.entityProductPurchase = entityProductPurchase;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentId != null ? documentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityPurchases)) {
            return false;
        }
        EntityPurchases other = (EntityPurchases) object;
        if ((this.documentId == null && other.documentId != null) || (this.documentId != null && !this.documentId.equals(other.documentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityPurchases[ documentId=" + documentId + " ]";
    }
}
