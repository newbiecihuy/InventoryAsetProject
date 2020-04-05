/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.model.users;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy https://www.baeldung.com/registration-token-cleanup
 */
@Entity
@Table(name = "tbl_verification_token")
@NamedQueries({
    @NamedQuery(name = "EntityVerificationToken.findAll", query = "SELECT ev FROM EntityVerificationToken ev")
    ,
    @NamedQuery(name = "EntityVerificationToken.findByRememberToken", query = "SELECT ev FROM EntityVerificationToken ev WHERE ev.rememberToken = :rememberToken")
})
public class EntityVerificationToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id", columnDefinition = "serial", nullable = false)
    private Long tokenId;
    @Column(name = "remember_token", length = 100)
    private String rememberToken;
    @Column(name = "remember_token_enc", length = 100)
    private String rememberTokenEnc;
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Column(name = "expiry_time")
    private String expiryTime;
//  @OneToOne(targetEntity = EntityUsers.class, fetch = FetchType.EAGER)
//  @JoinColumn(nullable = false, name = "user_id", foreignKey = @ForeignKey(name = "FK_VERIFY_USER"))
//  private EntityUsers entityUsers; @PrimaryKeyJoinColumn
    @OneToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "user_id")
    private EntityUsers entityUsers;

    public EntityVerificationToken() {
    }

    public EntityVerificationToken(Long tokenId, String rememberToken, String rememberTokenEnc, Date expiryDate, String expiryTime, EntityUsers entityUsers) {
        this.tokenId = tokenId;
        this.rememberToken = rememberToken;
        this.rememberTokenEnc = rememberTokenEnc;
        this.expiryDate = expiryDate;
        this.expiryTime = expiryTime;
        this.entityUsers = entityUsers;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public String getRememberTokenEnc() {
        return rememberTokenEnc;
    }

    public void setRememberTokenEnc(String rememberTokenEnc) {
        this.rememberTokenEnc = rememberTokenEnc;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public EntityUsers getEntityUsers() {
        return entityUsers;
    }

    public void setEntityUsers(EntityUsers entityUsers) {
        this.entityUsers = entityUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tokenId != null ? tokenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityVerificationToken)) {
            return false;
        }
        EntityVerificationToken other = (EntityVerificationToken) object;
        if ((this.tokenId == null && other.tokenId != null) || (this.tokenId != null && !this.tokenId.equals(other.tokenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.users.EntityVerificationToken[ tokenId=" + tokenId + " ]";
    }

}
