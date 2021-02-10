package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "refdata_platformparamstodataattributes", schema = "datasynthesis", catalog = "")
public class RefdataPlatformparamstodataattributesEntity {
    private Long id;
    private long platformParamsToDataAttributeId;
    private Short platformParamsId;
    private Short dataAttributeId;
    private Timestamp createdDate;
    private Short statusId;
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
    @Column(name = "PlatformParamsToDataAttributeID", nullable = false)
    public long getPlatformParamsToDataAttributeId() {
        return platformParamsToDataAttributeId;
    }

    public void setPlatformParamsToDataAttributeId(long platformParamsToDataAttributeId) {
        this.platformParamsToDataAttributeId = platformParamsToDataAttributeId;
    }

    @Basic
    @Column(name = "PlatformParamsID", nullable = true)
    public Short getPlatformParamsId() {
        return platformParamsId;
    }

    public void setPlatformParamsId(Short platformParamsId) {
        this.platformParamsId = platformParamsId;
    }

    @Basic
    @Column(name = "DataAttributeID", nullable = true)
    public Short getDataAttributeId() {
        return dataAttributeId;
    }

    public void setDataAttributeId(Short dataAttributeId) {
        this.dataAttributeId = dataAttributeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefdataPlatformparamstodataattributesEntity that = (RefdataPlatformparamstodataattributesEntity) o;

        if (platformParamsToDataAttributeId != that.platformParamsToDataAttributeId) return false;
        if (platformParamsId != null ? !platformParamsId.equals(that.platformParamsId) : that.platformParamsId != null)
            return false;
        if (dataAttributeId != null ? !dataAttributeId.equals(that.dataAttributeId) : that.dataAttributeId != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (platformParamsToDataAttributeId ^ (platformParamsToDataAttributeId >>> 32));
        result = 31 * result + (platformParamsId != null ? platformParamsId.hashCode() : 0);
        result = 31 * result + (dataAttributeId != null ? dataAttributeId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
