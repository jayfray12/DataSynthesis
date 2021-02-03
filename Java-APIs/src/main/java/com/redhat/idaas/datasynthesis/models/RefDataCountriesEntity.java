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
@Table(name = "refdata_countries", schema = "datasynthesis", catalog = "")
public class RefDataCountriesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private short countryId;
    private String idd;
    private String countryName;
    private Timestamp createdDate;
    private RefDataStatusEntity refdataStatus;

    public RefDataCountriesEntity() {
    }

    public RefDataCountriesEntity(short countryId) {
        this.countryId = countryId;
    }
    
    public RefDataCountriesEntity(short countryId, String idd, String countryName, Timestamp createdDate) {
        this.countryId = countryId;
        this.idd = idd;
        this.countryName = countryName;
        this.createdDate = createdDate;
    }

    @Id
    @Column(name = "CountryID", nullable = false)
    public short getCountryId() {
        return countryId;
    }

    public void setCountryId(short countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "IDD", nullable = true, length = 5)
    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    @Basic
    @Column(name = "CountryName", nullable = true, length = 59)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefDataCountriesEntity that = (RefDataCountriesEntity) o;

        if (countryId != that.countryId) return false;
        if (idd != null ? !idd.equals(that.idd) : that.idd != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) countryId;
        result = 31 * result + (idd != null ? idd.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
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

    public static List<RefDataCountriesEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
