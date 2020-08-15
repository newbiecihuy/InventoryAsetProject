/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_product_purchase")
@NamedQueries({
    @NamedQuery(name = "EntityProductDocument.findAll", query = "SELECT c FROM EntityProductDocument c")
    ,@NamedQuery(name = "EntityProductDocument.findByidProductPurchase", query = "SELECT c FROM EntityProductDocument c WHERE c.idProductPurchase = :idProductPurchase")
    ,@NamedQuery(name = "EntityProductDocument.findByProductPOlist", query = "SELECT c FROM EntityProductDocument c WHERE c.documentId.documentId = :documentId")
})
public class EntityProductDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_purchase", columnDefinition = "serial", nullable = false)
    private Long idProductPurchase;

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "document_id")
    private EntityDocument documentId;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private EntityProducts idProduct;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = true)
    private EntityUnits unitId;

    @Column(name = "qtty")
    private int qtty;

    @Column(name = "price")
    private int price = 0;

    @Column(name = "total_product_purchase")
    private int totalProductPurchase;

    @Column(name = "is_delete")
    private boolean isDelete = false;

    @Column(name = "pic")
    private String pic;

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "create_time")
    private String createdTime;

    @Column(name = "input_date")
    @Temporal(TemporalType.DATE)
    private Date inputDate;
    @Column(name = "input_time")
    private String inputTime;

    @Column(name = "disconto")
    private Integer disconto;

    @Column(name = "tax_status")
    private Integer tax_status;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Column(name = "update_time")
    private String updateTime;

    public EntityProductDocument() {

    }

    public EntityProductDocument(Long idProductPurchase, EntityDocument documentId, EntityProducts idProduct, EntityUnits unitId, int qtty, int totalProductPurchase, String pic, Date createdDate, String createdTime, Date inputDate, String inputTime, Integer disconto, Integer tax_status, Date updateDate, String updateTime) {
        this.idProductPurchase = idProductPurchase;
        this.documentId = documentId;
        this.idProduct = idProduct;
        this.unitId = unitId;
        this.qtty = qtty;
        this.totalProductPurchase = totalProductPurchase;
        this.pic = pic;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.inputDate = inputDate;
        this.inputTime = inputTime;
        this.disconto = disconto;
        this.tax_status = tax_status;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
    }

   

    public Long getIdProductPurchase() {
        return idProductPurchase;
    }

    public void setIdProductPurchase(Long idProductPurchase) {
        this.idProductPurchase = idProductPurchase;
    }

    public EntityDocument getDocumentId() {
        return documentId;
    }

    public void setDocumentId(EntityDocument documentId) {
        this.documentId = documentId;
    }

   

    public EntityProducts getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(EntityProducts idProduct) {
        this.idProduct = idProduct;
    }

    public EntityUnits getUnitId() {
        return unitId;
    }

    public void setUnitId(EntityUnits unitId) {
        this.unitId = unitId;
    }

    public int getQtty() {
        return qtty;
    }

    public void setQtty(int qtty) {
        this.qtty = qtty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalProductPurchase() {
        return totalProductPurchase;
    }

    public void setTotalProductPurchase(int totalProductPurchase) {
        this.totalProductPurchase = totalProductPurchase;
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
        this.inputTime = inputTime.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public Integer getDisconto() {
        return disconto;
    }

    public void setDisconto(Integer disconto) {
        this.disconto = disconto;
    }

    public Integer getTax_status() {
        return tax_status;
    }

    public void setTax_status(Integer tax_status) {
        this.tax_status = tax_status;
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
        this.updateTime = updateTime.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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
        hash += (idProductPurchase != null ? idProductPurchase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityProductDocument)) {
            return false;
        }
        EntityProductDocument other = (EntityProductDocument) object;
        return !((this.idProductPurchase == null && other.idProductPurchase != null) || (this.idProductPurchase != null && !this.idProductPurchase.equals(other.idProductPurchase)));
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityProductPurchase[ idProductPurchase=" + idProductPurchase + " ]";
    }

}
