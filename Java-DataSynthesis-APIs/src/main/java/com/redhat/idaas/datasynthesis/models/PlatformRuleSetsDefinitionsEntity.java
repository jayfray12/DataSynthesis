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
@Table(name = "platform_rulesetsdefinitions", schema = "datasynthesis", catalog = "")
public class PlatformRuleSetsDefinitionsEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private String rulesetDefinitionsId;
    private String rulesetDefinitionName;
    private Short stepOrderId;
    private String rulesetDefValue;
    private Timestamp createdDate;
    private Timestamp effectiveDate;
    private PlatformRuleSetsEntity platformRulesets;
    private RefDataOperationTypeEntity refdataOperationtype;
    private RefDataStatusEntity refdataStatus;
    private RefDataApplicationEntity refdataApplication;

    @Id
    @Column(name = "RulesetDefinitionsID", nullable = false, length = 38)
    public String getRulesetDefinitionsId() {
        return rulesetDefinitionsId;
    }

    public void setRulesetDefinitionsId(String rulesetDefinitionsId) {
        this.rulesetDefinitionsId = rulesetDefinitionsId;
    }

    @Basic
    @Column(name = "RulesetDefinitionName", nullable = true, length = 50)
    public String getRulesetDefinitionName() {
        return rulesetDefinitionName;
    }

    public void setRulesetDefinitionName(String rulesetDefinitionName) {
        this.rulesetDefinitionName = rulesetDefinitionName;
    }

    @Basic
    @Column(name = "StepOrderID", nullable = true)
    public Short getStepOrderId() {
        return stepOrderId;
    }

    public void setStepOrderId(Short stepOrderId) {
        this.stepOrderId = stepOrderId;
    }

    @Basic
    @Column(name = "RulesetDefValue", nullable = true, length = 40)
    public String getRulesetDefValue() {
        return rulesetDefValue;
    }

    public void setRulesetDefValue(String rulesetDefValue) {
        this.rulesetDefValue = rulesetDefValue;
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
    @Column(name = "EffectiveDate", nullable = true)
    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformRuleSetsDefinitionsEntity that = (PlatformRuleSetsDefinitionsEntity) o;

        if (rulesetDefinitionsId != null ? !rulesetDefinitionsId.equals(that.rulesetDefinitionsId) : that.rulesetDefinitionsId != null)
            return false;
        if (rulesetDefinitionName != null ? !rulesetDefinitionName.equals(that.rulesetDefinitionName) : that.rulesetDefinitionName != null)
            return false;
        if (stepOrderId != null ? !stepOrderId.equals(that.stepOrderId) : that.stepOrderId != null) return false;
        if (rulesetDefValue != null ? !rulesetDefValue.equals(that.rulesetDefValue) : that.rulesetDefValue != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (effectiveDate != null ? !effectiveDate.equals(that.effectiveDate) : that.effectiveDate != null)
            return false;
        if (platformRulesets != null ? !platformRulesets.equals(that.platformRulesets) : that.platformRulesets != null) return false;
        if (refdataOperationtype != null ? !refdataOperationtype.equals(that.refdataOperationtype) : that.refdataOperationtype != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (refdataApplication != null ? !refdataApplication.equals(that.refdataApplication) : that.refdataApplication != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rulesetDefinitionsId != null ? rulesetDefinitionsId.hashCode() : 0;
        result = 31 * result + (rulesetDefinitionName != null ? rulesetDefinitionName.hashCode() : 0);
        result = 31 * result + (stepOrderId != null ? stepOrderId.hashCode() : 0);
        result = 31 * result + (rulesetDefValue != null ? rulesetDefValue.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
        result = 31 * result + (platformRulesets != null ? platformRulesets.hashCode() : 0);
        result = 31 * result + (refdataOperationtype != null ? refdataOperationtype.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (refdataApplication != null ? refdataApplication.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "RuleSetID", referencedColumnName = "RuleID")
    public PlatformRuleSetsEntity getPlatformRulesets() {
        return platformRulesets;
    }

    public void setPlatformRulesets(PlatformRuleSetsEntity platformRulesets) {
        this.platformRulesets = platformRulesets;
    }

    @ManyToOne
    @JoinColumn(name = "OperationTypeID", referencedColumnName = "OperationTypeID")
    public RefDataOperationTypeEntity getRefdataOperationtype() {
        return refdataOperationtype;
    }

    public void setRefdataOperationtype(RefDataOperationTypeEntity refdataOperationtype) {
        this.refdataOperationtype = refdataOperationtype;
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
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<PlatformRuleSetsDefinitionsEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
