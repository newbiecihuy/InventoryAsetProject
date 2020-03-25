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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_sells")
@NamedQueries({
    @NamedQuery(name = "EntitySells.findAll", query = "SELECT s FROM EntitySells s")})
public class EntitySells implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sell_id", columnDefinition = "serial", nullable = false)
    private Long sellId;

    @Column(name = "sell_acc", nullable = false, unique = true)
    private String sellAcc;

    @Basic(optional = false)
    @Column(name = "date_sell")
    @Temporal(TemporalType.DATE)
    private Date dateSell;

    @Basic(optional = false)
    @Column(name = "time_sell")
    private String timeSells;

    @Column(name = "is_delete")
    private boolean isDelete = false;

    @Column(name = "pic")
    private String pic;

    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "sellId")
    private Collection<EntityProductSell> entityProductSell;

    public EntitySells() {

    }

    public EntitySells(Long sellId, String sellAcc, Date dateSell, String timeSells, String pic, Collection<EntityProductSell> entityProductSell) {
        this.sellId = sellId;
        this.sellAcc = sellAcc;
        this.dateSell = dateSell;
        this.timeSells = timeSells;
        this.pic = pic;
        this.entityProductSell = entityProductSell;
    }

    public Long getSellId() {
        return sellId;
    }

    public void setSellId(Long sellId) {
        this.sellId = sellId;
    }

    public String getSellAcc() {
        return sellAcc;
    }

    public void setSellAcc(String sellAcc) {
        this.sellAcc = sellAcc;
    }

    public Date getDateSell() {
        return dateSell;
    }

    public void setDateSell(Date dateSell) {
        this.dateSell = dateSell;
    }

    public String getTimeSells() {
        return timeSells;
    }

    public void setTimeSells(String timeSells) {
        this.timeSells = timeSells;
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

    public Collection<EntityProductSell> getEntityProductSell() {
        return entityProductSell;
    }

    public void setEntityProductSell(Collection<EntityProductSell> entityProductSell) {
        this.entityProductSell = entityProductSell;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellId != null ? sellId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntitySells)) {
            return false;
        }
        EntitySells other = (EntitySells) object;
        if ((this.sellId == null && other.sellId != null) || (this.sellId != null && !this.sellId.equals(other.sellId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntitySells[ sellId=" + sellId + " ]";
    }

}
