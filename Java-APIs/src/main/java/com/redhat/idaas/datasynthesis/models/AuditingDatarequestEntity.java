package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "auditing_datarequest", schema = "datasynthesis", catalog = "")
public class AuditingDatarequestEntity {
    private Long id;
    private long dataRequestId;
    private Timestamp dataRequestDate;
    private String createdByUser;
    private String organizaton;
    private String application;
    private Short statusId;
    private Timestamp createdDate;
    private Integer recCount;
    private String recordDataRequest;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    @Column(name = "Organizaton", nullable = true, length = 38)
    public String getOrganizaton() {
        return organizaton;
    }

    public void setOrganizaton(String organizaton) {
        this.organizaton = organizaton;
    }

    @Basic
    @Column(name = "Application", nullable = true, length = 38)
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
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
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "RecCount", nullable = true)
    public Integer getRecCount() {
        return recCount;
    }

    public void setRecCount(Integer recCount) {
        this.recCount = recCount;
    }

    @Basic
    @Column(name = "RecordDataRequest", nullable = true, length = 400)
    public String getRecordDataRequest() {
        return recordDataRequest;
    }

    public void setRecordDataRequest(String recordDataRequest) {
        this.recordDataRequest = recordDataRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditingDatarequestEntity that = (AuditingDatarequestEntity) o;

        if (dataRequestId != that.dataRequestId) return false;
        if (dataRequestDate != null ? !dataRequestDate.equals(that.dataRequestDate) : that.dataRequestDate != null)
            return false;
        if (createdByUser != null ? !createdByUser.equals(that.createdByUser) : that.createdByUser != null)
            return false;
        if (organizaton != null ? !organizaton.equals(that.organizaton) : that.organizaton != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (recCount != null ? !recCount.equals(that.recCount) : that.recCount != null) return false;
        if (recordDataRequest != null ? !recordDataRequest.equals(that.recordDataRequest) : that.recordDataRequest != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dataRequestId ^ (dataRequestId >>> 32));
        result = 31 * result + (dataRequestDate != null ? dataRequestDate.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (organizaton != null ? organizaton.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (recCount != null ? recCount.hashCode() : 0);
        result = 31 * result + (recordDataRequest != null ? recordDataRequest.hashCode() : 0);
        return result;
    }
}
