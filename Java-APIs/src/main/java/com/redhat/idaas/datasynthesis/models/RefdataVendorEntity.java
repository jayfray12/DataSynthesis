package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "refdata_vendor", schema = "datasynthesis", catalog = "")
public class RefdataVendorEntity {
    private Long id;
    private int vendorId;
    private String vendorName;
    private Timestamp createdDate;
    private Short statusId;
    private String createdUser;
    private String vendorGuid;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "VendorID", nullable = false)
    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    @Basic
    @Column(name = "VendorName", nullable = true, length = 50)
    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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
    @Column(name = "CreatedUser", nullable = true, length = 20)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Basic
    @Column(name = "VendorGUID", nullable = true, length = 38)
    public String getVendorGuid() {
        return vendorGuid;
    }

    public void setVendorGuid(String vendorGuid) {
        this.vendorGuid = vendorGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefdataVendorEntity that = (RefdataVendorEntity) o;

        if (vendorId != that.vendorId) return false;
        if (vendorName != null ? !vendorName.equals(that.vendorName) : that.vendorName != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (vendorGuid != null ? !vendorGuid.equals(that.vendorGuid) : that.vendorGuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vendorId;
        result = 31 * result + (vendorName != null ? vendorName.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (vendorGuid != null ? vendorGuid.hashCode() : 0);
        return result;
    }
}
