package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dataexisting_areacode", schema = "datasynthesis", catalog = "")
public class DataexistingAreacodeEntity {
    private Long id;
    private long areaCodeId;
    private String areaCodeValue;
    private String timeZone;
    private String stateCode;
    private Timestamp createdDate;
    private Short statusId;
    private String createdUser;
    private String registeredApp;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    @Column(name = "TimeZone", nullable = true, length = 3)
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Basic
    @Column(name = "StateCode", nullable = true, length = 2)
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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

        DataexistingAreacodeEntity that = (DataexistingAreacodeEntity) o;

        if (areaCodeId != that.areaCodeId) return false;
        if (areaCodeValue != null ? !areaCodeValue.equals(that.areaCodeValue) : that.areaCodeValue != null)
            return false;
        if (timeZone != null ? !timeZone.equals(that.timeZone) : that.timeZone != null) return false;
        if (stateCode != null ? !stateCode.equals(that.stateCode) : that.stateCode != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (areaCodeId ^ (areaCodeId >>> 32));
        result = 31 * result + (areaCodeValue != null ? areaCodeValue.hashCode() : 0);
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        result = 31 * result + (stateCode != null ? stateCode.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
