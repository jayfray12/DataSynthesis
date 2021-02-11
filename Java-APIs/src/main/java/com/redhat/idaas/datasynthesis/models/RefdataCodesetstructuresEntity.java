package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "refdata_codesetstructures", schema = "datasynthesis", catalog = "")
public class RefdataCodesetstructuresEntity {
    private Long id;
    private long codeSetStructuresId;
    private String codeSetStructureName;
    private String industryStd;
    private Short statusId;
    private Timestamp createdDate;
    private String createdUser;
    private String codesetStructureGuid;
    private String field1Value;
    private String field2Value;
    private String field3Value;
    private String field4Value;
    private String field5Value;
    private String field6Value;
    private String field7Value;
    private String field8Value;
    private String field9Value;
    private Short sensitivityFlagId;
    private Long codesetsId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "CodeSetStructuresID", nullable = false)
    public long getCodeSetStructuresId() {
        return codeSetStructuresId;
    }

    public void setCodeSetStructuresId(long codeSetStructuresId) {
        this.codeSetStructuresId = codeSetStructuresId;
    }

    @Basic
    @Column(name = "CodeSetStructureName", nullable = true, length = 50)
    public String getCodeSetStructureName() {
        return codeSetStructureName;
    }

    public void setCodeSetStructureName(String codeSetStructureName) {
        this.codeSetStructureName = codeSetStructureName;
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
    @Column(name = "CreatedUser", nullable = true, length = 20)
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Basic
    @Column(name = "CodesetStructureGUID", nullable = true, length = 38)
    public String getCodesetStructureGuid() {
        return codesetStructureGuid;
    }

    public void setCodesetStructureGuid(String codesetStructureGuid) {
        this.codesetStructureGuid = codesetStructureGuid;
    }

    @Basic
    @Column(name = "Field1Value", nullable = true, length = 75)
    public String getField1Value() {
        return field1Value;
    }

    public void setField1Value(String field1Value) {
        this.field1Value = field1Value;
    }

    @Basic
    @Column(name = "Field2Value", nullable = true, length = 75)
    public String getField2Value() {
        return field2Value;
    }

    public void setField2Value(String field2Value) {
        this.field2Value = field2Value;
    }

    @Basic
    @Column(name = "Field3Value", nullable = true, length = 75)
    public String getField3Value() {
        return field3Value;
    }

    public void setField3Value(String field3Value) {
        this.field3Value = field3Value;
    }

    @Basic
    @Column(name = "Field4Value", nullable = true, length = 75)
    public String getField4Value() {
        return field4Value;
    }

    public void setField4Value(String field4Value) {
        this.field4Value = field4Value;
    }

    @Basic
    @Column(name = "Field5Value", nullable = true, length = 75)
    public String getField5Value() {
        return field5Value;
    }

    public void setField5Value(String field5Value) {
        this.field5Value = field5Value;
    }

    @Basic
    @Column(name = "Field6Value", nullable = true, length = 75)
    public String getField6Value() {
        return field6Value;
    }

    public void setField6Value(String field6Value) {
        this.field6Value = field6Value;
    }

    @Basic
    @Column(name = "Field7Value", nullable = true, length = 75)
    public String getField7Value() {
        return field7Value;
    }

    public void setField7Value(String field7Value) {
        this.field7Value = field7Value;
    }

    @Basic
    @Column(name = "Field8Value", nullable = true, length = 75)
    public String getField8Value() {
        return field8Value;
    }

    public void setField8Value(String field8Value) {
        this.field8Value = field8Value;
    }

    @Basic
    @Column(name = "Field9Value", nullable = true, length = 75)
    public String getField9Value() {
        return field9Value;
    }

    public void setField9Value(String field9Value) {
        this.field9Value = field9Value;
    }

    @Basic
    @Column(name = "SensitivityFlagID", nullable = true)
    public Short getSensitivityFlagId() {
        return sensitivityFlagId;
    }

    public void setSensitivityFlagId(Short sensitivityFlagId) {
        this.sensitivityFlagId = sensitivityFlagId;
    }

    @Basic
    @Column(name = "CodesetsID", nullable = true)
    public Long getCodesetsId() {
        return codesetsId;
    }

    public void setCodesetsId(Long codesetsId) {
        this.codesetsId = codesetsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefdataCodesetstructuresEntity that = (RefdataCodesetstructuresEntity) o;

        if (codeSetStructuresId != that.codeSetStructuresId) return false;
        if (codeSetStructureName != null ? !codeSetStructureName.equals(that.codeSetStructureName) : that.codeSetStructureName != null)
            return false;
        if (industryStd != null ? !industryStd.equals(that.industryStd) : that.industryStd != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (codesetStructureGuid != null ? !codesetStructureGuid.equals(that.codesetStructureGuid) : that.codesetStructureGuid != null)
            return false;
        if (field1Value != null ? !field1Value.equals(that.field1Value) : that.field1Value != null) return false;
        if (field2Value != null ? !field2Value.equals(that.field2Value) : that.field2Value != null) return false;
        if (field3Value != null ? !field3Value.equals(that.field3Value) : that.field3Value != null) return false;
        if (field4Value != null ? !field4Value.equals(that.field4Value) : that.field4Value != null) return false;
        if (field5Value != null ? !field5Value.equals(that.field5Value) : that.field5Value != null) return false;
        if (field6Value != null ? !field6Value.equals(that.field6Value) : that.field6Value != null) return false;
        if (field7Value != null ? !field7Value.equals(that.field7Value) : that.field7Value != null) return false;
        if (field8Value != null ? !field8Value.equals(that.field8Value) : that.field8Value != null) return false;
        if (field9Value != null ? !field9Value.equals(that.field9Value) : that.field9Value != null) return false;
        if (sensitivityFlagId != null ? !sensitivityFlagId.equals(that.sensitivityFlagId) : that.sensitivityFlagId != null)
            return false;
        if (codesetsId != null ? !codesetsId.equals(that.codesetsId) : that.codesetsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeSetStructuresId ^ (codeSetStructuresId >>> 32));
        result = 31 * result + (codeSetStructureName != null ? codeSetStructureName.hashCode() : 0);
        result = 31 * result + (industryStd != null ? industryStd.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (codesetStructureGuid != null ? codesetStructureGuid.hashCode() : 0);
        result = 31 * result + (field1Value != null ? field1Value.hashCode() : 0);
        result = 31 * result + (field2Value != null ? field2Value.hashCode() : 0);
        result = 31 * result + (field3Value != null ? field3Value.hashCode() : 0);
        result = 31 * result + (field4Value != null ? field4Value.hashCode() : 0);
        result = 31 * result + (field5Value != null ? field5Value.hashCode() : 0);
        result = 31 * result + (field6Value != null ? field6Value.hashCode() : 0);
        result = 31 * result + (field7Value != null ? field7Value.hashCode() : 0);
        result = 31 * result + (field8Value != null ? field8Value.hashCode() : 0);
        result = 31 * result + (field9Value != null ? field9Value.hashCode() : 0);
        result = 31 * result + (sensitivityFlagId != null ? sensitivityFlagId.hashCode() : 0);
        result = 31 * result + (codesetsId != null ? codesetsId.hashCode() : 0);
        return result;
    }
}
