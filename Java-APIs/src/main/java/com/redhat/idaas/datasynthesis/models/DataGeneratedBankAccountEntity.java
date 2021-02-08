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
@Table(name = "datagenerated_bankaccount", schema = "datasynthesis", catalog = "")
public class DataGeneratedBankAccountEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long bankAccountsId;
    private String bankAccountValue;
    private Timestamp createdDate;
    private String createdUser;
    private String registeredApp;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "BankAccountsID", nullable = false)
    public long getBankAccountsId() {
        return bankAccountsId;
    }

    public void setBankAccountsId(long bankAccountsId) {
        this.bankAccountsId = bankAccountsId;
    }

    @Basic
    @Column(name = "BankAccountValue", nullable = true, length = 17)
    public String getBankAccountValue() {
        return bankAccountValue;
    }

    public void setBankAccountValue(String bankAccountValue) {
        this.bankAccountValue = bankAccountValue;
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

        DataGeneratedBankAccountEntity that = (DataGeneratedBankAccountEntity) o;

        if (bankAccountsId != that.bankAccountsId) return false;
        if (bankAccountValue != null ? !bankAccountValue.equals(that.bankAccountValue) : that.bankAccountValue != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bankAccountsId ^ (bankAccountsId >>> 32));
        result = 31 * result + (bankAccountValue != null ? bankAccountValue.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
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

    public static List<DataGeneratedBankAccountEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
