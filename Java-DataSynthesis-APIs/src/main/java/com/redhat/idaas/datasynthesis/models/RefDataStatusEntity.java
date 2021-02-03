package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "refdata_status", schema = "datasynthesis", catalog = "")
public class RefDataStatusEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short statusId;
    private String statusDescription;
    private Timestamp createdDate;
    private String createdUser;

    public RefDataStatusEntity(short statusId, String statusDescription, Timestamp createdDate, String createdUser) {
        this.statusId = statusId;
        this.statusDescription = statusDescription;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
    }

    public RefDataStatusEntity(short statusId) {
        this.statusId = statusId;
    }

    public RefDataStatusEntity() {
    }

    @Id
    @Column(name = "StatusID", nullable = false)
    public short getStatusId() {
        return statusId;
    }

    public void setStatusId(short statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "StatusDescription", nullable = false, length = 45)
    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
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
    @Column(name = "CreatedUser", nullable = true, length = 20)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefDataStatusEntity that = (RefDataStatusEntity) o;

        if (statusId != that.statusId) return false;
        if (statusDescription != null ? !statusDescription.equals(that.statusDescription) : that.statusDescription != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) statusId;
        result = 31 * result + (statusDescription != null ? statusDescription.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        return result;
    }
}
