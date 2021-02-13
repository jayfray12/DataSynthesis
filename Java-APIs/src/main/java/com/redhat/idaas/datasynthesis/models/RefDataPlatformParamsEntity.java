package com.redhat.idaas.datasynthesis.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "refdata_platformparams", schema = "datasynthesis", catalog = "")
public class RefDataPlatformParamsEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short platformParamsId;
    private String platformParamValues;
    private String platformParamDesc;
    private Timestamp createdDate;
    private RefDataStatusEntity status;

    @Id
    @GeneratedValue
    @Column(name = "PlatformParamsID", nullable = false)
    public short getPlatformParamsId() {
        return platformParamsId;
    }

    public void setPlatformParamsId(short platformParamsId) {
        this.platformParamsId = platformParamsId;
    }

    @Basic
    @Column(name = "PlatformParamValues", nullable = true, length = 35)
    public String getPlatformParamValues() {
        return platformParamValues;
    }

    public void setPlatformParamValues(String platformParamValues) {
        this.platformParamValues = platformParamValues;
    }

    @Basic
    @Column(name = "PlatformParamDesc", nullable = true, length = 70)
    public String getPlatformParamDesc() {
        return platformParamDesc;
    }

    public void setPlatformParamDesc(String platformParamDesc) {
        this.platformParamDesc = platformParamDesc;
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

        RefDataPlatformParamsEntity that = (RefDataPlatformParamsEntity) o;

        if (platformParamsId != that.platformParamsId) return false;
        if (platformParamValues != null ? !platformParamValues.equals(that.platformParamValues) : that.platformParamValues != null)
            return false;
        if (platformParamDesc != null ? !platformParamDesc.equals(that.platformParamDesc) : that.platformParamDesc != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) platformParamsId;
        result = 31 * result + (platformParamValues != null ? platformParamValues.hashCode() : 0);
        result = 31 * result + (platformParamDesc != null ? platformParamDesc.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getStatus() {
        return status;
    }

    public void setStatus(RefDataStatusEntity status) {
        this.status = status;
    }

    public static List<RefDataPlatformParamsEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}
