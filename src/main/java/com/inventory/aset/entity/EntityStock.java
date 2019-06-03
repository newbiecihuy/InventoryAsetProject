/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_stock")
@NamedQueries({
    @NamedQuery(name =  "EntityStock.findAll", query = "SELECT p FROM EntityStock p")
    ,@NamedQuery(name = "EntityStock.findByIdStock", query = "SELECT p FROM EntityStock p WHERE p.idStock = :idStock")
    ,@NamedQuery(name = "EntityStock.findProductByStock", query = "SELECT p FROM EntityStock p WHERE p.idProduct.productName = :productName")
})
public class EntityStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock", columnDefinition = "serial", nullable = false)
    private Long idStock;
    @Column(name = "stock")
    private int stock;

//    @Basic(optional = false)
//    @Column(name = "buy_price")
//    private int buyPrice;
    @Basic(optional = false)
    @Column(name = "buy_price")
    private String buyPrice;

    @Column(name = "price")
    private int price;

    @Column(name = "sell_price")
    private String sellPrice = "0";

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @Column(name = "time")
    private String time;
    @Column(name = "is_delete")
    private boolean isDelete = false;

    @Basic(optional = false)
    @Column(name = "estemated_date_before")
    @Temporal(TemporalType.DATE)
    private Date estematedDateBefore;

    @Basic(optional = false)
    @Column(name = "estemated_date_after")
    @Temporal(TemporalType.DATE)
    private Date estematedDateAfter;
//    https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "sku")
//    private EntityProducts sku;
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private EntityProducts entityProducts;
    @Column(name = "currency")
    private String currency = "IDR";

    @Column(name = "pic")
    private String pic;
//    

//    @OneToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
//    @JoinColumn(name = "id_product")
//    private EntityProducts idProduct;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product", nullable = false)
    private EntityProducts idProduct;

    public EntityStock() {

    }

    public EntityStock(Long idStock, int stock, String buyPrice, int price, String sellPrice, Date date, String time, Date estematedDateBefore, Date estematedDateAfter, String pic, EntityProducts idProduct) {
        this.idStock = idStock;
        this.stock = stock;
        this.buyPrice = buyPrice;
        this.price = price;
        this.sellPrice = sellPrice;
        this.date = date;
        this.time = time;
        this.estematedDateBefore = estematedDateBefore;
        this.estematedDateAfter = estematedDateAfter;
        this.pic = pic;
        this.idProduct = idProduct;
    }

    public Long getIdStock() {
        return idStock;
    }

    public void setIdStock(Long idStock) {
        this.idStock = idStock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
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

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getEstematedDateBefore() {
        return estematedDateBefore;
    }

    public void setEstematedDateBefore(Date estematedDateBefore) {
        this.estematedDateBefore = estematedDateBefore;
    }

    public Date getEstematedDateAfter() {
        return estematedDateAfter;
    }

    public void setEstematedDateAfter(Date estematedDateAfter) {
        this.estematedDateAfter = estematedDateAfter;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public EntityProducts getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(EntityProducts idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStock != null ? idStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityStock)) {
            return false;
        }
        EntityStock other = (EntityStock) object;
        if ((this.idStock == null && other.idStock != null) || (this.idStock != null && !this.idStock.equals(other.idStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityStock[ idStock=" + idStock + " ]";
    }

}
