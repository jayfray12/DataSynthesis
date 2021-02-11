package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "refdata_application", schema = "datasynthesis", catalog = "")
public class RefdataApplicationEntity {
    private Long id;
    private String appGuid;
    private String applicationCustomCode;
    private String applicationDesc;
    private String createdUser;
    private Timestamp createdDate;
    private Short statusId;
    private Integer vendorId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "AppGUID", nullable = false, length = 38)
    public String getAppGuid() {
        return appGuid;
    }

    public void setAppGuid(String appGuid) {
        this.appGuid = appGuid;
    }

    @Basic
    @Column(name = "ApplicationCustomCode", nullable = true, length = 15)
    public String getApplicationCustomCode() {
        return applicationCustomCode;
    }

    public void setApplicationCustomCode(String applicationCustomCode) {
        this.applicationCustomCode = applicationCustomCode;
    }

    @Basic
    @Column(name = "ApplicationDesc", nullable = true, length = 50)
    public String getApplicationDesc() {
        return applicationDesc;
    }

    public void setApplicationDesc(String applicationDesc) {
        this.applicationDesc = applicationDesc;
    }

    @Basic
    @Column(name = "CreatedUser", nullable = true, length = 20)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "StatusID", nullable = true)
    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "VendorID", nullable = true)
    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefdataApplicationEntity that = (RefdataApplicationEntity) o;

        if (appGuid != null ? !appGuid.equals(that.appGuid) : that.appGuid != null) return false;
        if (applicationCustomCode != null ? !applicationCustomCode.equals(that.applicationCustomCode) : that.applicationCustomCode != null)
            return false;
        if (applicationDesc != null ? !applicationDesc.equals(that.applicationDesc) : that.applicationDesc != null)
            return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (vendorId != null ? !vendorId.equals(that.vendorId) : that.vendorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = appGuid != null ? appGuid.hashCode() : 0;
        result = 31 * result + (applicationCustomCode != null ? applicationCustomCode.hashCode() : 0);
        result = 31 * result + (applicationDesc != null ? applicationDesc.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (vendorId != null ? vendorId.hashCode() : 0);
        return result;
    }
}
