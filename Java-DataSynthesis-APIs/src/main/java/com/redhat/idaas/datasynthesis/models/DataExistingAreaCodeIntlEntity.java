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
@Table(name = "dataexisting_areacodeintl", schema = "datasynthesis", catalog = "")
public class DataExistingAreaCodeIntlEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private String iddCode;
    private Timestamp createdDate;
    private String registeredApp;
    private RefDataStatusEntity refdataStatus;
    private RefDataCountriesEntity refdataCountries;

    @Id
    @Column(name = "IDDCode", nullable = false, length = 5)
    public String getIddCode() {
        return iddCode;
    }

    public void setIddCode(String iddCode) {
        this.iddCode = iddCode;
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

        DataExistingAreaCodeIntlEntity that = (DataExistingAreaCodeIntlEntity) o;

        if (iddCode != null ? !iddCode.equals(that.iddCode) : that.iddCode != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (refdataCountries != null ? !refdataCountries.equals(that.refdataCountries) : that.refdataCountries != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iddCode != null ? iddCode.hashCode() : 0;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (refdataCountries != null ? refdataCountries.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CountryID", referencedColumnName = "CountryID")
    public RefDataCountriesEntity getRefdataCountries() {
        return refdataCountries;
    }

    public void setRefdataCountries(RefDataCountriesEntity refdataCountries) {
        this.refdataCountries = refdataCountries;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<DataExistingAreaCodeIntlEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
