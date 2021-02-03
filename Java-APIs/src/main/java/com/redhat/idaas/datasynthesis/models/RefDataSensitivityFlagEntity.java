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
@Table(name = "refdata_sensitivityflag", schema = "datasynthesis", catalog = "")
public class RefDataSensitivityFlagEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short sensitiveFlagId;
    private String sensitiveFlagDesc;
    private Timestamp createdDate;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "SensitiveFlagID", nullable = false)
    public short getSensitiveFlagId() {
        return sensitiveFlagId;
    }

    public void setSensitiveFlagId(short sensitiveFlagId) {
        this.sensitiveFlagId = sensitiveFlagId;
    }

    @Basic
    @Column(name = "SensitiveFlagDesc", nullable = true, length = 30)
    public String getSensitiveFlagDesc() {
        return sensitiveFlagDesc;
    }

    public void setSensitiveFlagDesc(String sensitiveFlagDesc) {
        this.sensitiveFlagDesc = sensitiveFlagDesc;
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

        RefDataSensitivityFlagEntity that = (RefDataSensitivityFlagEntity) o;

        if (sensitiveFlagId != that.sensitiveFlagId) return false;
        if (sensitiveFlagDesc != null ? !sensitiveFlagDesc.equals(that.sensitiveFlagDesc) : that.sensitiveFlagDesc != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) sensitiveFlagId;
        result = 31 * result + (sensitiveFlagDesc != null ? sensitiveFlagDesc.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
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

    public static List<RefDataSensitivityFlagEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
