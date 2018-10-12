/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.entity;

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
@Table(name = "tbl_product_invoice")
@NamedQueries({
    @NamedQuery(name = "EntityProductInvoice.findAll", query = "SELECT c FROM EntityProductInvoice c"),
    @NamedQuery(name = "EntityProductInvoice.findByIdProductInvoice", query = "SELECT c FROM EntityProductInvoice c WHERE c.idProductInvoice = :idProductInvoice")
})
public class EntityProductInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_invoice", columnDefinition = "serial", nullable = false)
    private Long idProductInvoice;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    private EntityInvoice invoiceId;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private EntityProducts idProduct;
    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = true)
    private EntityUnits unitId;

    @Column(name = "qtty")
    private int qtty;

    @Column(name = "price")
    private int price;

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

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Column(name = "update_time")
    private String updateTime;

    public EntityProductInvoice() {

    }

    public EntityProductInvoice(Long idProductInvoice, EntityInvoice invoiceId, EntityProducts idProduct, EntityUnits unitId, int qtty, int price, int totalProductPurchase, String pic, Date createdDate, String createdTime, Date updateDate, String updateTime) {
        this.idProductInvoice = idProductInvoice;
        this.invoiceId = invoiceId;
        this.idProduct = idProduct;
        this.unitId = unitId;
        this.qtty = qtty;
        this.price = price;
        this.totalProductPurchase = totalProductPurchase;
        this.pic = pic;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
    }

    public Long getIdProductInvoice() {
        return idProductInvoice;
    }

    public void setIdProductInvoice(Long idProductInvoice) {
        this.idProductInvoice = idProductInvoice;
    }

    public EntityInvoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(EntityInvoice invoiceId) {
        this.invoiceId = invoiceId;
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
        this.pic = pic;
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
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductInvoice != null ? idProductInvoice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityProductInvoice)) {
            return false;
        }
        EntityProductInvoice other = (EntityProductInvoice) object;
        if ((this.idProductInvoice == null && other.idProductInvoice != null) || (this.idProductInvoice != null && !this.idProductInvoice.equals(other.idProductInvoice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityProductInvoice[ idProductInvoice=" + idProductInvoice + " ]";
    }

}
