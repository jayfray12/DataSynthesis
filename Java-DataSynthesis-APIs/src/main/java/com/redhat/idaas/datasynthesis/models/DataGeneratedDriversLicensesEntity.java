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
@Table(name = "datagenerated_driverslicenses", schema = "datasynthesis", catalog = "")
public class DataGeneratedDriversLicensesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long driversLicensesId;
    private String dln;
    private Timestamp createdDate;
    private String completeDriversLicenseNumber;
    private String createdUser;
    private String registeredApp;
    private RefDataUsStatesEntity refdataUsstates;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "DriversLicensesID", nullable = false)
    public long getDriversLicensesId() {
        return driversLicensesId;
    }

    public void setDriversLicensesId(long driversLicensesId) {
        this.driversLicensesId = driversLicensesId;
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
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "CompleteDriversLicenseNumber", nullable = true, length = 30)
    public String getCompleteDriversLicenseNumber() {
        return completeDriversLicenseNumber;
    }

    public void setCompleteDriversLicenseNumber(String completeDriversLicenseNumber) {
        this.completeDriversLicenseNumber = completeDriversLicenseNumber;
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

        DataGeneratedDriversLicensesEntity that = (DataGeneratedDriversLicensesEntity) o;

        if (driversLicensesId != that.driversLicensesId) return false;
        if (dln != null ? !dln.equals(that.dln) : that.dln != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (completeDriversLicenseNumber != null ? !completeDriversLicenseNumber.equals(that.completeDriversLicenseNumber) : that.completeDriversLicenseNumber != null)
            return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (refdataUsstates != null ? !refdataUsstates.equals(that.refdataUsstates) : that.refdataUsstates != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (driversLicensesId ^ (driversLicensesId >>> 32));
        result = 31 * result + (dln != null ? dln.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (completeDriversLicenseNumber != null ? completeDriversLicenseNumber.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (refdataUsstates != null ? refdataUsstates.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "StateCode", referencedColumnName = "StateID")
    public RefDataUsStatesEntity getRefdataUsstates() {
        return refdataUsstates;
    }

    public void setRefdataUsstates(RefDataUsStatesEntity refdataUsstates) {
        this.refdataUsstates = refdataUsstates;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<DataGeneratedDriversLicensesEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
