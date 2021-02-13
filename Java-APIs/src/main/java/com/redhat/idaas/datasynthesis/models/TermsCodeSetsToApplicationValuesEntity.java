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
@Table(name = "terms_codesetstoapplicationvalues", schema = "datasynthesis", catalog = "")
public class TermsCodeSetsToApplicationValuesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long codeSetToApplicationValuesId;
    private TermsCodeSetsToApplicationEntity codeSetToApplication;
    private RefDataCodeSetEntity codeSets;
    private Timestamp createdDate;
    private RefDataStatusEntity status;
    private String createdUser;
    private String termValue;
    private String termValueLow;
    private String termValueHigh;

    @Id
    @GeneratedValue
    @Column(name = "CodeSetToApplicationValuesID", nullable = false)
    public long getCodeSetToApplicationValuesId() {
        return codeSetToApplicationValuesId;
    }

    public void setCodeSetToApplicationValuesId(long codeSetToApplicationValuesId) {
        this.codeSetToApplicationValuesId = codeSetToApplicationValuesId;
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
    @Column(name = "TermValue", nullable = true, length = 20)
    public String getTermValue() {
        return termValue;
    }

    public void setTermValue(String termValue) {
        this.termValue = termValue;
    }

    @Basic
    @Column(name = "TermValueLow", nullable = true, length = 10)
    public String getTermValueLow() {
        return termValueLow;
    }

    public void setTermValueLow(String termValueLow) {
        this.termValueLow = termValueLow;
    }

    @Basic
    @Column(name = "TermValueHigh", nullable = true, length = 10)
    public String getTermValueHigh() {
        return termValueHigh;
    }

    public void setTermValueHigh(String termValueHigh) {
        this.termValueHigh = termValueHigh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TermsCodeSetsToApplicationValuesEntity that = (TermsCodeSetsToApplicationValuesEntity) o;

        if (codeSetToApplicationValuesId != that.codeSetToApplicationValuesId) return false;
        if (codeSets != null ? !codeSets.equals(that.codeSets) : that.codeSets != null) return false;
        if (codeSetToApplication != null ? !codeSetToApplication.equals(that.codeSetToApplication) : that.codeSetToApplication != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (termValue != null ? !termValue.equals(that.termValue) : that.termValue != null) return false;
        if (termValueLow != null ? !termValueLow.equals(that.termValueLow) : that.termValueLow != null) return false;
        if (termValueHigh != null ? !termValueHigh.equals(that.termValueHigh) : that.termValueHigh != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeSetToApplicationValuesId ^ (codeSetToApplicationValuesId >>> 32));
        result = 31 * result + (codeSetToApplication != null ? codeSetToApplication.hashCode() : 0);
        result = 31 * result + (codeSets != null ? codeSets.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (termValue != null ? termValue.hashCode() : 0);
        result = 31 * result + (termValueLow != null ? termValueLow.hashCode() : 0);
        result = 31 * result + (termValueHigh != null ? termValueHigh.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "CodeSetToApplicationID", referencedColumnName = "CodeSetToApplicationID")
    public TermsCodeSetsToApplicationEntity getCodeSetToApplication() {
        return codeSetToApplication;
    }

    public void setCodeSetToApplication(TermsCodeSetsToApplicationEntity codeSetToApplication) {
        this.codeSetToApplication = codeSetToApplication;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getStatus() {
        return status;
    }

    public void setStatus(RefDataStatusEntity status) {
        this.status = status;
    }

    public static List<TermsCodeSetsToApplicationValuesEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}
