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
    @NamedQuery(name = "EntityProducts.findAll", query = "SELECT p FROM EntityProducts p")
    , @NamedQuery(name = "EntityProducts.findByIdProduct", query = "SELECT p FROM EntityProducts p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "EntityProducts.findByProductName", query = "SELECT p FROM EntityProducts p WHERE p.productName = :productName")
    , @NamedQuery(name = "EntityProducts.findByCategoryId", query = "SELECT p FROM EntityProducts p WHERE p.categoryId = :categoryId")
    , @NamedQuery(name = "EntityProducts.findByMinimumStock", query = "SELECT p FROM EntityProducts p WHERE p.minimumStock = :minimumStock")
    , @NamedQuery(name = "EntityProducts.findByCreatedAt", query = "SELECT p FROM EntityProducts p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "EntityProducts.findByUpdatedAt", query = "SELECT p FROM EntityProducts p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "EntityProducts.findByProductActiveBySup", query = "SELECT p FROM EntityProducts p WHERE p.supplierId.supplierId = :supplierId And p.status_item = 1")})
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
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = true)
    private EntityCategories categoryId;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id", nullable = true)
    private EntitySuppliers supplierId;

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
    private Collection<EntityProductPurchase> entityProductPurchase;

    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "idProduct")
    private Collection<EntityProductSell> entityProductSell;

    @Column(name = "is_approve")
    private boolean isApprove = false;

    @Column(name = "pic")
    private String pic;

    public EntityProducts() {

    }

    public EntityProducts(Long idProduct, String productName, String productCode, String barcode, String pict_path, EntityCategories categoryId, EntitySuppliers supplierId, Date createdAt, String createdAtTime, Date inputDate, String inputTime, Date updatedAt, String updatedAtTime, String description, EntityStock entityStock, Collection<EntityProductPurchase> entityProductPurchase, Collection<EntityProductSell> entityProductSell, String pic) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productCode = productCode;
        this.barcode = barcode;
        this.pict_path = pict_path;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.createdAt = createdAt;
        this.createdAtTime = createdAtTime;
        this.inputDate = inputDate;
        this.inputTime = inputTime;
        this.updatedAt = updatedAt;
        this.updatedAtTime = updatedAtTime;
        this.description = description;
        this.entityStock = entityStock;
        this.entityProductPurchase = entityProductPurchase;
        this.entityProductSell = entityProductSell;
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
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public EntitySuppliers getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(EntitySuppliers supplierId) {
        this.supplierId = supplierId;
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
        this.description = description;
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

    public Collection<EntityProductPurchase> getEntityProductPurchase() {
        return entityProductPurchase;
    }

    public void setEntityProductPurchase(Collection<EntityProductPurchase> entityProductPurchase) {
        this.entityProductPurchase = entityProductPurchase;
    }

    public Collection<EntityProductSell> getEntityProductSell() {
        return entityProductSell;
    }

    public void setEntityProductSell(Collection<EntityProductSell> entityProductSell) {
        this.entityProductSell = entityProductSell;
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
