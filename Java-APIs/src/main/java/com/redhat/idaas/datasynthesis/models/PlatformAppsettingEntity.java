package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "platform_appsetting", schema = "datasynthesis", catalog = "")
public class PlatformAppsettingEntity {
    private Long id;
    private short appSettingsId;
    private String appSettingName;
    private String appSettingValue;
    private Timestamp createdDate;
    private Short statusId;
    private String registeredApp;
    private String defaultDataGenerationApp;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Basic
    @Column(name = "StatusID", nullable = true)
    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "RegisteredApp", nullable = true, length = 38)
    public String getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(String registeredApp) {
        this.registeredApp = registeredApp;
    }

    @Basic
    @Column(name = "DefaultDataGenerationApp", nullable = true, length = 38)
    public String getDefaultDataGenerationApp() {
        return defaultDataGenerationApp;
    }

    public void setDefaultDataGenerationApp(String defaultDataGenerationApp) {
        this.defaultDataGenerationApp = defaultDataGenerationApp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformAppsettingEntity that = (PlatformAppsettingEntity) o;

        if (appSettingsId != that.appSettingsId) return false;
        if (appSettingName != null ? !appSettingName.equals(that.appSettingName) : that.appSettingName != null)
            return false;
        if (appSettingValue != null ? !appSettingValue.equals(that.appSettingValue) : that.appSettingValue != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;
        if (defaultDataGenerationApp != null ? !defaultDataGenerationApp.equals(that.defaultDataGenerationApp) : that.defaultDataGenerationApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) appSettingsId;
        result = 31 * result + (appSettingName != null ? appSettingName.hashCode() : 0);
        result = 31 * result + (appSettingValue != null ? appSettingValue.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        result = 31 * result + (defaultDataGenerationApp != null ? defaultDataGenerationApp.hashCode() : 0);
        return result;
    }
}
