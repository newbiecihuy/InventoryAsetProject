/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_company_address")
@NamedQueries({
    @javax.persistence.NamedQuery(name = "EntityCompanyAddress.findAll", query = "SELECT e from EntityCompanyAddress e"),})
public class EntityCompanyAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company_address", columnDefinition = "serial", nullable = false)
    private Long idCompanyAdress;
    @Column(name = "address")
    private String address;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "created_at_time")
    private String createdAtTime;

    @ManyToOne
    @JoinColumn(name = "id_company", referencedColumnName = "id_company", nullable = true)
    private EntityCompany idCompany;

    public EntityCompanyAddress() {

    }

    public EntityCompanyAddress(Long idCompanyAdress, String address, Date createdAt, String createdAtTime, EntityCompany idCompany) {
        this.idCompanyAdress = idCompanyAdress;
        this.address = address;
        this.createdAt = createdAt;
        this.createdAtTime = createdAtTime;
        this.idCompany = idCompany;
    }

    public Long getIdCompanyAdress() {
        return idCompanyAdress;
    }

    public void setIdCompanyAdress(Long idCompanyAdress) {
        this.idCompanyAdress = idCompanyAdress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public EntityCompany getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(EntityCompany idCompany) {
        this.idCompany = idCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompanyAdress != null ? idCompanyAdress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityCompanyAddress)) {
            return false;
        }
        EntityCompanyAddress other = (EntityCompanyAddress) object;
        if ((this.idCompanyAdress == null && other.idCompanyAdress != null) || (this.idCompanyAdress != null && !this.idCompanyAdress.equals(other.idCompanyAdress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityCompanyAddress[ idCompanyAdress=" + idCompanyAdress + " ]";
    }

}
