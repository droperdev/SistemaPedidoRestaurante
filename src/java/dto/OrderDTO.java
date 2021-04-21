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

    private int Id;
    private ClientDTO Client;
    private AddressDTO Address;
    private Status Status;
    private Voucher Voucher;
    private OrderType OrderType;
    private PaymentMethod PaymentMethod;
    private UserDTO Distributor;
    private Date CreatedAt;
    private Date UpdatedAt;

    public OrderDTO() {
    }

    public OrderDTO(int Id, ClientDTO Client, AddressDTO Address, Status Status, Voucher Voucher, OrderType OrderType, PaymentMethod PaymentMethod, UserDTO Distributor, Date CreatedAt, Date UpdatedAt) {
        this.Id = Id;
        this.Client = Client;
        this.Address = Address;
        this.Status = Status;
        this.Voucher = Voucher;
        this.OrderType = OrderType;
        this.PaymentMethod = PaymentMethod;
        this.Distributor = Distributor;
        this.CreatedAt = CreatedAt;
        this.UpdatedAt = UpdatedAt;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "Id=" + Id + ", Client=" + Client + ", Address=" + Address + ", Status=" + Status + ", Voucher=" + Voucher + ", OrderType=" + OrderType + ", PaymentMethod=" + PaymentMethod + ", Distributor=" + Distributor + ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public ClientDTO getClient() {
        return Client;
    }

    public void setClient(ClientDTO Client) {
        this.Client = Client;
    }

    public AddressDTO getAddress() {
        return Address;
    }

    public void setAddress(AddressDTO Address) {
        this.Address = Address;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status Status) {
        this.Status = Status;
    }

    public OrderType getOrderType() {
        return OrderType;
    }

    public void setOrderType(OrderType OrderType) {
        this.OrderType = OrderType;
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

    public Voucher getVoucher() {
        return Voucher;
    }

    public void setVoucher(Voucher Voucher) {
        this.Voucher = Voucher;
    }

    public PaymentMethod getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(PaymentMethod PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public UserDTO getDistributor() {
        return Distributor;
    }

    public void setDistributor(UserDTO Distributor) {
        this.Distributor = Distributor;
    }

}
