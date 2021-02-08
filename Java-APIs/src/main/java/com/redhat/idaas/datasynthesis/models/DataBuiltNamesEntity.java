package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "databuilt_names", schema = "datasynthesis", catalog = "")
public class DataBuiltNamesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long dataBuiltNamesId;
    private String completeName;
    private Timestamp createdDate;
    private String registeredApp;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "DataBuiltNamesID", nullable = false)
    public long getDataBuiltNamesId() {
        return dataBuiltNamesId;
    }

    public void setDataBuiltNamesId(long dataBuiltNamesId) {
        this.dataBuiltNamesId = dataBuiltNamesId;
    }

    @Basic
    @Column(name = "CompleteName", nullable = true, length = 100)
    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
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
    @Column(name = "RegisteredApp", nullable = true, length = 38)
    public String getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(String registeredApp) {
        this.registeredApp = registeredApp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataBuiltNamesEntity that = (DataBuiltNamesEntity) o;

        if (dataBuiltNamesId != that.dataBuiltNamesId) return false;
        if (completeName != null ? !completeName.equals(that.completeName) : that.completeName != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dataBuiltNamesId ^ (dataBuiltNamesId >>> 32));
        result = 31 * result + (completeName != null ? completeName.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
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

    public static List<DataBuiltNamesEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
