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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_protocol")
@NamedQueries({
    @javax.persistence.NamedQuery(name = "EntityProtocol.findByAll", query = "SELECT entityProtocol from EntityProtocol entityProtocol"),
    @javax.persistence.NamedQuery(name = "EntityProtocol.findByIdProtocol", query = "SELECT entityProtocol from EntityProtocol entityProtocol WHERE entityProtocol.idProtocol = :idProtocol"),
    @javax.persistence.NamedQuery(name = "EntityProtocol.findByEmail", query = "SELECT entityProtocol from EntityProtocol entityProtocol WHERE entityProtocol.email = :email")
})
public class EntityProtocol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_protocol", columnDefinition = "serial", nullable = false)
    private Long idProtocol;
    @Column(name = "smtp_host")
    private String smtpHost;
    @Column(name = "smtp_socket_factory_port")
    private String smtpSocketFactoryPort;
    @Column(name = "smtp_socket_factory_class")
    private String smtpSocketFactoryClass;
    @Column(name = "smtp_port")
    private String smtpPort;
    @Column(name = "email")
    private String email;
    @Column(name = "email_pass")
    private String emailPass;
    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "pic")
    private String pic;

    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "create_time")
    private String createdTime;

    public EntityProtocol() {
    }

    public EntityProtocol(Long idProtocol, String smtpHost, String smtpSocketFactoryPort, String smtpSocketFactoryClass, String smtpPort, String email, String emailPass, boolean isActive, String pic, Date createdDate, String createdTime) {
        this.idProtocol = idProtocol;
        this.smtpHost = smtpHost;
        this.smtpSocketFactoryPort = smtpSocketFactoryPort;
        this.smtpSocketFactoryClass = smtpSocketFactoryClass;
        this.smtpPort = smtpPort;
        this.email = email;
        this.emailPass = emailPass;
        this.isActive = isActive;
        this.pic = pic;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }

    public Long getIdProtocol() {
        return idProtocol;
    }

    public void setIdProtocol(Long idProtocol) {
        this.idProtocol = idProtocol;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpSocketFactoryPort() {
        return smtpSocketFactoryPort;
    }

    public void setSmtpSocketFactoryPort(String smtpSocketFactoryPort) {
        this.smtpSocketFactoryPort = smtpSocketFactoryPort;
    }

    public String getSmtpSocketFactoryClass() {
        return smtpSocketFactoryClass;
    }

    public void setSmtpSocketFactoryClass(String smtpSocketFactoryClass) {
        this.smtpSocketFactoryClass = smtpSocketFactoryClass;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailPass() {
        return emailPass;
    }

    public void setEmailPass(String emailPass) {
        this.emailPass = emailPass;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProtocol != null ? idProtocol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityProtocol)) {
            return false;
        }
        EntityProtocol other = (EntityProtocol) object;
        if ((this.idProtocol == null && other.idProtocol != null) || (this.idProtocol != null && !this.idProtocol.equals(other.idProtocol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityProtocol[ idProtocol=" + idProtocol + " ]";
    }

}
