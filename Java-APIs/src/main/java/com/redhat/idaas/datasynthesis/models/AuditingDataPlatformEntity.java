package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "auditing_dataplatform", schema = "datasynthesis", catalog = "")
public class AuditingDataPlatformEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long dataPlatformId;
    private Timestamp dataProcessingDate;
    private String createdByUser;
    private String organizaton;
    private String application;
    private Timestamp createdDate;
    private Integer recCount;
    private String component;
    private String actionName;
    private Integer durationToRun;
    private String activityDetail;
    private RefDataStatusEntity status;

    @Id
    @GeneratedValue
    @Column(name = "DataPlatformID", nullable = false)
    public long getDataPlatformId() {
        return dataPlatformId;
    }

    public void setDataPlatformId(long dataPlatformId) {
        this.dataPlatformId = dataPlatformId;
    }

    @Basic
    @Column(name = "DataProcessingDate", nullable = true)
    public Timestamp getDataProcessingDate() {
        return dataProcessingDate;
    }

    public void setDataProcessingDate(Timestamp dataProcessingDate) {
        this.dataProcessingDate = dataProcessingDate;
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
    @Column(name = "Component", nullable = true, length = 20)
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Basic
    @Column(name = "ActionName", nullable = true, length = 20)
    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Basic
    @Column(name = "DurationToRun", nullable = true)
    public Integer getDurationToRun() {
        return durationToRun;
    }

    public void setDurationToRun(Integer durationToRun) {
        this.durationToRun = durationToRun;
    }

    @Basic
    @Column(name = "ActivityDetail", nullable = true, length = 75)
    public String getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditingDataPlatformEntity that = (AuditingDataPlatformEntity) o;

        if (dataPlatformId != that.dataPlatformId) return false;
        if (dataProcessingDate != null ? !dataProcessingDate.equals(that.dataProcessingDate) : that.dataProcessingDate != null)
            return false;
        if (createdByUser != null ? !createdByUser.equals(that.createdByUser) : that.createdByUser != null)
            return false;
        if (organizaton != null ? !organizaton.equals(that.organizaton) : that.organizaton != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (recCount != null ? !recCount.equals(that.recCount) : that.recCount != null) return false;
        if (component != null ? !component.equals(that.component) : that.component != null) return false;
        if (actionName != null ? !actionName.equals(that.actionName) : that.actionName != null) return false;
        if (durationToRun != null ? !durationToRun.equals(that.durationToRun) : that.durationToRun != null)
            return false;
        if (activityDetail != null ? !activityDetail.equals(that.activityDetail) : that.activityDetail != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dataPlatformId ^ (dataPlatformId >>> 32));
        result = 31 * result + (dataProcessingDate != null ? dataProcessingDate.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        result = 31 * result + (organizaton != null ? organizaton.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (recCount != null ? recCount.hashCode() : 0);
        result = 31 * result + (component != null ? component.hashCode() : 0);
        result = 31 * result + (actionName != null ? actionName.hashCode() : 0);
        result = 31 * result + (durationToRun != null ? durationToRun.hashCode() : 0);
        result = 31 * result + (activityDetail != null ? activityDetail.hashCode() : 0);
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

    public static List<AuditingDataPlatformEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}
