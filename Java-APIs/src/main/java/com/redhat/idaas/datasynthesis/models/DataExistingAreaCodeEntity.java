package com.redhat.idaas.datasynthesis.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dataexisting_areacode", schema = "datasynthesis", catalog = "")
public class DataExistingAreaCodeEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long areaCodeId;
    private String areaCodeValue;
    private Timestamp createdDate;
    private String createdUser;
    private String registeredApp;
    private RefDataStatusEntity refdataStatus;
    private RefDataTimeZonesEntity refdataTimezones;
    private RefDataUsStatesEntity refdataUsstates;

    @Id
    @Column(name = "AreaCodeID", nullable = false)
    public long getAreaCodeId() {
        return areaCodeId;
    }

    public void setAreaCodeId(long areaCodeId) {
        this.areaCodeId = areaCodeId;
    }

    @Basic
    @Column(name = "AreaCodeValue", nullable = false, length = 3)
    public String getAreaCodeValue() {
        return areaCodeValue;
    }

    public void setAreaCodeValue(String areaCodeValue) {
        this.areaCodeValue = areaCodeValue;
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

    @Basic
    @Column(name = "RegisteredApp", nullable = true, length = 38)
    public String getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(String registeredApp) {
        this.registeredApp = registeredApp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataExistingAreaCodeEntity that = (DataExistingAreaCodeEntity) o;

        if (areaCodeId != that.areaCodeId) return false;
        if (areaCodeValue != null ? !areaCodeValue.equals(that.areaCodeValue) : that.areaCodeValue != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (refdataTimezones != null ? !refdataTimezones.equals(that.refdataTimezones) : that.refdataTimezones != null) return false;
        if (refdataUsstates != null ? !refdataUsstates.equals(that.refdataUsstates) : that.refdataUsstates != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (areaCodeId ^ (areaCodeId >>> 32));
        result = 31 * result + (areaCodeValue != null ? areaCodeValue.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (refdataTimezones != null ? refdataTimezones.hashCode() : 0);
        result = 31 * result + (refdataUsstates != null ? refdataUsstates.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TimeZone", referencedColumnName = "TimeZoneValue")
    public RefDataTimeZonesEntity getRefdataTimezones() {
        return refdataTimezones;
    }

    public void setRefdataTimezones(RefDataTimeZonesEntity refdataTimezones) {
        this.refdataTimezones = refdataTimezones;
    }

    @ManyToOne
    @JoinColumn(name = "StateCode", referencedColumnName = "StateID")
    public RefDataUsStatesEntity getRefdataUsstates() {
        return refdataUsstates;
    }

    public void setRefdataUsstates(RefDataUsStatesEntity refdataUsstates) {
        this.refdataUsstates = refdataUsstates;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<DataExistingAreaCodeEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
