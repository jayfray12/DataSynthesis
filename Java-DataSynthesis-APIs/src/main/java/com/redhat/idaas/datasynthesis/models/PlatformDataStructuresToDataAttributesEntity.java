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
@Table(name = "platform_datastructurestodataattributes", schema = "datasynthesis", catalog = "")
public class PlatformDataStructuresToDataAttributesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short platformDataStructuresToDataAttributesId;
    private String compositeDataStructureName;
    private Timestamp createdDate;
    private String createdUser;
    private String platformDataStructuresToDataAttributesGuid;
    private RefDataStatusEntity refdataStatus;
    private RefDataApplicationEntity refdataApplication;
    private RefDataSensitivityFlagEntity refdataSensitivityflag;
    private PlatformDataAttributesEntity platformDataattributes;
    private PlatformDataStructuresEntity platformDatastructures;

    @Id
    @Column(name = "PlatformDataStructuresToDataAttributesID", nullable = false)
    public short getPlatformDataStructuresToDataAttributesId() {
        return platformDataStructuresToDataAttributesId;
    }

    public void setPlatformDataStructuresToDataAttributesId(short platformDataStructuresToDataAttributesId) {
        this.platformDataStructuresToDataAttributesId = platformDataStructuresToDataAttributesId;
    }

    @Basic
    @Column(name = "CompositeDataStructureName", nullable = true, length = 50)
    public String getCompositeDataStructureName() {
        return compositeDataStructureName;
    }

    public void setCompositeDataStructureName(String compositeDataStructureName) {
        this.compositeDataStructureName = compositeDataStructureName;
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
    @Column(name = "PlatformDataStructuresToDataAttributesGUID", nullable = true, length = 38)
    public String getPlatformDataStructuresToDataAttributesGuid() {
        return platformDataStructuresToDataAttributesGuid;
    }

    public void setPlatformDataStructuresToDataAttributesGuid(String platformDataStructuresToDataAttributesGuid) {
        this.platformDataStructuresToDataAttributesGuid = platformDataStructuresToDataAttributesGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformDataStructuresToDataAttributesEntity that = (PlatformDataStructuresToDataAttributesEntity) o;

        if (platformDataStructuresToDataAttributesId != that.platformDataStructuresToDataAttributesId) return false;
        if (compositeDataStructureName != null ? !compositeDataStructureName.equals(that.compositeDataStructureName) : that.compositeDataStructureName != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (refdataApplication != null ? !refdataApplication.equals(that.refdataApplication) : that.refdataApplication != null) return false;
        if (refdataSensitivityflag != null ? !refdataSensitivityflag.equals(that.refdataSensitivityflag) : that.refdataSensitivityflag != null) return false;
        if (platformDataattributes != null ? !platformDataattributes.equals(that.platformDataattributes) : that.platformDataattributes != null) return false;
        if (platformDatastructures != null ? !platformDatastructures.equals(that.platformDatastructures) : that.platformDatastructures!= null) return false;
        if (platformDataStructuresToDataAttributesGuid != null ? !platformDataStructuresToDataAttributesGuid.equals(that.platformDataStructuresToDataAttributesGuid) : that.platformDataStructuresToDataAttributesGuid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) platformDataStructuresToDataAttributesId;
        result = 31 * result + (compositeDataStructureName != null ? compositeDataStructureName.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (platformDataStructuresToDataAttributesGuid != null ? platformDataStructuresToDataAttributesGuid.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (refdataApplication != null ? refdataApplication.hashCode() : 0);
        result = 31 * result + (refdataSensitivityflag != null ? refdataSensitivityflag.hashCode() : 0);
        result = 31 * result + (platformDataattributes != null ? platformDataattributes.hashCode() : 0);
        result = 31 * result + (platformDatastructures != null ? platformDatastructures.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PlatformDataStructuresID", referencedColumnName = "PlatformDataStructuresID")
    public PlatformDataStructuresEntity getPlatformDatastructures() {
        return platformDatastructures;
    }

    public void setPlatformDatastructures(PlatformDataStructuresEntity platformDatastructures) {
        this.platformDatastructures = platformDatastructures;
    }

    @ManyToOne
    @JoinColumn(name = "PlatformDataAttributesID", referencedColumnName = "PlatformDataAttributesID")
    public PlatformDataAttributesEntity getPlatformDataattributes() {
        return platformDataattributes;
    }

    public void setPlatformDataattributes(PlatformDataAttributesEntity platformDataattributes) {
        this.platformDataattributes = platformDataattributes;
    }

    @ManyToOne
    @JoinColumn(name = "RegisteredApp", referencedColumnName = "AppGUID")
    public RefDataApplicationEntity getRefdataApplication() {
        return refdataApplication;
    }

    public void setRefdataApplication(RefDataApplicationEntity refdataApplication) {
        this.refdataApplication = refdataApplication;
    }

    @ManyToOne
    @JoinColumn(name = "SensitivityFlagID", referencedColumnName = "SensitiveFlagID")
    public RefDataSensitivityFlagEntity getRefdataSensitivityflag() {
        return refdataSensitivityflag;
    }

    public void setRefdataSensitivityflag(RefDataSensitivityFlagEntity refdataSensitivityflag) {
        this.refdataSensitivityflag = refdataSensitivityflag;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<PlatformDataStructuresToDataAttributesEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
