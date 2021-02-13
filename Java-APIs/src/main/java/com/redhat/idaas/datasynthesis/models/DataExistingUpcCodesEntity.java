package com.redhat.idaas.datasynthesis.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dataexisting_upccodes", schema = "datasynthesis", catalog = "")
public class DataExistingUpcCodesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long upcCodeId;
    private String upcCodeName;
    private String upcProductName;
    private Timestamp createdDate;
    private RefDataStatusEntity status;
    private RefDataApplicationEntity registeredApp;

    @Id
    @GeneratedValue
    @Column(name = "UPCCodeID", nullable = false)
    public long getUpcCodeId() {
        return upcCodeId;
    }

    public void setUpcCodeId(long upcCodeId) {
        this.upcCodeId = upcCodeId;
    }

    @Basic
    @Column(name = "UPCCodeName", nullable = true, length = 15)
    public String getUpcCodeName() {
        return upcCodeName;
    }

    public void setUpcCodeName(String upcCodeName) {
        this.upcCodeName = upcCodeName;
    }

    @Basic
    @Column(name = "UPCProductName", nullable = true, length = 150)
    public String getUpcProductName() {
        return upcProductName;
    }

    public void setUpcProductName(String upcProductName) {
        this.upcProductName = upcProductName;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataExistingUpcCodesEntity that = (DataExistingUpcCodesEntity) o;

        if (upcCodeId != that.upcCodeId) return false;
        if (upcCodeName != null ? !upcCodeName.equals(that.upcCodeName) : that.upcCodeName != null) return false;
        if (upcProductName != null ? !upcProductName.equals(that.upcProductName) : that.upcProductName != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (upcCodeId ^ (upcCodeId >>> 32));
        result = 31 * result + (upcCodeName != null ? upcCodeName.hashCode() : 0);
        result = 31 * result + (upcProductName != null ? upcProductName.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getStatus() {
        return status;
    }

    public void setStatus(RefDataStatusEntity status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "RegisteredApp", referencedColumnName = "AppGUID")
    public RefDataApplicationEntity getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(RefDataApplicationEntity registeredApp) {
        this.registeredApp = registeredApp;
    }

    public static List<DataExistingUpcCodesEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}
