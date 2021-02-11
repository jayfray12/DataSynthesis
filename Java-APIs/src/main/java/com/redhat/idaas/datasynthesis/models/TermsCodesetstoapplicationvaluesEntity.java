package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "terms_codesetstoapplicationvalues", schema = "datasynthesis", catalog = "")
public class TermsCodesetstoapplicationvaluesEntity {
    private Long id;
    private long codeSetToApplicationValuesId;
    private Long codeSetToApplicationId;
    private long codeSetsId;
    private Timestamp createdDate;
    private Short statusId;
    private String createdUser;
    private String termValue;
    private String termValueLow;
    private String termValueHigh;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "CodeSetToApplicationValuesID", nullable = false)
    public long getCodeSetToApplicationValuesId() {
        return codeSetToApplicationValuesId;
    }

    public void setCodeSetToApplicationValuesId(long codeSetToApplicationValuesId) {
        this.codeSetToApplicationValuesId = codeSetToApplicationValuesId;
    }

    @Basic
    @Column(name = "CodeSetToApplicationID", nullable = true)
    public Long getCodeSetToApplicationId() {
        return codeSetToApplicationId;
    }

    public void setCodeSetToApplicationId(Long codeSetToApplicationId) {
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

        TermsCodesetstoapplicationvaluesEntity that = (TermsCodesetstoapplicationvaluesEntity) o;

        if (codeSetToApplicationValuesId != that.codeSetToApplicationValuesId) return false;
        if (codeSetsId != that.codeSetsId) return false;
        if (codeSetToApplicationId != null ? !codeSetToApplicationId.equals(that.codeSetToApplicationId) : that.codeSetToApplicationId != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
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
        result = 31 * result + (codeSetToApplicationId != null ? codeSetToApplicationId.hashCode() : 0);
        result = 31 * result + (int) (codeSetsId ^ (codeSetsId >>> 32));
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (termValue != null ? termValue.hashCode() : 0);
        result = 31 * result + (termValueLow != null ? termValueLow.hashCode() : 0);
        result = 31 * result + (termValueHigh != null ? termValueHigh.hashCode() : 0);
        return result;
    }
}
