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
@Table(name = "auditing_datarequestdetail", schema = "datasynthesis", catalog = "")
public class AuditingDataRequestDetailEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long dataRequestDetailId;
    private Long recCount;
    private String recordFormatDetails;
    private Timestamp createdDate;
    private AuditingDataRequestEntity auditingDataRequest;
    private PlatformDataAttributesEntity platformDataAttributes;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "DataRequestDetailID", nullable = false)
    public long getDataRequestDetailId() {
        return dataRequestDetailId;
    }

    public void setDataRequestDetailId(long dataRequestDetailId) {
        this.dataRequestDetailId = dataRequestDetailId;
    }

    @Basic
    @Column(name = "RecCount", nullable = true)
    public Long getRecCount() {
        return recCount;
    }

    public void setRecCount(Long recCount) {
        this.recCount = recCount;
    }

    @Basic
    @Column(name = "RecordFormatDetails", nullable = true, length = 75)
    public String getRecordFormatDetails() {
        return recordFormatDetails;
    }

    public void setRecordFormatDetails(String recordFormatDetails) {
        this.recordFormatDetails = recordFormatDetails;
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

        AuditingDataRequestDetailEntity that = (AuditingDataRequestDetailEntity) o;

        if (dataRequestDetailId != that.dataRequestDetailId) return false;
        if (recCount != null ? !recCount.equals(that.recCount) : that.recCount != null) return false;
        if (recordFormatDetails != null ? !recordFormatDetails.equals(that.recordFormatDetails) : that.recordFormatDetails != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (auditingDataRequest != null ? !auditingDataRequest.equals(that.auditingDataRequest) : that.auditingDataRequest != null) return false;
        if (platformDataAttributes != null ? !platformDataAttributes.equals(that.platformDataAttributes) : that.platformDataAttributes != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dataRequestDetailId ^ (dataRequestDetailId >>> 32));
        result = 31 * result + (recCount != null ? recCount.hashCode() : 0);
        result = 31 * result + (recordFormatDetails != null ? recordFormatDetails.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (auditingDataRequest != null ? auditingDataRequest.hashCode() : 0);
        result = 31 * result + (platformDataAttributes != null ? platformDataAttributes.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "DataRequestID", referencedColumnName = "DataRequestID")
    public AuditingDataRequestEntity getAuditingDataRequest() {
        return auditingDataRequest;
    }

    public void setAuditingDataRequest(AuditingDataRequestEntity auditingDataRequest) {
        this.auditingDataRequest = auditingDataRequest;
    }

    @ManyToOne
    @JoinColumn(name = "DataAttributeID", referencedColumnName = "PlatformDataAttributesID")
    public PlatformDataAttributesEntity getPlatformDataAttributes() {
        return platformDataAttributes;
    }

    public void setPlatformDataAttributes(PlatformDataAttributesEntity platformDataAttributes) {
        this.platformDataAttributes = platformDataAttributes;
    }

    public static List<AuditingDataRequestDetailEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
