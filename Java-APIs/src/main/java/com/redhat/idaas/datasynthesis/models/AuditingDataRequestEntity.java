package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "auditing_datarequest", schema = "datasynthesis", catalog = "")
public class AuditingDataRequestEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long dataRequestId;
    private Timestamp dataRequestDate;
    private String createdByUser;
    private Long organizaton;
    private Long application;
    private Timestamp createdDate;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "DataRequestID", nullable = false)
    public long getDataRequestId() {
        return dataRequestId;
    }

    public void setDataRequestId(long dataRequestId) {
        this.dataRequestId = dataRequestId;
    }

    @Basic
    @Column(name = "DataRequestDate", nullable = true)
    public Timestamp getDataRequestDate() {
        return dataRequestDate;
    }

    public void setDataRequestDate(Timestamp dataRequestDate) {
        this.dataRequestDate = dataRequestDate;
    }

    @Basic
    @Column(name = "CreatedByUser", nullable = true, length = 20)
    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    @Basic
    @Column(name = "Organizaton", nullable = true)
    public Long getOrganizaton() {
        return organizaton;
    }

    public void setOrganizaton(Long organizaton) {
        this.organizaton = organizaton;
    }

    @Basic
    @Column(name = "Application", nullable = true)
    public Long getApplication() {
        return application;
    }

    public void setApplication(Long application) {
        this.application = application;
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

        AuditingDataRequestEntity that = (AuditingDataRequestEntity) o;

        if (dataRequestId != that.dataRequestId) return false;
        if (dataRequestDate != null ? !dataRequestDate.equals(that.dataRequestDate) : that.dataRequestDate != null)
            return false;
        if (createdByUser != null ? !createdByUser.equals(that.createdByUser) : that.createdByUser != null)
            return false;
        if (organizaton != null ? !organizaton.equals(that.organizaton) : that.organizaton != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dataRequestId ^ (dataRequestId >>> 32));
        result = 31 * result + (dataRequestDate != null ? dataRequestDate.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (organizaton != null ? organizaton.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
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

    public static List<AuditingDataRequestEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
