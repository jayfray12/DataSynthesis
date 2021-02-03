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
@Table(name = "platform_rulesetsattributes", schema = "datasynthesis", catalog = "")
public class PlatformRulesetsAttributesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long rulesetAttributeId;
    private String ruleSetAttributeDesc;
    private Timestamp createdDate;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "RulesetAttributeID", nullable = false)
    public long getRulesetAttributeId() {
        return rulesetAttributeId;
    }

    public void setRulesetAttributeId(long rulesetAttributeId) {
        this.rulesetAttributeId = rulesetAttributeId;
    }

    @Basic
    @Column(name = "RuleSetAttributeDesc", nullable = true, length = 75)
    public String getRuleSetAttributeDesc() {
        return ruleSetAttributeDesc;
    }

    public void setRuleSetAttributeDesc(String ruleSetAttributeDesc) {
        this.ruleSetAttributeDesc = ruleSetAttributeDesc;
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

        PlatformRulesetsAttributesEntity that = (PlatformRulesetsAttributesEntity) o;

        if (rulesetAttributeId != that.rulesetAttributeId) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (ruleSetAttributeDesc != null ? !ruleSetAttributeDesc.equals(that.ruleSetAttributeDesc) : that.ruleSetAttributeDesc != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rulesetAttributeId ^ (rulesetAttributeId >>> 32));
        result = 31 * result + (ruleSetAttributeDesc != null ? ruleSetAttributeDesc.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getRefdataStatus() {
        return refdataStatus;
    }

    public void setRefdataStatus(RefDataStatusEntity refdataStatus) {
        this.refdataStatus = refdataStatus;
    }

    public static List<PlatformRulesetsAttributesEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
