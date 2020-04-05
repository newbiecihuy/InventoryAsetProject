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
@Table(name = "tbl_product_sell")
@NamedQueries({
    @NamedQuery(name = "EntityProductSell.findAll", query = "SELECT l FROM EntityProductSell l")})
public class EntityProductSell implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_sell_id", columnDefinition = "serial", nullable = false)
    private Long productSellId;

    @ManyToOne
    @JoinColumn(name = "sell_id", referencedColumnName = "sell_id")
    private EntitySells sellId;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private EntityProducts idProduct;

    @Column(name = "qtty")
    private int qtty;

    @Column(name = "price")
    private int price;

    @Column(name = "total_product_sell")
    private int totalProductSell;

    @Column(name = "is_delete")
    private boolean isDelete = false;

    @Column(name = "pic")
    private String pic;
    
    @Column(name = "symbol")
    private String symbol;

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "create_time")
    private String createdTime;

    public EntityProductSell() {
        
    }

    public EntityProductSell(Long productSellId, EntitySells sellId, EntityProducts idProduct, int qtty, int price, int totalProductSell, String pic, String symbol, Date createdDate, String createdTime) {
        this.productSellId = productSellId;
        this.sellId = sellId;
        this.idProduct = idProduct;
        this.qtty = qtty;
        this.price = price;
        this.totalProductSell = totalProductSell;
        this.pic = pic;
        this.symbol = symbol;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }

    public Long getProductSellId() {
        return productSellId;
    }

    public void setProductSellId(Long productSellId) {
        this.productSellId = productSellId;
    }

    public EntitySells getSellId() {
        return sellId;
    }

    public void setSellId(EntitySells sellId) {
        this.sellId = sellId;
    }

    public EntityProducts getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(EntityProducts idProduct) {
        this.idProduct = idProduct;
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

    public int getTotalProductSell() {
        return totalProductSell;
    }

    public void setTotalProductSell(int totalProductSell) {
        this.totalProductSell = totalProductSell;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productSellId != null ? productSellId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityProductSell)) {
            return false;
        }
        EntityProductSell other = (EntityProductSell) object;
        if ((this.productSellId == null && other.productSellId != null) || (this.productSellId != null && !this.productSellId.equals(other.productSellId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityProductSell[ productSellId=" + productSellId + " ]";
    }

}
