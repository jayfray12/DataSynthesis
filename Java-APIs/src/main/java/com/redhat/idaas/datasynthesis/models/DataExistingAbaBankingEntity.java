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
@Table(name = "dataexisting_ababanking", schema = "datasynthesis", catalog = "")
public class DataExistingAbaBankingEntity extends io.quarkus.hibernate.orm.panache.PanacheEntityBase {
    private long abaBankingId;
    private String routingNumber;
    private String telegraphicName;
    private String customerName;
    private String city;
    private String state;
    private String zipCode;
    private Timestamp createdDate;
    private String createdUser;
    private String registeredApp;
    private RefDataStatusEntity refdataStatus;

    @Id
    @Column(name = "ABABankingID", nullable = false)
    public long getAbaBankingId() {
        return abaBankingId;
    }

    public void setAbaBankingId(long abaBankingId) {
        this.abaBankingId = abaBankingId;
    }

    @Basic
    @Column(name = "RoutingNumber", nullable = true, length = 9)
    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    @Basic
    @Column(name = "TelegraphicName", nullable = true, length = 20)
    public String getTelegraphicName() {
        return telegraphicName;
    }

    public void setTelegraphicName(String telegraphicName) {
        this.telegraphicName = telegraphicName;
    }

    @Basic
    @Column(name = "CustomerName", nullable = true, length = 36)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 20)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "State", nullable = true, length = 2)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "ZipCode", nullable = true, length = 5)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

        DataExistingAbaBankingEntity that = (DataExistingAbaBankingEntity) o;

        if (abaBankingId != that.abaBankingId) return false;
        if (routingNumber != null ? !routingNumber.equals(that.routingNumber) : that.routingNumber != null)
            return false;
        if (telegraphicName != null ? !telegraphicName.equals(that.telegraphicName) : that.telegraphicName != null)
            return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) return false;
        if (refdataStatus != null ? !refdataStatus.equals(that.refdataStatus) : that.refdataStatus != null) return false;
        if (registeredApp != null ? !registeredApp.equals(that.registeredApp) : that.registeredApp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (abaBankingId ^ (abaBankingId >>> 32));
        result = 31 * result + (routingNumber != null ? routingNumber.hashCode() : 0);
        result = 31 * result + (telegraphicName != null ? telegraphicName.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (refdataStatus != null ? refdataStatus.hashCode() : 0);
        result = 31 * result + (registeredApp != null ? registeredApp.hashCode() : 0);
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

    public static List<DataExistingAbaBankingEntity> findByStatusId(Short statusId) {
        return find("refdataStatus", new RefDataStatusEntity(statusId)).list();
    }
}
