package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "terms_codesetstoapplication", schema = "datasynthesis", catalog = "")
public class TermsCodesetstoapplicationEntity {
    private Long id;
    private long codeSetToApplicationId;
    private long codeSetsId;
    private String domain;
    private String industryStd;
    private String specificDetails;
    private Timestamp createdDate;
    private Short statusId;
    private String createdUser;
    private String organizationId;
    private String applicationId;
    private Integer vendorId;
    private String codeValue;
    private String codeDesc;
    private Short sensitiveFlagId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "CodeSetToApplicationID", nullable = false)
    public long getCodeSetToApplicationId() {
        return codeSetToApplicationId;
    }

    public void setCodeSetToApplicationId(long codeSetToApplicationId) {
        this.codeSetToApplicationId = codeSetToApplicationId;
    }

    @Basic
    @Column(name = "CodeSetsID", nullable = false)
    public long getCodeSetsId() {
        return codeSetsId;
    }

    public void setCodeSetsId(long codeSetsId) {
        this.codeSetsId = codeSetsId;
    }

    @Basic
    @Column(name = "Domain", nullable = true, length = 50)
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Basic
    @Column(name = "IndustryStd", nullable = true, length = 6)
    public String getIndustryStd() {
        return industryStd;
    }

    public void setIndustryStd(String industryStd) {
        this.industryStd = industryStd;
    }

    @Basic
    @Column(name = "SpecificDetails", nullable = true, length = 99)
    public String getSpecificDetails() {
        return specificDetails;
    }

    public void setSpecificDetails(String specificDetails) {
        this.specificDetails = specificDetails;
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
    @Column(name = "OrganizationID", nullable = true, length = 38)
    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @Basic
    @Column(name = "ApplicationID", nullable = true, length = 38)
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Basic
    @Column(name = "VendorID", nullable = true)
    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    @Basic
    @Column(name = "CodeValue", nullable = true, length = 20)
    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    @Basic
    @Column(name = "CodeDesc", nullable = true, length = 129)
    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    @Basic
    @Column(name = "SensitiveFlagID", nullable = true)
    public Short getSensitiveFlagId() {
        return sensitiveFlagId;
    }

    public void setSensitiveFlagId(Short sensitiveFlagId) {
        this.sensitiveFlagId = sensitiveFlagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TermsCodesetstoapplicationEntity that = (TermsCodesetstoapplicationEntity) o;

        if (codeSetToApplicationId != that.codeSetToApplicationId) return false;
        if (codeSetsId != that.codeSetsId) return false;
        if (domain != null ? !domain.equals(that.domain) : that.domain != null) return false;
        if (industryStd != null ? !industryStd.equals(that.industryStd) : that.industryStd != null) return false;
        if (specificDetails != null ? !specificDetails.equals(that.specificDetails) : that.specificDetails != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (organizationId != null ? !organizationId.equals(that.organizationId) : that.organizationId != null)
            return false;
        if (applicationId != null ? !applicationId.equals(that.applicationId) : that.applicationId != null)
            return false;
        if (vendorId != null ? !vendorId.equals(that.vendorId) : that.vendorId != null) return false;
        if (codeValue != null ? !codeValue.equals(that.codeValue) : that.codeValue != null) return false;
        if (codeDesc != null ? !codeDesc.equals(that.codeDesc) : that.codeDesc != null) return false;
        if (sensitiveFlagId != null ? !sensitiveFlagId.equals(that.sensitiveFlagId) : that.sensitiveFlagId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeSetToApplicationId ^ (codeSetToApplicationId >>> 32));
        result = 31 * result + (int) (codeSetsId ^ (codeSetsId >>> 32));
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (industryStd != null ? industryStd.hashCode() : 0);
        result = 31 * result + (specificDetails != null ? specificDetails.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (applicationId != null ? applicationId.hashCode() : 0);
        result = 31 * result + (vendorId != null ? vendorId.hashCode() : 0);
        result = 31 * result + (codeValue != null ? codeValue.hashCode() : 0);
        result = 31 * result + (codeDesc != null ? codeDesc.hashCode() : 0);
        result = 31 * result + (sensitiveFlagId != null ? sensitiveFlagId.hashCode() : 0);
        return result;
    }
}
