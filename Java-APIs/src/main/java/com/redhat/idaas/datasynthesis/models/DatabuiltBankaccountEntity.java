package com.redhat.idaas.datasynthesis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "databuilt_bankaccount", schema = "datasynthesis", catalog = "")
public class DatabuiltBankaccountEntity {
    private Long id;
    private long dataBuiltBankAccountsId;
    private String bankAccountNumber;
    private String bankAccountName;
    private String bankRoutingId;
    private Timestamp createdDate;
    private Short statusId;
    private String registeredApp;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "DataBuiltBankAccountsID", nullable = false)
    public long getDataBuiltBankAccountsId() {
        return dataBuiltBankAccountsId;
    }

    public void setDataBuiltBankAccountsId(long dataBuiltBankAccountsId) {
        this.dataBuiltBankAccountsId = dataBuiltBankAccountsId;
    }

    @Basic
    @Column(name = "BankAccountNumber", nullable = true, length = 12)
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Basic
    @Column(name = "BankAccountName", nullable = true, length = 75)
    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    @Basic
    @Column(name = "BankRoutingID", nullable = true, length = 9)
    public String getBankRoutingId() {
        return bankRoutingId;
    }

    public void setBankRoutingId(String bankRoutingId) {
        this.bankRoutingId = bankRoutingId;
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
    @Column(name = "RegisteredApp", nullable = true, length = 38)
    public String getRegisteredApp() {
        return registeredApp;
    }

    public void setRegisteredApp(String registeredApp) {
        this.registeredApp = registeredApp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatabuiltBankaccountEntity that = (DatabuiltBankaccountEntity) o;

        if (dataBuiltBankAccountsId != that.dataBuiltBankAccountsId) return false;
        if (bankAccountNumber != null ? !bankAccountNumber.equals(that.bankAccountNumber) : that.bankAccountNumber != null)
            return false;
        if (bankAccountName != null ? !bankAccountName.equals(that.bankAccountName) : that.bankAccountName != null)
            return false;
        if (bankRoutingId != null ? !bankRoutingId.equals(that.bankRoutingId) : that.bankRoutingId != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dataBuiltBankAccountsId ^ (dataBuiltBankAccountsId >>> 32));
        result = 31 * result + (bankAccountNumber != null ? bankAccountNumber.hashCode() : 0);
        result = 31 * result + (bankAccountName != null ? bankAccountName.hashCode() : 0);
        result = 31 * result + (bankRoutingId != null ? bankRoutingId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
        return result;
    }
}
