package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "platform_rulesetsdefinitions", schema = "datasynthesis", catalog = "")
public class PlatformRulesetsdefinitionsEntity {
    private Long id;
    private String rulesetDefinitionsId;
    private String rulesetDefinitionName;
    private Long ruleSetId;
    private Short stepOrderId;
    private String operationTypeId;
    private String rulesetDefValue;
    private Short statusId;
    private Timestamp createdDate;
    private Timestamp effectiveDate;
    private String applicationId;
    private Timestamp termDate;
    private Short dataAttributeId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    @Column(name = "RuleSetID", nullable = true)
    public Long getRuleSetId() {
        return ruleSetId;
    }

    public void setRuleSetId(Long ruleSetId) {
        this.ruleSetId = ruleSetId;
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
    @Column(name = "OperationTypeID", nullable = true, length = 7)
    public String getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(String operationTypeId) {
        this.operationTypeId = operationTypeId;
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
    @Column(name = "StatusID", nullable = true)
    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
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

    @Basic
    @Column(name = "ApplicationID", nullable = true, length = 38)
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Basic
    @Column(name = "TermDate", nullable = true)
    public Timestamp getTermDate() {
        return termDate;
    }

    public void setTermDate(Timestamp termDate) {
        this.termDate = termDate;
    }

    @Basic
    @Column(name = "DataAttributeID", nullable = true)
    public Short getDataAttributeId() {
        return dataAttributeId;
    }

    public void setDataAttributeId(Short dataAttributeId) {
        this.dataAttributeId = dataAttributeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformRulesetsdefinitionsEntity that = (PlatformRulesetsdefinitionsEntity) o;

        if (rulesetDefinitionsId != null ? !rulesetDefinitionsId.equals(that.rulesetDefinitionsId) : that.rulesetDefinitionsId != null)
            return false;
        if (rulesetDefinitionName != null ? !rulesetDefinitionName.equals(that.rulesetDefinitionName) : that.rulesetDefinitionName != null)
            return false;
        if (ruleSetId != null ? !ruleSetId.equals(that.ruleSetId) : that.ruleSetId != null) return false;
        if (stepOrderId != null ? !stepOrderId.equals(that.stepOrderId) : that.stepOrderId != null) return false;
        if (operationTypeId != null ? !operationTypeId.equals(that.operationTypeId) : that.operationTypeId != null)
            return false;
        if (rulesetDefValue != null ? !rulesetDefValue.equals(that.rulesetDefValue) : that.rulesetDefValue != null)
            return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (effectiveDate != null ? !effectiveDate.equals(that.effectiveDate) : that.effectiveDate != null)
            return false;
        if (applicationId != null ? !applicationId.equals(that.applicationId) : that.applicationId != null)
            return false;
        if (termDate != null ? !termDate.equals(that.termDate) : that.termDate != null) return false;
        if (dataAttributeId != null ? !dataAttributeId.equals(that.dataAttributeId) : that.dataAttributeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rulesetDefinitionsId != null ? rulesetDefinitionsId.hashCode() : 0;
        result = 31 * result + (rulesetDefinitionName != null ? rulesetDefinitionName.hashCode() : 0);
        result = 31 * result + (ruleSetId != null ? ruleSetId.hashCode() : 0);
        result = 31 * result + (stepOrderId != null ? stepOrderId.hashCode() : 0);
        result = 31 * result + (operationTypeId != null ? operationTypeId.hashCode() : 0);
        result = 31 * result + (rulesetDefValue != null ? rulesetDefValue.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
        result = 31 * result + (applicationId != null ? applicationId.hashCode() : 0);
        result = 31 * result + (termDate != null ? termDate.hashCode() : 0);
        result = 31 * result + (dataAttributeId != null ? dataAttributeId.hashCode() : 0);
        return result;
    }
}
