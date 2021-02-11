package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "databuilt_names", schema = "datasynthesis", catalog = "")
public class DatabuiltNamesEntity {
    private Long id;
    private long dataBuiltNamesId;
    private String completeName;
    private Timestamp createdDate;
    private Short statusId;
    private String registeredApp;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    @Column(name = "StatusID", nullable = true)
    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
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

        DatabuiltNamesEntity that = (DatabuiltNamesEntity) o;

        if (dataBuiltNamesId != that.dataBuiltNamesId) return false;
        if (completeName != null ? !completeName.equals(that.completeName) : that.completeName != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dataBuiltNamesId ^ (dataBuiltNamesId >>> 32));
        result = 31 * result + (completeName != null ? completeName.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
