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
@Table(name = "datagenerated_ein", schema = "datasynthesis", catalog = "")
public class DataGeneratedEinEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long einid;
    private String einValue;
    private Timestamp createdDate;
    private String createdUser;
    private RefDataStatusEntity status;
    private RefDataApplicationEntity registeredApp;

    @Id
    @GeneratedValue
    @Column(name = "EINID", nullable = false)
    public long getEinid() {
        return einid;
    }

    public void setEinid(long einid) {
        this.einid = einid;
    }

    @Basic
    @Column(name = "EINValue", nullable = true, length = 10)
    public String getEinValue() {
        return einValue;
    }

    public void setEinValue(String einValue) {
        this.einValue = einValue;
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

        DataGeneratedEinEntity that = (DataGeneratedEinEntity) o;

        if (einid != that.einid) return false;
        if (einValue != null ? !einValue.equals(that.einValue) : that.einValue != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (einid ^ (einid >>> 32));
        result = 31 * result + (einValue != null ? einValue.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
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

    public static List<DataGeneratedEinEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }

    public static DataGeneratedEinEntity findByEinNumber(String einValue) {
        return find("einValue", einValue).firstResult();
    }
}
