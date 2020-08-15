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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_document")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, length = 80)
@DiscriminatorValue("Documents")
public class EntityDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", columnDefinition = "serial", nullable = false)
    protected Long documentId;

//    @Column(name = "uuid")
//    protected String uuid;

    @Basic(optional = false)
    @Column(name = "time")
    protected String time;

    @Column(name = "input_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date inputDate;

    @Column(name = "is_approve", columnDefinition = "int default 0", nullable = false)
    protected int isApprove;

    @Column(name = "is_delete", columnDefinition = "boolean default false", nullable = false)
    protected boolean isDelete;

    @Basic(optional = false)
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedDate;

    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "documentId")
    protected List<EntityProductDocument> entityProductPurchase;

    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "partner_id")
    protected EntityPartner partnerId;

    @Basic(optional = false)
    @Column(name = "document_type")
    protected String documentType;

    @PrePersist
    protected void onCreate() {
        inputDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }

    public EntityDocument() {
    }

    public EntityDocument(Long documentId, String time, Date inputDate, int isApprove, boolean isDelete, Date updatedDate, List<EntityProductDocument> entityProductPurchase, EntityPartner partnerId, String documentType) {
        this.documentId = documentId;
        this.time = time;
        this.inputDate = inputDate;
        this.isApprove = isApprove;
        this.isDelete = isDelete;
        this.updatedDate = updatedDate;
        this.entityProductPurchase = entityProductPurchase;
        this.partnerId = partnerId;
        this.documentType = documentType;
    }
  
    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public int getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(int isApprove) {
        this.isApprove = isApprove;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<EntityProductDocument> getEntityProductPurchase() {
        return entityProductPurchase;
    }

    public void setEntityProductPurchase(List<EntityProductDocument> entityProductPurchase) {
        this.entityProductPurchase = entityProductPurchase;
    }

    public EntityPartner getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(EntityPartner partnerId) {
        this.partnerId = partnerId;
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
        if (!(object instanceof EntityDocument)) {
            return false;
        }
        EntityDocument other = (EntityDocument) object;
        if ((this.documentId == null && other.documentId != null) || (this.documentId != null && !this.documentId.equals(other.documentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.model.EntityDocument[ documentId=" + documentId + " ]";
    }

}
