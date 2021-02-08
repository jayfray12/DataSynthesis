package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "databuilt_address", schema = "datasynthesis", catalog = "")
public class DataBuiltAddressEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long completeAddressId;
    private String address1;
    private String city;
    private String stateId;
    private String zipCode;
    private Timestamp createdDate;
    private String registeredApp;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "CompleteAddressID", nullable = false)
    public long getCompleteAddressId() {
        return completeAddressId;
    }

    public void setCompleteAddressId(final long completeAddressId) {
        this.completeAddressId = completeAddressId;
    }

    @Basic
    @Column(name = "Address1", nullable = true, length = 99)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(final String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 70)
    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "StateID", nullable = true, length = 2)
    public String getStateId() {
        return stateId;
    }

    public void setStateId(final String stateId) {
        this.stateId = stateId;
    }

    @Basic
    @Column(name = "ZipCode", nullable = true, length = 10)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "RegisteredApp", nullable = true, length = 38)
    public String getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(final String registeredApp) {
        this.registeredApp = registeredApp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final DataBuiltAddressEntity that = (DataBuiltAddressEntity) o;

        if (completeAddressId != that.completeAddressId) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (stateId != null ? !stateId.equals(that.stateId) : that.stateId != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (completeAddressId ^ (completeAddressId >>> 32));
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateId != null ? stateId.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
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

    public static List<DataBuiltAddressEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
