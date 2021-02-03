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
@Table(name = "platform_appsetting", schema = "datasynthesis", catalog = "")
public class PlatformAppSettingEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short appSettingsId;
    private String appSettingName;
    private String appSettingValue;
    private Timestamp createdDate;
    private RefDataStatusEntity refdataStatus;
    private RefDataOrganizationEntity refdataOrganization;

    @Id
    @Column(name = "AppSettingsID", nullable = false)
    public short getAppSettingsId() {
        return appSettingsId;
    }

    public void setAppSettingsId(short appSettingsId) {
        this.appSettingsId = appSettingsId;
    }

    @Basic
    @Column(name = "AppSettingName", nullable = true, length = 50)
    public String getAppSettingName() {
        return appSettingName;
    }

    public void setAppSettingName(String appSettingName) {
        this.appSettingName = appSettingName;
    }

    @Basic
    @Column(name = "AppSettingValue", nullable = true, length = 199)
    public String getAppSettingValue() {
        return appSettingValue;
    }

    public void setAppSettingValue(String appSettingValue) {
        this.appSettingValue = appSettingValue;
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

        PlatformAppSettingEntity that = (PlatformAppSettingEntity) o;

        if (appSettingsId != that.appSettingsId) return false;
        if (appSettingName != null ? !appSettingName.equals(that.appSettingName) : that.appSettingName != null)
            return false;
        if (appSettingValue != null ? !appSettingValue.equals(that.appSettingValue) : that.appSettingValue != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (refdataOrganization != null ? !refdataOrganization.equals(that.refdataOrganization) : that.refdataOrganization != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) appSettingsId;
        result = 31 * result + (appSettingName != null ? appSettingName.hashCode() : 0);
        result = 31 * result + (appSettingValue != null ? appSettingValue.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (refdataOrganization != null ? refdataOrganization.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "RegisteredApp", referencedColumnName = "OrganizationGUID")
    public RefDataOrganizationEntity getRefdataOrganization() {
        return refdataOrganization;
    }

    public void setRefdataOrganization(RefDataOrganizationEntity refdataOrganization) {
        this.refdataOrganization = refdataOrganization;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<PlatformAppSettingEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
