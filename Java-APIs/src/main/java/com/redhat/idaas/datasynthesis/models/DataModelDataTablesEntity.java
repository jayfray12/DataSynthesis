package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "datamodel_datatables", schema = "datasynthesis", catalog = "")
public class DataModelDataTablesEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private String tableName;
    private String tableInformation;
    private Short statusId;
    private Timestamp createdDate;

    @Id
    @Column(name = "TableName", nullable = false, length = 64)
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "TableInformation", nullable = true, length = 249)
    public String getTableInformation() {
        return tableInformation;
    }

    public void setTableInformation(String tableInformation) {
        this.tableInformation = tableInformation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataModelDataTablesEntity that = (DataModelDataTablesEntity) o;

        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (tableInformation != null ? !tableInformation.equals(that.tableInformation) : that.tableInformation != null)
            return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableName != null ? tableName.hashCode() : 0;
        result = 31 * result + (tableInformation != null ? tableInformation.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
