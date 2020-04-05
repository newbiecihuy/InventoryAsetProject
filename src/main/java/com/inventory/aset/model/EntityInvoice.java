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
@Table(name = "tbl_invoice")
@NamedQueries({
    @NamedQuery(name = "EntityInvoice.findAll", query = "SELECT i FROM EntityInvoice i"),
    @NamedQuery(name = "EntityInvoice.findByInvoiceId", query = "SELECT i FROM EntityInvoice i WHERE i.invoiceId = :invoiceId"),
    @NamedQuery(name = "EntityInvoice.findByNoInvoice", query = "SELECT i FROM EntityInvoice i WHERE i.noInvoice = :noInvoice")
})
public class EntityInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id", columnDefinition = "serial", nullable = false)
    private Long invoiceId;

    @Column(name = "no_invoice")
    private String noInvoice;
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Basic(optional = false)
    @Column(name = "invoice_time")
    private String invoiceTime;

    @Basic(optional = false)
    @Column(name = "type_invoice")
    private String typeInvoice;

    @Basic(optional = false)
    @Column(name = "type_transaction")
    private String typeTransaction;

    @Column(name = "is_delete")
    private boolean isDelete = false;

    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @Column(name = "time")
    private String time;

    @Column(name = "input_date")
    @Temporal(TemporalType.DATE)
    private Date inputDate;

    @Basic(optional = false)
    @Column(name = "input_time")
    private String inputTime;

    @Basic(optional = false)
    @Column(name = "date_edit")
    @Temporal(TemporalType.DATE)
    private Date dateEdit;

    @Basic(optional = false)
    @Column(name = "time_edit")
    private String timeEdit;

    @Column(name = "pic")
    private String pic;

    @Column(name = "company_id")// set id_vendor or id customer
    private Long companyId;

    public EntityInvoice() {

    }

    public EntityInvoice(Long invoiceId, String noInvoice, Date invoiceDate, String invoiceTime, String typeInvoice, String typeTransaction, Date date, String time, Date inputDate, String inputTime, Date dateEdit, String timeEdit, String pic, Long companyId) {
        this.invoiceId = invoiceId;
        this.noInvoice = noInvoice;
        this.invoiceDate = invoiceDate;
        this.invoiceTime = invoiceTime;
        this.typeInvoice = typeInvoice;
        this.typeTransaction = typeTransaction;
        this.date = date;
        this.time = time;
        this.inputDate = inputDate;
        this.inputTime = inputTime;
        this.dateEdit = dateEdit;
        this.timeEdit = timeEdit;
        this.pic = pic;
        this.companyId = companyId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getNoInvoice() {
        return noInvoice;
    }

    public void setNoInvoice(String noInvoice) {
        this.noInvoice = noInvoice;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(String invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public String getTypeInvoice() {
        return typeInvoice;
    }

    public void setTypeInvoice(String typeInvoice) {
        this.typeInvoice = typeInvoice.replaceAll("(?i)<script.*?>.*?</script.*?>", "")
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

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
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

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    public String getTimeEdit() {
        return timeEdit;
    }

    public void setTimeEdit(String timeEdit) {
        this.timeEdit = timeEdit;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityInvoice)) {
            return false;
        }
        EntityInvoice other = (EntityInvoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventory.aset.entity.EntityInvoice[ invoiceId=" + invoiceId + " ]";
    }

}
