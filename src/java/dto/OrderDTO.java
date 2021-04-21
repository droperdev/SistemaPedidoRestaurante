/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import model.orderType.OrderType;
import model.paymentMethod.PaymentMethod;
import model.status.Status;
import model.voucher.Voucher;

/**
 *
 * @author droperdev
 */
public class OrderDTO {

    private int id;
    private ClientDTO client;
    private AddressDTO address;
    private Status status;
    private Voucher voucher;
    private OrderType orderType;
    private PaymentMethod paymentMethod;
    private UserDTO distributor;
    private Double total;
    private Date createdAt;
    private Date updatedAt;

    public OrderDTO() {
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "id=" + id + ", client=" + client + ", address=" + address + ", status=" + status + ", voucher=" + voucher + ", orderType=" + orderType + ", paymentMethod=" + paymentMethod + ", distributor=" + distributor + ", total=" + total + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public UserDTO getDistributor() {
        return distributor;
    }

    public void setDistributor(UserDTO distributor) {
        this.distributor = distributor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
