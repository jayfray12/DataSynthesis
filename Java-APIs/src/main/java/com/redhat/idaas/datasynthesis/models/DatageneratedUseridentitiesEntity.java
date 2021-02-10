package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "datagenerated_useridentities", schema = "datasynthesis", catalog = "")
public class DatageneratedUseridentitiesEntity {
    private Long id;
    private long userIdentitiesId;
    private String userIdentityValue;
    private String userDomain;
    private String additionalAttributes;
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
    @Column(name = "UserIdentitiesID", nullable = false)
    public long getUserIdentitiesId() {
        return userIdentitiesId;
    }

    public void setUserIdentitiesId(long userIdentitiesId) {
        this.userIdentitiesId = userIdentitiesId;
    }

    @Basic
    @Column(name = "UserIdentityValue", nullable = true, length = 20)
    public String getUserIdentityValue() {
        return userIdentityValue;
    }

    public void setUserIdentityValue(String userIdentityValue) {
        this.userIdentityValue = userIdentityValue;
    }

    @Basic
    @Column(name = "UserDomain", nullable = true, length = 20)
    public String getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(String userDomain) {
        this.userDomain = userDomain;
    }

    @Basic
    @Column(name = "AdditionalAttributes", nullable = true, length = 40)
    public String getAdditionalAttributes() {
        return additionalAttributes;
    }

    public void setAdditionalAttributes(String additionalAttributes) {
        this.additionalAttributes = additionalAttributes;
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

        DatageneratedUseridentitiesEntity that = (DatageneratedUseridentitiesEntity) o;

        if (userIdentitiesId != that.userIdentitiesId) return false;
        if (userIdentityValue != null ? !userIdentityValue.equals(that.userIdentityValue) : that.userIdentityValue != null)
            return false;
        if (userDomain != null ? !userDomain.equals(that.userDomain) : that.userDomain != null) return false;
        if (additionalAttributes != null ? !additionalAttributes.equals(that.additionalAttributes) : that.additionalAttributes != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userIdentitiesId ^ (userIdentitiesId >>> 32));
        result = 31 * result + (userIdentityValue != null ? userIdentityValue.hashCode() : 0);
        result = 31 * result + (userDomain != null ? userDomain.hashCode() : 0);
        result = 31 * result + (additionalAttributes != null ? additionalAttributes.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
