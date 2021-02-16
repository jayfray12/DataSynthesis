package com.redhat.idaas.datasynthesis.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "datagenerated_socialsecuritynumber", schema = "datasynthesis", catalog = "")
public class DataGeneratedSocialSecurityNumberEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long socialSecurityNumberId;
    private String socialSecurityNumberValue;
    private Timestamp createdDate;
    private String createdUser;
    private RefDataStatusEntity status;
    private RefDataApplicationEntity registeredApp;

    public DataGeneratedSocialSecurityNumberEntity() {
    }

    public DataGeneratedSocialSecurityNumberEntity(String ssn) {
        socialSecurityNumberValue = ssn;
    }

    @Id
    @GeneratedValue
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
    @Column(name = "CreatedUser", nullable = true, length = 20)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataGeneratedSocialSecurityNumberEntity that = (DataGeneratedSocialSecurityNumberEntity) o;

        if (socialSecurityNumberId != that.socialSecurityNumberId) return false;
        if (socialSecurityNumberValue != null ? !socialSecurityNumberValue.equals(that.socialSecurityNumberValue) : that.socialSecurityNumberValue != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (socialSecurityNumberId ^ (socialSecurityNumberId >>> 32));
        result = 31 * result + (socialSecurityNumberValue != null ? socialSecurityNumberValue.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "RegisteredApp", referencedColumnName = "AppGUID")
    public RefDataApplicationEntity getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(RefDataApplicationEntity registeredApp) {
        this.registeredApp = registeredApp;
    }

    public static List<DataGeneratedSocialSecurityNumberEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }

    public static DataGeneratedSocialSecurityNumberEntity findBySSN(String ssn) {
        return find("socialSecurityNumberValue", ssn).firstResult();
    }

    public static void persist(DataGeneratedSocialSecurityNumberEntity entity) {
        if (null != entity) {
            entity.persist();
        }
    }
}
