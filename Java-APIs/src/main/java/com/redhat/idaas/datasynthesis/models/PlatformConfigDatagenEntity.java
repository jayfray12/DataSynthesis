package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "platform_config_datagen", schema = "datasynthesis", catalog = "")
public class PlatformConfigDatagenEntity {
    private Long id;
    private short dataGenConfigId;
    private String dataTypeGenConfigName;
    private Short dataAttributeId;
    private String specialInstructions;
    private Integer runQuantity;
    private Short minuteInterval;
    private Timestamp createdDate;
    private Short statusId;
    private String createdUser;
    private String applicationId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "DataGenConfigID", nullable = false)
    public short getDataGenConfigId() {
        return dataGenConfigId;
    }

    public void setDataGenConfigId(short dataGenConfigId) {
        this.dataGenConfigId = dataGenConfigId;
    }

    @Basic
    @Column(name = "DataTypeGenConfigName", nullable = true, length = 25)
    public String getDataTypeGenConfigName() {
        return dataTypeGenConfigName;
    }

    public void setDataTypeGenConfigName(String dataTypeGenConfigName) {
        this.dataTypeGenConfigName = dataTypeGenConfigName;
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
    @Column(name = "SpecialInstructions", nullable = true, length = 99)
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    @Basic
    @Column(name = "RunQuantity", nullable = true)
    public Integer getRunQuantity() {
        return runQuantity;
    }

    public void setRunQuantity(Integer runQuantity) {
        this.runQuantity = runQuantity;
    }

    @Basic
    @Column(name = "MinuteInterval", nullable = true)
    public Short getMinuteInterval() {
        return minuteInterval;
    }

    public void setMinuteInterval(Short minuteInterval) {
        this.minuteInterval = minuteInterval;
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
    @Column(name = "ApplicationID", nullable = true, length = 38)
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformConfigDatagenEntity that = (PlatformConfigDatagenEntity) o;

        if (dataGenConfigId != that.dataGenConfigId) return false;
        if (dataTypeGenConfigName != null ? !dataTypeGenConfigName.equals(that.dataTypeGenConfigName) : that.dataTypeGenConfigName != null)
            return false;
        if (dataAttributeId != null ? !dataAttributeId.equals(that.dataAttributeId) : that.dataAttributeId != null)
            return false;
        if (specialInstructions != null ? !specialInstructions.equals(that.specialInstructions) : that.specialInstructions != null)
            return false;
        if (runQuantity != null ? !runQuantity.equals(that.runQuantity) : that.runQuantity != null) return false;
        if (minuteInterval != null ? !minuteInterval.equals(that.minuteInterval) : that.minuteInterval != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (applicationId != null ? !applicationId.equals(that.applicationId) : that.applicationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) dataGenConfigId;
        result = 31 * result + (dataTypeGenConfigName != null ? dataTypeGenConfigName.hashCode() : 0);
        result = 31 * result + (dataAttributeId != null ? dataAttributeId.hashCode() : 0);
        result = 31 * result + (specialInstructions != null ? specialInstructions.hashCode() : 0);
        result = 31 * result + (runQuantity != null ? runQuantity.hashCode() : 0);
        result = 31 * result + (minuteInterval != null ? minuteInterval.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (applicationId != null ? applicationId.hashCode() : 0);
        return result;
    }
}
