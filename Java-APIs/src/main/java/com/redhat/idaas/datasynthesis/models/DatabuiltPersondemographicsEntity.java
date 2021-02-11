package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "databuilt_persondemographics", schema = "datasynthesis", catalog = "")
public class DatabuiltPersondemographicsEntity {
    private Long id;
    private long personDemographicsId;
    private String dln;
    private String dlnState;
    private String ssn;
    private String dobValue;
    private Date dobDate;
    private Integer age;
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
    @Column(name = "PersonDemographicsID", nullable = false)
    public long getPersonDemographicsId() {
        return personDemographicsId;
    }

    public void setPersonDemographicsId(long personDemographicsId) {
        this.personDemographicsId = personDemographicsId;
    }

    @Basic
    @Column(name = "DLN", nullable = true, length = 25)
    public String getDln() {
        return dln;
    }

    public void setDln(String dln) {
        this.dln = dln;
    }

    @Basic
    @Column(name = "DLNState", nullable = true, length = 2)
    public String getDlnState() {
        return dlnState;
    }

    public void setDlnState(String dlnState) {
        this.dlnState = dlnState;
    }

    @Basic
    @Column(name = "SSN", nullable = true, length = 11)
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "DOBValue", nullable = true, length = 12)
    public String getDobValue() {
        return dobValue;
    }

    public void setDobValue(String dobValue) {
        this.dobValue = dobValue;
    }

    @Basic
    @Column(name = "DOBDate", nullable = true)
    public Date getDobDate() {
        return dobDate;
    }

    public void setDobDate(Date dobDate) {
        this.dobDate = dobDate;
    }

    @Basic
    @Column(name = "Age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

        DatabuiltPersondemographicsEntity that = (DatabuiltPersondemographicsEntity) o;

        if (personDemographicsId != that.personDemographicsId) return false;
        if (dln != null ? !dln.equals(that.dln) : that.dln != null) return false;
        if (dlnState != null ? !dlnState.equals(that.dlnState) : that.dlnState != null) return false;
        if (ssn != null ? !ssn.equals(that.ssn) : that.ssn != null) return false;
        if (dobValue != null ? !dobValue.equals(that.dobValue) : that.dobValue != null) return false;
        if (dobDate != null ? !dobDate.equals(that.dobDate) : that.dobDate != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personDemographicsId ^ (personDemographicsId >>> 32));
        result = 31 * result + (dln != null ? dln.hashCode() : 0);
        result = 31 * result + (dlnState != null ? dlnState.hashCode() : 0);
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        result = 31 * result + (dobValue != null ? dobValue.hashCode() : 0);
        result = 31 * result + (dobDate != null ? dobDate.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
