package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "platform_datagenconfig", schema = "datasynthesis", catalog = "")
public class PlatformDataGenConfigEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short dataGenConfigId;
    private String dataTypeGenConfigName;
    private String specialInstructions;
    private Integer runQuantity;
    private Short minuteInterval;
    private Timestamp createdDate;
    private String createdUser;
    private RefDataStatusEntity refdataStatus;

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

        PlatformDataGenConfigEntity that = (PlatformDataGenConfigEntity) o;

        if (dataGenConfigId != that.dataGenConfigId) return false;
        if (dataTypeGenConfigName != null ? !dataTypeGenConfigName.equals(that.dataTypeGenConfigName) : that.dataTypeGenConfigName != null)
            return false;
        if (specialInstructions != null ? !specialInstructions.equals(that.specialInstructions) : that.specialInstructions != null)
            return false;
        if (runQuantity != null ? !runQuantity.equals(that.runQuantity) : that.runQuantity != null) return false;
        if (minuteInterval != null ? !minuteInterval.equals(that.minuteInterval) : that.minuteInterval != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) dataGenConfigId;
        result = 31 * result + (dataTypeGenConfigName != null ? dataTypeGenConfigName.hashCode() : 0);
        result = 31 * result + (specialInstructions != null ? specialInstructions.hashCode() : 0);
        result = 31 * result + (runQuantity != null ? runQuantity.hashCode() : 0);
        result = 31 * result + (minuteInterval != null ? minuteInterval.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<PlatformDataGenConfigEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
