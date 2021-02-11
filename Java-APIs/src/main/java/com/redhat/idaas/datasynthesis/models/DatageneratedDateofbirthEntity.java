package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "datagenerated_dateofbirth", schema = "datasynthesis", catalog = "")
public class DatageneratedDateofbirthEntity {
    private Long id;
    private long dateofBirthsId;
    private String dateOfBirth;
    private Date dateOfBirthDate;
    private Integer age;
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
    @Column(name = "DateofBirthsID", nullable = false)
    public long getDateofBirthsId() {
        return dateofBirthsId;
    }

    public void setDateofBirthsId(long dateofBirthsId) {
        this.dateofBirthsId = dateofBirthsId;
    }

    @Basic
    @Column(name = "DateOfBirth", nullable = true, length = 12)
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "DateOfBirthDate", nullable = true)
    public Date getDateOfBirthDate() {
        return dateOfBirthDate;
    }

    public void setDateOfBirthDate(Date dateOfBirthDate) {
        this.dateOfBirthDate = dateOfBirthDate;
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

        DatageneratedDateofbirthEntity that = (DatageneratedDateofbirthEntity) o;

        if (dateofBirthsId != that.dateofBirthsId) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (dateOfBirthDate != null ? !dateOfBirthDate.equals(that.dateOfBirthDate) : that.dateOfBirthDate != null)
            return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dateofBirthsId ^ (dateofBirthsId >>> 32));
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (dateOfBirthDate != null ? dateOfBirthDate.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
