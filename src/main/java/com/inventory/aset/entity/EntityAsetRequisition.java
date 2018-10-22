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
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author newbiecihuy
 */
@Entity
@Table(name = "tbl_permintaan_aset")
@NamedQueries({
    @javax.persistence.NamedQuery(name = "EntityAsetRequisition.findByAll", query = "SELECT p FROM EntityAsetRequisition p")})
public class EntityAsetRequisition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id", columnDefinition = "serial", nullable = false)
    private Long ReqId;
    @Column(name = "departemen", nullable = true)
    private String departemen;
    @Column(name = "pemohon", nullable = true)
    private String pemohon;
    @Column(name = "approval", nullable = true)
    private String approval;
    @Column(name = "jml_angka", nullable = true)
    private Integer jmlAngka;
    @Column(name = "jml_permintaan", nullable = true)
    private Integer jmlPermintaan;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_permintaan")
    private Date tanggalPermintaan;
    
    @Column(name = "jam_permintaan", nullable = true)
    private String jamPermintaan;
    @Column(name = "tgl_approve")
    @Temporal(TemporalType.DATE)
    private Date tglApprove;
    @Column(name = "jam_approve", nullable = true)
    private String jamApprove;
    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "type_req_id")
    private Long typeReqId;

    public EntityAsetRequisition() {
    }

    public EntityAsetRequisition(Long ReqId, String departemen, String pemohon, String approval, Integer jmlAngka, Integer jmlPermintaan, Date tanggalPermintaan, String jamPermintaan, Date tglApprove, String jamApprove, String keterangan, Long typeReqId) {
        this.ReqId = ReqId;
        this.departemen = departemen;
        this.pemohon = pemohon;
        this.approval = approval;
        this.jmlAngka = jmlAngka;
        this.jmlPermintaan = jmlPermintaan;
        this.tanggalPermintaan = tanggalPermintaan;
        this.jamPermintaan = jamPermintaan;
        this.tglApprove = tglApprove;
        this.jamApprove = jamApprove;
        this.keterangan = keterangan;
        this.typeReqId = typeReqId;
    }

    public Long getReqId() {
        return ReqId;
    }

    public void setReqId(Long ReqId) {
        this.ReqId = ReqId;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getPemohon() {
        return pemohon;
    }

    public void setPemohon(String pemohon) {
        this.pemohon = pemohon;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public Integer getJmlAngka() {
        return jmlAngka;
    }

    public void setJmlAngka(Integer jmlAngka) {
        this.jmlAngka = jmlAngka;
    }

    public Integer getJmlPermintaan() {
        return jmlPermintaan;
    }

    public void setJmlPermintaan(Integer jmlPermintaan) {
        this.jmlPermintaan = jmlPermintaan;
    }

    public Date getTanggalPermintaan() {
        return tanggalPermintaan;
    }

    public void setTanggalPermintaan(Date tanggalPermintaan) {
        this.tanggalPermintaan = tanggalPermintaan;
    }

    public String getJamPermintaan() {
        return jamPermintaan;
    }

    public void setJamPermintaan(String jamPermintaan) {
        this.jamPermintaan = jamPermintaan;
    }

    public Date getTglApprove() {
        return tglApprove;
    }

    public void setTglApprove(Date tglApprove) {
        this.tglApprove = tglApprove;
    }

    public String getJamApprove() {
        return jamApprove;
    }

    public void setJamApprove(String jamApprove) {
        this.jamApprove = jamApprove;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Long getTypeReqId() {
        return typeReqId;
    }

    public void setTypeReqId(Long typeReqId) {
        this.typeReqId = typeReqId;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ReqId != null ? ReqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityAsetRequisition)) {
            return false;
        }
        EntityAsetRequisition other = (EntityAsetRequisition) object;
        if ((this.ReqId == null && other.ReqId != null) || (this.ReqId != null && !this.ReqId.equals(other.ReqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityAsetRequisition[ ReqId=" + ReqId + " ]";
    }

}
