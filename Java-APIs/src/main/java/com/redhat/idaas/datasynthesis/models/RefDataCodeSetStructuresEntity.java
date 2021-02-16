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
@Table(name = "refdata_codesetstructures", schema = "datasynthesis", catalog = "")
public class RefDataCodeSetStructuresEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long codeSetStructuresId;
    private String codeSetStructureName;
    private RefDataIndustryStdEntity industryStd;
    private RefDataStatusEntity status;
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
    private RefDataSensitivityFlagEntity sensitivityFlag;
    private RefDataCodeSetEntity codeSet;

    @Id
    @GeneratedValue
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefDataCodeSetStructuresEntity that = (RefDataCodeSetStructuresEntity) o;

        if (codeSetStructuresId != that.codeSetStructuresId) return false;
        if (codeSetStructureName != null ? !codeSetStructureName.equals(that.codeSetStructureName) : that.codeSetStructureName != null)
            return false;
        if (industryStd != null ? !industryStd.equals(that.industryStd) : that.industryStd != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
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
        if (sensitivityFlag != null ? !sensitivityFlag.equals(that.sensitivityFlag) : that.sensitivityFlag != null)
            return false;
        if (codeSet != null ? !codeSet.equals(that.codeSet) : that.codeSet != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeSetStructuresId ^ (codeSetStructuresId >>> 32));
        result = 31 * result + (codeSetStructureName != null ? codeSetStructureName.hashCode() : 0);
        result = 31 * result + (industryStd != null ? industryStd.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
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
        result = 31 * result + (sensitivityFlag != null ? sensitivityFlag.hashCode() : 0);
        result = 31 * result + (codeSet != null ? codeSet.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CodesetsID", referencedColumnName = "CodeSetsID")
    public RefDataCodeSetEntity getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(RefDataCodeSetEntity codeSet) {
        this.codeSet = codeSet;
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
    @JoinColumn(name = "SensitivityFlagID", referencedColumnName = "SensitiveFlagID")
    public RefDataSensitivityFlagEntity getSensitivityFlag() {
        return sensitivityFlag;
    }

    public void setSensitivityFlag(RefDataSensitivityFlagEntity sensitivityFlag) {
        this.sensitivityFlag = sensitivityFlag;
    }

    @ManyToOne
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    public RefDataStatusEntity getStatus() {
        return status;
    }

    public void setStatus(RefDataStatusEntity status) {
        this.status = status;
    }

    public static List<RefDataCodeSetStructuresEntity> findByStatusId(Short statusId) {
        return find("status", new RefDataStatusEntity(statusId)).list();
    }
}
