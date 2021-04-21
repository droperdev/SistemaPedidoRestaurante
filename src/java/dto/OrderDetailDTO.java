/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author droperdev
 */
public class OrderDetailDTO {

    private int id;
    private ProductDTO product;
    private int quantity;
    private Double price;
    private Date createdAt;

    public OrderDetailDTO() {
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "id=" + id + ", product=" + product + ", quantity=" + quantity + ", price=" + price + ", createdAt=" + createdAt + '}';
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
 
   
}
