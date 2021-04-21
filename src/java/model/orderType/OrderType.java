/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.orderType;

public class OrderType {
    private int Id;
    private String Name;

    public OrderType() {
    }

    public OrderType(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "OrderType{" + "Id=" + Id + ", Name=" + Name + '}';
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
}
