package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "refdata_platformparams", schema = "datasynthesis", catalog = "")
public class RefdataPlatformparamsEntity {
    private Long id;
    private short platformParamsId;
    private String platformParamValues;
    private String platformParamDesc;
    private Timestamp createdDate;
    private Short statusId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
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

    @Basic
    @Column(name = "StatusID", nullable = true)
    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefdataPlatformparamsEntity that = (RefdataPlatformparamsEntity) o;

        if (platformParamsId != that.platformParamsId) return false;
        if (platformParamValues != null ? !platformParamValues.equals(that.platformParamValues) : that.platformParamValues != null)
            return false;
        if (platformParamDesc != null ? !platformParamDesc.equals(that.platformParamDesc) : that.platformParamDesc != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) platformParamsId;
        result = 31 * result + (platformParamValues != null ? platformParamValues.hashCode() : 0);
        result = 31 * result + (platformParamDesc != null ? platformParamDesc.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        return result;
    }
}
