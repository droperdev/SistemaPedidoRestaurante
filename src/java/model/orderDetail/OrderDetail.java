/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.orderDetail;

import java.sql.Date;

/**
 *
 * @author droperdev
 */
public class OrderDetail {

    private int Id;
    private int OrderId;
    private int ProductId;
    private int Quantity;
    private Double price;
    private Date CreatedAt;

    public OrderDetail() {
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "Id=" + Id + ", OrderId=" + OrderId + ", ProductId=" + ProductId + ", Quantity=" + Quantity + ", price=" + price + ", CreatedAt=" + CreatedAt + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

}
