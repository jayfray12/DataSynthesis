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
@Table(name = "platform_datastructures", schema = "datasynthesis", catalog = "")
public class PlatformDataStructuresEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short platformDataStructuresId;
    private String dataStructureName;
    private Timestamp createdDate;
    private String createdUser;
    private String platformDataStructuresGuid;
    private RefDataStatusEntity refdataStatus;
    private RefDataApplicationEntity refdataApplication;
    private RefDataSensitivityFlagEntity refdataSensitivityflag;

    @Id
    @Column(name = "PlatformDataStructuresID", nullable = false)
    public short getPlatformDataStructuresId() {
        return platformDataStructuresId;
    }

    public void setPlatformDataStructuresId(short platformDataStructuresId) {
        this.platformDataStructuresId = platformDataStructuresId;
    }

    @Basic
    @Column(name = "DataStructureName", nullable = true, length = 50)
    public String getDataStructureName() {
        return dataStructureName;
    }

    public void setDataStructureName(String dataStructureName) {
        this.dataStructureName = dataStructureName;
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
    @Column(name = "PlatformDataStructuresGUID", nullable = true, length = 38)
    public String getPlatformDataStructuresGuid() {
        return platformDataStructuresGuid;
    }

    public void setPlatformDataStructuresGuid(String platformDataStructuresGuid) {
        this.platformDataStructuresGuid = platformDataStructuresGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformDataStructuresEntity that = (PlatformDataStructuresEntity) o;

        if (platformDataStructuresId != that.platformDataStructuresId) return false;
        if (dataStructureName != null ? !dataStructureName.equals(that.dataStructureName) : that.dataStructureName != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (refdataApplication != null ? !refdataApplication.equals(that.refdataApplication) : that.refdataApplication != null) return false;
        if (refdataSensitivityflag != null ? !refdataSensitivityflag.equals(that.refdataSensitivityflag) : that.refdataSensitivityflag != null) return false;
        if (platformDataStructuresGuid != null ? !platformDataStructuresGuid.equals(that.platformDataStructuresGuid) : that.platformDataStructuresGuid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) platformDataStructuresId;
        result = 31 * result + (dataStructureName != null ? dataStructureName.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (platformDataStructuresGuid != null ? platformDataStructuresGuid.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (refdataApplication != null ? refdataApplication.hashCode() : 0);
        result = 31 * result + (refdataSensitivityflag != null ? refdataSensitivityflag.hashCode() : 0);
        return result;
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

    public static List<PlatformDataStructuresEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
