package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "datagenerated_socialsecuritynumber", schema = "datasynthesis", catalog = "")
public class DatageneratedSocialsecuritynumberEntity {
    private Long id;
    private long socialSecurityNumberId;
    private String socialSecurityNumberValue;
    private Timestamp createdDate;
    private Short statusId;
    private String createdUser;
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
    @Column(name = "SocialSecurityNumberID", nullable = false)
    public long getSocialSecurityNumberId() {
        return socialSecurityNumberId;
    }

    public void setSocialSecurityNumberId(long socialSecurityNumberId) {
        this.socialSecurityNumberId = socialSecurityNumberId;
    }

    @Basic
    @Column(name = "SocialSecurityNumberValue", nullable = true, length = 11)
    public String getSocialSecurityNumberValue() {
        return socialSecurityNumberValue;
    }

    public void setSocialSecurityNumberValue(String socialSecurityNumberValue) {
        this.socialSecurityNumberValue = socialSecurityNumberValue;
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
    @Column(name = "CreatedUser", nullable = true, length = 20)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
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

        DatageneratedSocialsecuritynumberEntity that = (DatageneratedSocialsecuritynumberEntity) o;

        if (socialSecurityNumberId != that.socialSecurityNumberId) return false;
        if (socialSecurityNumberValue != null ? !socialSecurityNumberValue.equals(that.socialSecurityNumberValue) : that.socialSecurityNumberValue != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (socialSecurityNumberId ^ (socialSecurityNumberId >>> 32));
        result = 31 * result + (socialSecurityNumberValue != null ? socialSecurityNumberValue.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
