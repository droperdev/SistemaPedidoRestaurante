/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import java.sql.Date;

/**
 *
 * @author droperdev
 */
public class Order {
    private int Id;
    private int ClientId;
    private int AddressId;
    private int StatusId;
    private int VoucherId;
    private int OrderTypeId;
    private int PaymentMethodId;
    private int DistributorId;
    private Date CreatedAt;
    private Date UpdatedAt;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" + "Id=" + Id + ", ClientId=" + ClientId + ", AddressId=" + AddressId + ", StatusId=" + StatusId + ", VoucherId=" + VoucherId + ", OrderTypeId=" + OrderTypeId + ", PaymentMethodId=" + PaymentMethodId + ", DistributorId=" + DistributorId + ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int StatusId) {
        this.StatusId = StatusId;
    }

    public int getVoucherId() {
        return VoucherId;
    }

    public void setVoucherId(int VoucherId) {
        this.VoucherId = VoucherId;
    }

    public int getOrderTypeId() {
        return OrderTypeId;
    }

    public void setOrderTypeId(int OrderTypeId) {
        this.OrderTypeId = OrderTypeId;
    }

    public int getPaymentMethodId() {
        return PaymentMethodId;
    }

    public void setPaymentMethodId(int PaymentMethodId) {
        this.PaymentMethodId = PaymentMethodId;
    }

    public int getDistributorId() {
        return DistributorId;
    }

    public void setDistributorId(int DistributorId) {
        this.DistributorId = DistributorId;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }
    
    
}
