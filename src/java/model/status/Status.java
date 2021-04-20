/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.status;

/**
 *
 * @author IVAN
 */
public class Status {
    private int id;
    private String Name ;

    @Override
    public String toString() {
        return "Status{" + "id=" + id + ", Name=" + Name + '}';
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
    
}
