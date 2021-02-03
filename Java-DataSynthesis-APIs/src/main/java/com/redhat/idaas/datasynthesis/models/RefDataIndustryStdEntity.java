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
@Table(name = "refdata_industrystd", schema = "datasynthesis", catalog = "")
public class RefDataIndustryStdEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private String industryStd;
    private String industryStdDesc;
    private Timestamp createdDate;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "IndustryStd", nullable = false, length = 6)
    public String getIndustryStd() {
        return industryStd;
    }

    public void setIndustryStd(String industryStd) {
        this.industryStd = industryStd;
    }

    @Basic
    @Column(name = "IndustryStdDesc", nullable = true, length = 30)
    public String getIndustryStdDesc() {
        return industryStdDesc;
    }

    public void setIndustryStdDesc(String industryStdDesc) {
        this.industryStdDesc = industryStdDesc;
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

        RefDataIndustryStdEntity that = (RefDataIndustryStdEntity) o;

        if (industryStd != null ? !industryStd.equals(that.industryStd) : that.industryStd != null) return false;
        if (industryStdDesc != null ? !industryStdDesc.equals(that.industryStdDesc) : that.industryStdDesc != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = industryStd != null ? industryStd.hashCode() : 0;
        result = 31 * result + (industryStdDesc != null ? industryStdDesc.hashCode() : 0);
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

    public static List<RefDataIndustryStdEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
