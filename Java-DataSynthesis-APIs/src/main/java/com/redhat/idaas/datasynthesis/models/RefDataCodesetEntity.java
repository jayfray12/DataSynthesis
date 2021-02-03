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
@Table(name = "refdata_codeset", schema = "datasynthesis", catalog = "")
public class RefDataCodesetEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long codeSetsId;
    private String codeSetName;
    private String industryStd;
    private Timestamp createdDate;
    private String createdUser;
    private String codesetGuid;
    private String fieldMapping;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "CodeSetsID", nullable = false)
    public long getCodeSetsId() {
        return codeSetsId;
    }

    public void setCodeSetsId(long codeSetsId) {
        this.codeSetsId = codeSetsId;
    }

    @Basic
    @Column(name = "CodeSetName", nullable = true, length = 50)
    public String getCodeSetName() {
        return codeSetName;
    }

    public void setCodeSetName(String codeSetName) {
        this.codeSetName = codeSetName;
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
    @Column(name = "CodesetGUID", nullable = true, length = 38)
    public String getCodesetGuid() {
        return codesetGuid;
    }

    public void setCodesetGuid(String codesetGuid) {
        this.codesetGuid = codesetGuid;
    }

    @Basic
    @Column(name = "FieldMapping", nullable = true, length = 20)
    public String getFieldMapping() {
        return fieldMapping;
    }

    public void setFieldMapping(String fieldMapping) {
        this.fieldMapping = fieldMapping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefDataCodesetEntity that = (RefDataCodesetEntity) o;

        if (codeSetsId != that.codeSetsId) return false;
        if (codeSetName != null ? !codeSetName.equals(that.codeSetName) : that.codeSetName != null) return false;
        if (industryStd != null ? !industryStd.equals(that.industryStd) : that.industryStd != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (codesetGuid != null ? !codesetGuid.equals(that.codesetGuid) : that.codesetGuid != null) return false;
        if (fieldMapping != null ? !fieldMapping.equals(that.fieldMapping) : that.fieldMapping != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeSetsId ^ (codeSetsId >>> 32));
        result = 31 * result + (codeSetName != null ? codeSetName.hashCode() : 0);
        result = 31 * result + (industryStd != null ? industryStd.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (codesetGuid != null ? codesetGuid.hashCode() : 0);
        result = 31 * result + (fieldMapping != null ? fieldMapping.hashCode() : 0);
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

    public static List<RefDataCodesetEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
