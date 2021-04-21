/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.paymentMethod;

/**
 *
 * @author droperdev
 */
public class PaymentMethod {

    private int id;
    private String name;

    public PaymentMethod() {
    }

    public PaymentMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" + "id=" + id + ", name=" + name + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }
}
