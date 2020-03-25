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
@Table(name = "tbl_currency")
@NamedQueries({
    @NamedQuery(name = "EntityCurrency.findAll", query = "SELECT c FROM EntityCurrency c")
    ,
    @NamedQuery(name = "EntityCurrency.findByCurrency", query = "SELECT c FROM EntityCurrency c WHERE c.currency = :currency")
    , 
    @NamedQuery(name = "EntityCurrency.findByExchangeRate", query = "SELECT c FROM EntityCurrency c WHERE c.exchangeRate = :exchangeRate")
})
public class EntityCurrency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_currency", columnDefinition = "serial", nullable = false)
    private Long idCurrency;

    @Column(name = "currency")
    private String currency;

    @Column(name = "exchange_rate")
    private Double exchangeRate;

    @Column(name = "sign")
    private String sign;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    @Column(name = "updated_time")
    private String updatedTime;

    @Column(name = "pic")
    private String pic;

    public EntityCurrency() {

    }

    public EntityCurrency(Long idCurrency, String currency, Double exchangeRate, String sign, Date updatedDate, String updatedTime, String pic) {
        this.idCurrency = idCurrency;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.sign = sign;
        this.updatedDate = updatedDate;
        this.updatedTime = updatedTime;
        this.pic = pic;
    }

    public Long getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(Long idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
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
        hash += (idCurrency != null ? idCurrency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityCurrency)) {
            return false;
        }
        EntityCurrency other = (EntityCurrency) object;
        if ((this.idCurrency == null && other.idCurrency != null) || (this.idCurrency != null && !this.idCurrency.equals(other.idCurrency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityCurrency[ idCurrency=" + idCurrency + " ]";
    }

}
