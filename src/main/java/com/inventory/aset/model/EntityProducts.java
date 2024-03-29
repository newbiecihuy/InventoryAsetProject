/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_products")
@NamedQueries({
    @NamedQuery(name = "EntityProducts.findAll", query = "SELECT p FROM EntityProducts p"),
    @NamedQuery(name = "EntityProducts.findByIdProduct", query = "SELECT p FROM EntityProducts p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "EntityProducts.findByProductName", query = "SELECT p FROM EntityProducts p WHERE p.productName = :productName"),
    @NamedQuery(name = "EntityProducts.findByCategoryId", query = "SELECT p FROM EntityProducts p WHERE p.categoryId = :categoryId"),
    @NamedQuery(name = "EntityProducts.findByMinimumStock", query = "SELECT p FROM EntityProducts p WHERE p.minimumStock = :minimumStock"),
    @NamedQuery(name = "EntityProducts.findByCreatedAt", query = "SELECT p FROM EntityProducts p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "EntityProducts.findByUpdatedAt", query = "SELECT p FROM EntityProducts p WHERE p.updatedAt = :updatedAt"),
    @NamedQuery(name = "EntityProducts.findByProductActiveBySup", query = "SELECT p FROM EntityProducts p WHERE p.partnerId.partnerId = :partnerId And p.status_item = 1")})
public class EntityProducts implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    @Column(name = "sku", nullable = false, length = 100)
//    private String sku;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", columnDefinition = "serial", nullable = false)
    private Long idProduct;
    @Column(name = "product_name", length = 200)
    private String productName;
    @Column(name = "product_code", length = 200)
    private String productCode;
    @Column(name = "barcode", length = 200)
    private String barcode;
    @Column(name = "pict_path", length = 400)
    private String pict_path;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private EntityCategories categoryId;
    
    @ManyToOne
    @JoinColumn(name = "partner_id", referencedColumnName = "partner_id", nullable = false)
    private EntityPartner partnerId;

    @Basic(optional = false)
    @Column(name = "minimum_stock")
    private int minimumStock = 1;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "created_at_time")
    private String createdAtTime;
    @Basic(optional = false)
    @Column(name = "input_date")
    @Temporal(TemporalType.DATE)
    private Date inputDate;
    @Basic(optional = false)
    @Column(name = "input_time")
    private String inputTime;
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "updated_at_time")
    private String updatedAtTime;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    @Column(name = "status_item")
    private int status_item = 0;

    @Column(name = "is_delete")
    private boolean isDelete = false;

    //https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
//    @OneToOne(mappedBy = "entityProducts", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    private EntityStock entityStock;
//    @OneToOne(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "idProduct")
//    private EntityStock entityStock;
//    
    @OneToOne(mappedBy = "idProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EntityStock entityStock;

    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "idProduct")
    private Collection<EntityProductDocument> entityProductPurchase;

//    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "idProduct")
//    private Collection<EntityProductSell> entityProductSell;

    @Column(name = "is_approve")
    private boolean isApprove = false;

    @Column(name = "pic")
    private String pic;

    public EntityProducts() {

    }

    public EntityProducts(Long idProduct, String productName, String productCode, String barcode, String pict_path, EntityCategories categoryId, EntityPartner partnerId, Date createdAt, String createdAtTime, Date inputDate, String inputTime, Date updatedAt, String updatedAtTime, String description, EntityStock entityStock, Collection<EntityProductDocument> entityProductPurchase, String pic) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productCode = productCode;
        this.barcode = barcode;
        this.pict_path = pict_path;
        this.categoryId = categoryId;
        this.partnerId = partnerId;
        this.createdAt = createdAt;
        this.createdAtTime = createdAtTime;
        this.inputDate = inputDate;
        this.inputTime = inputTime;
        this.updatedAt = updatedAt;
        this.updatedAtTime = updatedAtTime;
        this.description = description;
        this.entityStock = entityStock;
        this.entityProductPurchase = entityProductPurchase;
        this.pic = pic;
    }

    

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getPict_path() {
        return pict_path;
    }

    public void setPict_path(String pict_path) {
        this.pict_path = pict_path;
    }

    public EntityCategories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(EntityCategories categoryId) {
        this.categoryId = categoryId;
    }

    public EntityPartner getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(EntityPartner partnerId) {
        this.partnerId = partnerId;
    }

   

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAtTime() {
        return createdAtTime;
    }

    public void setCreatedAtTime(String createdAtTime) {
        this.createdAtTime = createdAtTime;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAtTime() {
        return updatedAtTime;
    }

    public void setUpdatedAtTime(String updatedAtTime) {
        this.updatedAtTime = updatedAtTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public int getStatus_item() {
        return status_item;
    }

    public void setStatus_item(int status_item) {
        this.status_item = status_item;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public EntityStock getEntityStock() {
        return entityStock;
    }

    public void setEntityStock(EntityStock entityStock) {
        this.entityStock = entityStock;
    }

    public Collection<EntityProductDocument> getEntityProductPurchase() {
        return entityProductPurchase;
    }

    public void setEntityProductPurchase(Collection<EntityProductDocument> entityProductPurchase) {
        this.entityProductPurchase = entityProductPurchase;
    }

    public boolean isIsApprove() {
        return isApprove;
    }

    public void setIsApprove(boolean isApprove) {
        this.isApprove = isApprove;
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
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityProducts)) {
            return false;
        }
        EntityProducts other = (EntityProducts) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.Products[ idProduct=" + idProduct + " ]";
    }

}
