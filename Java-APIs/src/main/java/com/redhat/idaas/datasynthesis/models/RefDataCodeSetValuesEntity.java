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
@Table(name = "refdata_codesetvalues", schema = "datasynthesis", catalog = "")
public class RefDataCodeSetValuesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long codeSetValueId;
    private String qtyValue;
    private String qtyValueDesc;
    private Timestamp createdDate;
    private RefDataCodesetEntity refdataCodeset;
    private RefDataApplicationEntity refdataApplication;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "CodeSetValueID", nullable = false)
    public long getCodeSetValueId() {
        return codeSetValueId;
    }

    public void setCodeSetValueId(long codeSetValueId) {
        this.codeSetValueId = codeSetValueId;
    }

    @Basic
    @Column(name = "QtyValue", nullable = true, length = 20)
    public String getQtyValue() {
        return qtyValue;
    }

    public void setQtyValue(String qtyValue) {
        this.qtyValue = qtyValue;
    }

    @Basic
    @Column(name = "QtyValueDesc", nullable = true, length = 20)
    public String getQtyValueDesc() {
        return qtyValueDesc;
    }

    public void setQtyValueDesc(String qtyValueDesc) {
        this.qtyValueDesc = qtyValueDesc;
    }

    @Basic
    @Column(name = "CreatedDate", nullable = true)
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

        RefDataCodeSetValuesEntity that = (RefDataCodeSetValuesEntity) o;

        if (codeSetValueId != that.codeSetValueId) return false;
        if (qtyValue != null ? !qtyValue.equals(that.qtyValue) : that.qtyValue != null) return false;
        if (qtyValueDesc != null ? !qtyValueDesc.equals(that.qtyValueDesc) : that.qtyValueDesc != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (refdataCodeset != null ? !refdataCodeset.equals(that.refdataCodeset) : that.refdataCodeset != null) return false;
        if (refdataApplication != null ? !refdataApplication.equals(that.refdataApplication) : that.refdataApplication != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeSetValueId ^ (codeSetValueId >>> 32));
        result = 31 * result + (qtyValue != null ? qtyValue.hashCode() : 0);
        result = 31 * result + (qtyValueDesc != null ? qtyValueDesc.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (refdataCodeset != null ? refdataCodeset.hashCode() : 0);
        result = 31 * result + (refdataApplication != null ? refdataApplication.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CodesetID", referencedColumnName = "CodeSetsID")
    public RefDataCodesetEntity getRefdataCodeset() {
        return refdataCodeset;
    }

    public void setRefdataCodeset(RefDataCodesetEntity refdataCodeset) {
        this.refdataCodeset = refdataCodeset;
    }

    @ManyToOne
    @JoinColumn(name = "ApplicationGUID", referencedColumnName = "AppGUID")
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

    public static List<RefDataCodeSetValuesEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
