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
@Table(name = "terms_codesetstoapplication", schema = "datasynthesis", catalog = "")
public class TermsCodeSetsToApplicationEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long codeSetToApplicationId;
    private long codeSetsId;
    private String domain;
    private String specificDetails;
    private Timestamp createdDate;
    private String createdUser;
    private String messageTrigger;
    private RefDataIndustryStdEntity refdataIndustrystd;
    private RefDataStatusEntity refdataStatus;
    private RefDataOrganizationEntity refdataOrganization;
    private RefDataApplicationEntity refdataApplication;
    private RefDataVendorEntity refdataVendor;

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
    @Column(name = "MessageTrigger", nullable = true, length = 4)
    public String getMessageTrigger() {
        return messageTrigger;
    }

    public void setMessageTrigger(String messageTrigger) {
        this.messageTrigger = messageTrigger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TermsCodeSetsToApplicationEntity that = (TermsCodeSetsToApplicationEntity) o;

        if (codeSetToApplicationId != that.codeSetToApplicationId) return false;
        if (codeSetsId != that.codeSetsId) return false;
        if (domain != null ? !domain.equals(that.domain) : that.domain != null) return false;
        if (specificDetails != null ? !specificDetails.equals(that.specificDetails) : that.specificDetails != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (messageTrigger != null ? !messageTrigger.equals(that.messageTrigger) : that.messageTrigger != null)
            return false;
        if (refdataIndustrystd != null ? !refdataIndustrystd.equals(that.refdataIndustrystd) : that.refdataIndustrystd != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (refdataOrganization != null ? !refdataOrganization.equals(that.refdataOrganization) : that.refdataOrganization != null) return false;
        if (refdataApplication != null ? !refdataApplication.equals(that.refdataApplication) : that.refdataApplication != null) return false;
        if (refdataVendor != null ? !refdataVendor.equals(that.refdataVendor) : that.refdataVendor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeSetToApplicationId ^ (codeSetToApplicationId >>> 32));
        result = 31 * result + (int) (codeSetsId ^ (codeSetsId >>> 32));
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (specificDetails != null ? specificDetails.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (messageTrigger != null ? messageTrigger.hashCode() : 0);
        result = 31 * result + (refdataIndustrystd != null ? refdataIndustrystd.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (refdataOrganization != null ? refdataOrganization.hashCode() : 0);
        result = 31 * result + (refdataApplication != null ? refdataApplication.hashCode() : 0);
        result = 31 * result + (refdataVendor != null ? refdataVendor.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IndustryStd", referencedColumnName = "IndustryStd")
    public RefDataIndustryStdEntity getRefdataIndustrystd() {
        return refdataIndustrystd;
    }

    public void setRefdataIndustrystd(RefDataIndustryStdEntity refdataIndustrystd) {
        this.refdataIndustrystd = refdataIndustrystd;
    }

    @ManyToOne
    @JoinColumn(name = "OrganizationID", referencedColumnName = "OrganizationGUID")
    public RefDataOrganizationEntity getRefdataOrganization() {
        return refdataOrganization;
    }

    public void setRefdataOrganization(RefDataOrganizationEntity refdataOrganization) {
        this.refdataOrganization = refdataOrganization;
    }

    @ManyToOne
    @JoinColumn(name = "ApplicationID", referencedColumnName = "AppGUID")
    public RefDataApplicationEntity getRefdataApplication() {
        return refdataApplication;
    }

    public void setRefdataApplication(RefDataApplicationEntity refdataApplication) {
        this.refdataApplication = refdataApplication;
    }

    @ManyToOne
    @JoinColumn(name = "VendorID", referencedColumnName = "VendorID")
    public RefDataVendorEntity getRefdataVendor() {
        return refdataVendor;
    }

    public void setRefdataVendor(RefDataVendorEntity refdataVendor) {
        this.refdataVendor = refdataVendor;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<TermsCodeSetsToApplicationEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
