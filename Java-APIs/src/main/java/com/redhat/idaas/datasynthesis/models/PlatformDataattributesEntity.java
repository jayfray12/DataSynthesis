package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "platform_dataattributes", schema = "datasynthesis", catalog = "")
public class PlatformDataattributesEntity {
    private Long id;
    private short platformDataAttributesId;
    private String dataAttributeName;
    private Short sensitivityFlagId;
    private Timestamp createdDate;
    private Short statusId;
    private String createdUser;
    private String platformDataAttributeGuid;
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
    @Column(name = "PlatformDataAttributesID", nullable = false)
    public short getPlatformDataAttributesId() {
        return platformDataAttributesId;
    }

    public void setPlatformDataAttributesId(short platformDataAttributesId) {
        this.platformDataAttributesId = platformDataAttributesId;
    }

    @Basic
    @Column(name = "DataAttributeName", nullable = true, length = 50)
    public String getDataAttributeName() {
        return dataAttributeName;
    }

    public void setDataAttributeName(String dataAttributeName) {
        this.dataAttributeName = dataAttributeName;
    }

    @Basic
    @Column(name = "SensitivityFlagID", nullable = true)
    public Short getSensitivityFlagId() {
        return sensitivityFlagId;
    }

    public void setSensitivityFlagId(Short sensitivityFlagId) {
        this.sensitivityFlagId = sensitivityFlagId;
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
    @Column(name = "PlatformDataAttributeGUID", nullable = true, length = 38)
    public String getPlatformDataAttributeGuid() {
        return platformDataAttributeGuid;
    }

    public void setPlatformDataAttributeGuid(String platformDataAttributeGuid) {
        this.platformDataAttributeGuid = platformDataAttributeGuid;
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

        PlatformDataattributesEntity that = (PlatformDataattributesEntity) o;

        if (platformDataAttributesId != that.platformDataAttributesId) return false;
        if (dataAttributeName != null ? !dataAttributeName.equals(that.dataAttributeName) : that.dataAttributeName != null)
            return false;
        if (sensitivityFlagId != null ? !sensitivityFlagId.equals(that.sensitivityFlagId) : that.sensitivityFlagId != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (platformDataAttributeGuid != null ? !platformDataAttributeGuid.equals(that.platformDataAttributeGuid) : that.platformDataAttributeGuid != null)
            return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) platformDataAttributesId;
        result = 31 * result + (dataAttributeName != null ? dataAttributeName.hashCode() : 0);
        result = 31 * result + (sensitivityFlagId != null ? sensitivityFlagId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (platformDataAttributeGuid != null ? platformDataAttributeGuid.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
