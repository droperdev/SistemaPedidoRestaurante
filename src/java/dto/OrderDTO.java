/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import model.paymentMethod.PaymentMethod;
import model.voucher.Voucher;

/**
 *
 * @author droperdev
 */
public class OrderDTO {

    private int Id;
    private ClientDTO Client;
    private int AddressId;
    private int StatusId;
    private Voucher Voucher;
    private int OrderTypeId;
    private PaymentMethod PaymentMethod;
    private UserDTO Distributor;
    private Date CreatedAt;
    private Date UpdatedAt;

    public OrderDTO() {
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "Id=" + Id + ", Client=" + Client + ", AddressId=" + AddressId + ", StatusId=" + StatusId + ", Voucher=" + Voucher + ", OrderTypeId=" + OrderTypeId + ", PaymentMethod=" + PaymentMethod + ", Distributor=" + Distributor + ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + '}';
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

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
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

    public int getStatusId() {
        return StatusId;
    }

    public void setStatusId(int StatusId) {
        this.StatusId = StatusId;
    }

    public UserDTO getDistributor() {
        return Distributor;
    }

    public void setDistributor(UserDTO Distributor) {
        this.Distributor = Distributor;
    }
    

}
