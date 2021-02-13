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
@Table(name = "terms_codesetstoapplication", schema = "datasynthesis", catalog = "")
public class TermsCodeSetsToApplicationEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long codeSetToApplicationId;
    private RefDataCodeSetEntity codeSets;
    private String domain;
    private RefDataIndustryStdEntity industryStd;
    private String specificDetails;
    private Timestamp createdDate;
    private RefDataStatusEntity status;
    private String createdUser;
    private RefDataOrganizationEntity organization;
    private RefDataApplicationEntity application;
    private RefDataVendorEntity vendor;
    private String codeValue;
    private String codeDesc;
    private RefDataSensitivityFlagEntity sensitiveFlag;

    @Id
    @GeneratedValue
    @Column(name = "CodeSetToApplicationID", nullable = false)
    public long getCodeSetToApplicationId() {
        return codeSetToApplicationId;
    }

    public void setCodeSetToApplicationId(long codeSetToApplicationId) {
        this.codeSetToApplicationId = codeSetToApplicationId;
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
    @Column(name = "CreatedUser", nullable = true, length = 20)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TermsCodeSetsToApplicationEntity that = (TermsCodeSetsToApplicationEntity) o;

        if (codeSetToApplicationId != that.codeSetToApplicationId) return false;
        if (codeSets != null ? !codeSets.equals(that.codeSets) : that.codeSets != null) return false;
        if (domain != null ? !domain.equals(that.domain) : that.domain != null) return false;
        if (industryStd != null ? !industryStd.equals(that.industryStd) : that.industryStd != null) return false;
        if (specificDetails != null ? !specificDetails.equals(that.specificDetails) : that.specificDetails != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null)
            return false;
        if (application != null ? !application.equals(that.application) : that.application != null)
            return false;
        if (vendor != null ? !vendor.equals(that.vendor) : that.vendor != null) return false;
        if (codeValue != null ? !codeValue.equals(that.codeValue) : that.codeValue != null) return false;
        if (codeDesc != null ? !codeDesc.equals(that.codeDesc) : that.codeDesc != null) return false;
        if (sensitiveFlag != null ? !sensitiveFlag.equals(that.sensitiveFlag) : that.sensitiveFlag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeSetToApplicationId ^ (codeSetToApplicationId >>> 32));
        result = 31 * result + (codeSets != null ? codeSets.hashCode() : 0);
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (industryStd != null ? industryStd.hashCode() : 0);
        result = 31 * result + (specificDetails != null ? specificDetails.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        result = 31 * result + (codeValue != null ? codeValue.hashCode() : 0);
        result = 31 * result + (codeDesc != null ? codeDesc.hashCode() : 0);
        result = 31 * result + (sensitiveFlag != null ? sensitiveFlag.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SensitivityFlagID", referencedColumnName = "SensitiveFlagID")
    public RefDataSensitivityFlagEntity getSensitiveFlag() {
        return sensitiveFlag;
    }

    public void setSensitiveFlag(RefDataSensitivityFlagEntity sensitiveFlag) {
        this.sensitiveFlag = sensitiveFlag;
    }

    @ManyToOne
    @JoinColumn(name = "IndustryStd", referencedColumnName = "IndustryStd")
    public RefDataIndustryStdEntity getIndustryStd() {
        return industryStd;
    }

    public void setIndustryStd(RefDataIndustryStdEntity industryStd) {
        this.industryStd = industryStd;
    }

    @ManyToOne
    @JoinColumn(name = "CodeSetsID", referencedColumnName = "CodeSetsID")
    public RefDataCodeSetEntity getCodeSets() {
        return codeSets;
    }

    public void setCodeSets(RefDataCodeSetEntity codeSets) {
        this.codeSets = codeSets;
    }

    @ManyToOne
    @JoinColumn(name = "OrganizationID", referencedColumnName = "OrganizationGUID")
    public RefDataOrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(RefDataOrganizationEntity organization) {
        this.organization = organization;
    }

    @ManyToOne
    @JoinColumn(name = "VendorID", referencedColumnName = "VendorID")
    public RefDataVendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(RefDataVendorEntity vendor) {
        this.vendor = vendor;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getStatus() {
        return status;
    }

    public void setStatus(RefDataStatusEntity status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "ApplicationID", referencedColumnName = "AppGUID")
    public RefDataApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(RefDataApplicationEntity application) {
        this.application = application;
    }

    public static List<TermsCodeSetsToApplicationEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}
