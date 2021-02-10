package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "datagenerated_addresses", schema = "datasynthesis", catalog = "")
public class DatageneratedAddressesEntity {
    private Long id;
    private long addressId;
    private String addressStreet;
    private String addressStreet2;
    private Timestamp createdDate;
    private Short statusId;
    private Short addressFormatTypeId;
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
    @Column(name = "AddressID", nullable = false)
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "AddressStreet", nullable = true, length = 99)
    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    @Basic
    @Column(name = "AddressStreet2", nullable = true, length = 59)
    public String getAddressStreet2() {
        return addressStreet2;
    }

    public void setAddressStreet2(String addressStreet2) {
        this.addressStreet2 = addressStreet2;
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
    @Column(name = "AddressFormatTypeId", nullable = true)
    public Short getAddressFormatTypeId() {
        return addressFormatTypeId;
    }

    public void setAddressFormatTypeId(Short addressFormatTypeId) {
        this.addressFormatTypeId = addressFormatTypeId;
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

        DatageneratedAddressesEntity that = (DatageneratedAddressesEntity) o;

        if (addressId != that.addressId) return false;
        if (addressStreet != null ? !addressStreet.equals(that.addressStreet) : that.addressStreet != null)
            return false;
        if (addressStreet2 != null ? !addressStreet2.equals(that.addressStreet2) : that.addressStreet2 != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (addressFormatTypeId != null ? !addressFormatTypeId.equals(that.addressFormatTypeId) : that.addressFormatTypeId != null)
            return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (addressStreet != null ? addressStreet.hashCode() : 0);
        result = 31 * result + (addressStreet2 != null ? addressStreet2.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (addressFormatTypeId != null ? addressFormatTypeId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
