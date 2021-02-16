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
@Table(name = "refdata_organization", schema = "datasynthesis", catalog = "")
public class RefDataOrganizationEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private String organizationGuid;
    private String organizationInternalCode;
    private String organizationInternalId;
    private String organizationName;
    private String address;
    private String city;
    private RefDataUsStatesEntity state;
    private String zipCode;
    private String createdUser;
    private RefDataStatusEntity status;
    private Timestamp createdDate;
    private RefDataLegalEntityEntity legalEntityGuid;

    @Id
    @GeneratedValue
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
    @Column(name = "CreatedDate", nullable = false)
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

        RefDataOrganizationEntity that = (RefDataOrganizationEntity) o;

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
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
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
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (legalEntityGuid != null ? legalEntityGuid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LegalEntityGUID", referencedColumnName = "LegalEntityGUID")
    public RefDataLegalEntityEntity getLegalEntityGuid() {
        return legalEntityGuid;
    }

    public void setLegalEntityGuid(RefDataLegalEntityEntity legalEntityGuid) {
        this.legalEntityGuid = legalEntityGuid;
    }

    @ManyToOne
    @JoinColumn(name = "StateID", referencedColumnName = "StateID")
    public RefDataUsStatesEntity getState() {
        return state;
    }

    public void setState(RefDataUsStatesEntity state) {
        this.state = state;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getStatus() {
        return status;
    }

    public void setStatus(RefDataStatusEntity status) {
        this.status = status;
    }

    public static List<RefDataOrganizationEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}
