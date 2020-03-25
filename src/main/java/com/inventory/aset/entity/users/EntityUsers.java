/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.aset.entity.users;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntityUsers.findAll", query = "SELECT u FROM EntityUsers u"),
    @NamedQuery(name = "EntityUsers.findByUserId", query = "SELECT u FROM EntityUsers u WHERE u.userId = :userId"),
    @NamedQuery(name = "EntityUsers.findByEmail", query = "SELECT u FROM EntityUsers u WHERE u.email = :email"),
    @NamedQuery(name = "EntityUsers.findByUsername", query = "SELECT u FROM EntityUsers u WHERE u.username = :username"),
    @NamedQuery(name = "EntityUsers.findByRoleName", query = "SELECT u FROM EntityUsers u WHERE u.roleName = :roleName"),
    @NamedQuery(name = "EntityUsers.findByPassword", query = "SELECT u FROM EntityUsers u WHERE u.password = :password"),
    @NamedQuery(name = "EntityUsers.findByCreatedDate", query = "SELECT u FROM EntityUsers u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "EntityUsers.findByUpdatedDate", query = "SELECT u FROM EntityUsers u WHERE u.updatedDate = :updatedDate")})
public class EntityUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id", columnDefinition = "serial", nullable = false)
    private Long userId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email Address")
    @Basic(optional = false)
    @Column(name = "email", length = 120, unique = true)
    private String email;
    @Basic(optional = false)
    @Column(name = "username", length = 120)//, unique = true
    private String username;
    @Column(name = "role_name")
    private String roleName;
    @Lob
    @Column(name = "address", length = 512)
    private String address;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 65)
    private String password;
    @Basic(optional = false)
    @Column(name = "password_enc", nullable = false, length = 65)
    private String passwordEnc;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "created_time")
    private String createdTime;
    @Basic(optional = false)
    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
    @Column(name = "updated_time")
    private String updatedTime;
    @Column(name = "nomor_imei")
    private String nomorIMEI;
    @Column(name = "phone")
    private String phone;
    @Column(name = "is_active")
    private boolean isActive = true;
    @Column(name = "is_online")
    private boolean isOnline;
    @Column(name = "status_users")
    private boolean statusUsers;
    @Column(name = "date_last_login")
    @Temporal(TemporalType.DATE)
    private Date dateLasetLogin;
    @Column(name = "time_last_login")
    private String timeLastLogin;
    @Column(name = "sesion_id")
    private String sesionID;
    @Column(name = "device_id_login")
    private String device_id_login;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @OneToOne(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "entityUsers")
    private EntityVerificationToken entityVerificationToken;

    public EntityUsers() {
    }

    public static enum Gender {

        M, F;

        private Gender() {
        }
    }

    public EntityUsers(Long userId, String email, String username, String roleName, String address, String password, String passwordEnc, Date createdDate, String createdTime, Date updatedDate, String updatedTime, String nomorIMEI, String phone, boolean isOnline, boolean statusUsers, Date dateLasetLogin, String timeLastLogin, String sesionID, String device_id_login, Gender gender, EntityVerificationToken entityVerificationToken) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.roleName = roleName;
        this.address = address;
        this.password = password;
        this.passwordEnc = passwordEnc;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.updatedDate = updatedDate;
        this.updatedTime = updatedTime;
        this.nomorIMEI = nomorIMEI;
        this.phone = phone;
        this.isOnline = isOnline;
        this.statusUsers = statusUsers;
        this.dateLasetLogin = dateLasetLogin;
        this.timeLastLogin = timeLastLogin;
        this.sesionID = sesionID;
        this.device_id_login = device_id_login;
        this.gender = gender;
        this.entityVerificationToken = entityVerificationToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encrypt(getEmail() + password);//password;
    }

    public String getPasswordEnc() {
        return passwordEnc;
    }

    public void setPasswordEnc(String passwordEnc) {
        this.passwordEnc = passwordEnc;
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

    public String getNomorIMEI() {
        return nomorIMEI;
    }

    public void setNomorIMEI(String nomorIMEI) {
        this.nomorIMEI = nomorIMEI;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public boolean isStatusUsers() {
        return statusUsers;
    }

    public void setStatusUsers(boolean statusUsers) {
        this.statusUsers = statusUsers;
    }

    public Date getDateLasetLogin() {
        return dateLasetLogin;
    }

    public void setDateLasetLogin(Date dateLasetLogin) {
        this.dateLasetLogin = dateLasetLogin;
    }

    public String getTimeLastLogin() {
        return timeLastLogin;
    }

    public void setTimeLastLogin(String timeLastLogin) {
        this.timeLastLogin = timeLastLogin;
    }

    public String getSesionID() {
        return sesionID;
    }

    public void setSesionID(String sesionID) {
        this.sesionID = sesionID;
    }

    public String getDevice_id_login() {
        return device_id_login;
    }

    public void setDevice_id_login(String device_id_login) {
        this.device_id_login = device_id_login;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public EntityVerificationToken getEntityVerificationToken() {
        return entityVerificationToken;
    }

    public void setEntityVerificationToken(EntityVerificationToken entityVerificationToken) {
        this.entityVerificationToken = entityVerificationToken;
    }
//

    public static String encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update(input.getBytes("UTF-8"));
            byte[] messageDigest = md.digest();
            BigInteger bigInt = new BigInteger(1, messageDigest);
            return bigInt.toString(16);

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EntityUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityUsers)) {
            return false;
        }
        EntityUsers other = (EntityUsers) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.Users[ userId=" + userId + " ]";
    }

}
