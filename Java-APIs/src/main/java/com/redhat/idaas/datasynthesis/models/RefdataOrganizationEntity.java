package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "refdata_organization", schema = "datasynthesis", catalog = "")
public class RefdataOrganizationEntity {
    private Long id;
    private String organizationGuid;
    private String organizationInternalCode;
    private String organizationInternalId;
    private String organizationName;
    private String address;
    private String city;
    private String stateId;
    private String zipCode;
    private String createdUser;
    private Short statusId;
    private Timestamp createdDate;
    private String legalEntityGuid;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "OrganizationGUID", nullable = false, length = 38)
    public String getOrganizationGuid() {
        return organizationGuid;
    }

    public void setOrganizationGuid(String organizationGuid) {
        this.organizationGuid = organizationGuid;
    }

    @Basic
    @Column(name = "OrganizationInternalCode", nullable = true, length = 10)
    public String getOrganizationInternalCode() {
        return organizationInternalCode;
    }

    public void setOrganizationInternalCode(String organizationInternalCode) {
        this.organizationInternalCode = organizationInternalCode;
    }

    @Basic
    @Column(name = "OrganizationInternalID", nullable = true, length = 10)
    public String getOrganizationInternalId() {
        return organizationInternalId;
    }

    public void setOrganizationInternalId(String organizationInternalId) {
        this.organizationInternalId = organizationInternalId;
    }

    @Basic
    @Column(name = "OrganizationName", nullable = true, length = 50)
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 75)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 60)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "StateID", nullable = true, length = 2)
    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    @Basic
    @Column(name = "ZipCode", nullable = true, length = 12)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
    @Column(name = "StatusID", nullable = true)
    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = false)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "LegalEntityGUID", nullable = true, length = 38)
    public String getLegalEntityGuid() {
        return legalEntityGuid;
    }

    public void setLegalEntityGuid(String legalEntityGuid) {
        this.legalEntityGuid = legalEntityGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefdataOrganizationEntity that = (RefdataOrganizationEntity) o;

        if (organizationGuid != null ? !organizationGuid.equals(that.organizationGuid) : that.organizationGuid != null)
            return false;
        if (organizationInternalCode != null ? !organizationInternalCode.equals(that.organizationInternalCode) : that.organizationInternalCode != null)
            return false;
        if (organizationInternalId != null ? !organizationInternalId.equals(that.organizationInternalId) : that.organizationInternalId != null)
            return false;
        if (organizationName != null ? !organizationName.equals(that.organizationName) : that.organizationName != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (stateId != null ? !stateId.equals(that.stateId) : that.stateId != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (legalEntityGuid != null ? !legalEntityGuid.equals(that.legalEntityGuid) : that.legalEntityGuid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organizationGuid != null ? organizationGuid.hashCode() : 0;
        result = 31 * result + (organizationInternalCode != null ? organizationInternalCode.hashCode() : 0);
        result = 31 * result + (organizationInternalId != null ? organizationInternalId.hashCode() : 0);
        result = 31 * result + (organizationName != null ? organizationName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateId != null ? stateId.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (legalEntityGuid != null ? legalEntityGuid.hashCode() : 0);
        return result;
    }
}
